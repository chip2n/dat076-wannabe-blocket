package com.wannabeblocket.ah.servlets;

import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Page;
import com.wannabeblocket.core.constants.Parameter;
import com.wannabeblocket.core.constants.Servlet;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Listing;

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
            String title = this.getParameter(Parameter.TITLE);
            Long categoryId = this.getParameterAsLong(Parameter.CATEGORY);
            String description = this.getParameter(Parameter.DESCRIPTION);       
            Category category = this.getShop().getCategoryList().find(categoryId);
            Listing listing = new Listing(this.getUser(), title, description, new Date(), category);
            
            this.getShop().getAuctionHouse().add(listing);
            this.redirect(Page.MAIN);
        }   
        else {
            this.forward(Page.MAIN);
        }        
    }
}
