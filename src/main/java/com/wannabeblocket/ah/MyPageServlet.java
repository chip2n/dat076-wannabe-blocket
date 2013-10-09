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
 * @author Andreas Arvidsson
 */
@WebServlet(name = "MyPageServlet", urlPatterns = {"/mypage"})
public class MyPageServlet extends ServletBase {
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
        this.getRequest().getRequestDispatcher("/my_page.jsp").forward(this.getRequest(), this.getResponse());
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
        return "My Page servlet.";
    }
    
    private void setupSideMenu(){
        //Detta ska egentligen kopplas mot produkt kategorier i databasen.
        
        for(int i = 1; i < 6; ++i){
            NavigationNode node = new NavigationNode("Link " + i, null);
                node.getChildren().add(new NavigationNode("Sublink " + i, null));
                
            this.getSideMenu().getChildren().add(node);
        }
    }
    
    private void setupTopMenu(){
        this.getTopMenu().getChildren().add(new NavigationNode("Logga in", null));
        this.getTopMenu().getChildren().add(new NavigationNode("Min sida", null));
        this.getTopMenu().getChildren().add(new NavigationNode("Skapa annons", null));
    }    
}
