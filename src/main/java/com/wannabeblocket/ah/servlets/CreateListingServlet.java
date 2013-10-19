package com.wannabeblocket.ah.servlets;

import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Pages;
import com.wannabeblocket.core.constants.Servlets;
import com.wannabeblocket.model.Account;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.Shop;

@WebServlet(urlPatterns = {"/" + Servlets.CREATE_LISTING})
public class CreateListingServlet extends ServletBase {
    @Override
    protected void doGet() throws ServletException, IOException {
        if(this.isUserLoggedIn()){
            this.forward(Pages.CREATE_LISTING);
        }   
        else {
            this.forward(Pages.MAIN);
        }
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        if(this.isUserLoggedIn()){
            String title = this.getRequest().getParameter("title");
            Long categoryId = Long.parseLong(this.getRequest().getParameter("category"));
            String description = this.getRequest().getParameter("description");
            
            Category category = Shop.getInstance().getCategoryList().find(categoryId);

            Listing listing = new Listing(this.getUser(), title, description, new Date(), category);
            Shop.getInstance(Shop.Mode.Release).getAuctionHouse().add(listing);

            this.getResponse().sendRedirect(Pages.MAIN);
        }   
        else {
            this.forward(Pages.MAIN);
        }        
    }
}
