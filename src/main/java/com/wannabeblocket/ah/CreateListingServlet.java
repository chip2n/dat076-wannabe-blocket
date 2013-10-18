/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.ah;

import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.model.Account;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.Shop;
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
        Long categoryId = Long.parseLong(this.getRequest().getParameter("category"));
        String description = this.getRequest().getParameter("description");
        
        Listing listing = new Listing(new Account("TEMP_ACCOUNT", "TEMP_PASSWORD"), title, description, new Date(), new Category("TEMP_CATEGORY"));
        Shop.getInstance(Shop.Mode.Release).getAuctionHouse().add(listing);
        
        this.getResponse().sendRedirect("");
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
