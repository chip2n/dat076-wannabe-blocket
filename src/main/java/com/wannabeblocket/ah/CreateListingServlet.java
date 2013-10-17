/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.ah;

import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.navigation.NavigationNode;
import com.wannabeblocket.model.Account;
import com.wannabeblocket.model.AuctionHouse;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.Shop;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Aram Timofeitchik
 * @author Andreas Arvidsson
 */
@WebServlet(name = "CreateListingServlet", urlPatterns = {"/createlisting"})
public class CreateListingServlet extends ServletBase {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet() throws ServletException, IOException {
        this.getRequest().getRequestDispatcher("/create_listing.jsp").forward(this.getRequest(), this.getResponse());
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost() throws ServletException, IOException {
        String title = this.getRequest().getParameter("title");
        Long categoryId = Long.parseLong(this.getRequest().getParameter("categories"));
        String description = this.getRequest().getParameter("description");
        
        Category category = Shop.getInstance().getCategoryList().find(categoryId);
        
        if(category != null) {
            AuctionHouse ah = Shop.getInstance().getAuctionHouse();
            Listing listing = new Listing(
                    new Account("TempUserName"),
                    description,
                    new Date(),
                    new Category("TEMP_CATEGORY", categoryId)
            );
            ah.add(listing);

            this.getResponse().sendRedirect("");
        } else {
            // TODO: Send user to error page
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "My Page servlet.";
    }  
}
