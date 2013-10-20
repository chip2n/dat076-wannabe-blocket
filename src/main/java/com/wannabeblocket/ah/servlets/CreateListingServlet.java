package com.wannabeblocket.ah.servlets;

import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Page;
import com.wannabeblocket.core.constants.Servlet;
import com.wannabeblocket.model.Account;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.Shop;

@WebServlet(urlPatterns = {"/" + Servlet.CREATE_LISTING})
public class CreateListingServlet extends ServletBase {
    @Override
    protected void doGet() throws ServletException, IOException {
        if(this.isUserLoggedIn()){
            this.forward(Page.CREATE_LISTING);
        }   
        else {
            this.forward(Page.MAIN);
        }
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        if(this.isUserLoggedIn()){
            String title = this.getRequest().getParameter("title");
            Long categoryId = Long.parseLong(this.getRequest().getParameter("category"));
            String description = this.getRequest().getParameter("description");

            Listing listing = new Listing(new Account("TEMP_ACCOUNT", "TEMP_PASSWORD"), title, description, new Date(), new Category("TEMP_CATEGORY"));
            Shop.getInstance(Shop.Mode.Release).getAuctionHouse().add(listing);

            this.getResponse().sendRedirect(Page.MAIN);
        }   
        else {
            this.forward(Page.MAIN);
        }        
    }
}
