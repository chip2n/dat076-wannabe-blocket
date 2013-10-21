package com.wannabeblocket.ah.servlets;

import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Page;
import com.wannabeblocket.core.constants.Parameter;
import com.wannabeblocket.core.constants.RequestAttribute;
import com.wannabeblocket.core.constants.Servlet;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Listing;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String dateString = this.getParameter(Parameter.DATE);
            String clockString = this.getParameter(Parameter.CLOCK);
            
            this.getRequest().setAttribute(RequestAttribute.TITLE, title);
            this.getRequest().setAttribute(RequestAttribute.DESCRIPTION, description); 
            
            if(title.isEmpty()) {
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Titel är obligatoriskt.");
                this.forward(Page.CREATE_LISTING);  
                return;
            }
            
            // Create a date object
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = null;
            try {
                date = format.parse(dateString + " " + clockString);
            } catch (ParseException ex) {
                Logger.getLogger(CreateListingServlet.class.getName()).log(Level.SEVERE, null, ex);
                       
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Du måste fylla i datumet och tiden korrekt.");
                this.forward(Page.CREATE_LISTING);  
                return;
            }
            
            Category category = this.getShop().getCategoryList().find(categoryId);
            Listing listing = new Listing(this.getUser(), title, description, date, category);
            
            
            this.getShop().getAuctionHouse().add(listing);
            this.redirect(Page.MAIN);
        }   
        else {
            this.forward(Page.MAIN);
        }        
    }
}
