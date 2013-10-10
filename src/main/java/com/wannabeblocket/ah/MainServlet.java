/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.ah;

import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.navigation.NavigationNode;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Aram Timofeitchik
 */
@WebServlet(name = "MainServlet", urlPatterns = {""})
public class MainServlet extends ServletBase {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet() throws ServletException, IOException {
        this.setupSideMenu();
        this.setupTopMenu();
        this.getRequest().getRequestDispatcher("/main.jsp").forward(this.getRequest(), this.getResponse());
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost() throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Main servlet.";
    }
    
    private void setupSideMenu(){
        //Detta ska egentligen kopplas mot produkt kategorier i databasen.
        
        for(int i = 1; i < 6; ++i){
            NavigationNode node = new NavigationNode("Link " + i, null);
                node.getChildren().add(new NavigationNode("Sublink " + i, null));
                
            this.getSideMenu().getChildren().add(node);
        }
    }
    
    // TODO: This should maybe be moved into a separate place,
    // like Navigation.getTopMenu() or ServletBase.setupTopMenu(),
    // since we will need this on many pages and they will all function
    // roughly the same. We also need to consider if the user is logged out -
    // a different top menu should then be visible.
    private void setupTopMenu(){
        this.getTopMenu().getChildren().add(new NavigationNode("Logga in", null));
        this.getTopMenu().getChildren().add(new NavigationNode("Min sida", "mypage"));
        this.getTopMenu().getChildren().add(new NavigationNode("Skapa annons", null));
    }    
}
