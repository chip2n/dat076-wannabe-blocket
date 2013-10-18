/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.ah;

import com.wannabeblocket.core.ServletBase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Aram Timofeitchik
 * @author Andreas Arvidsson
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends ServletBase {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet() throws ServletException, IOException {
        this.forward("login.xhtml");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost() throws ServletException, IOException {
        String username = this.getRequest().getParameter("username");
        String password = this.getRequest().getParameter("password");
        
        if(username.equals("User") && password.equals("1234")){  
            this.forward("main.xhtml");
        }
        else{
            this.getRequest().setAttribute("error", "Felaktigt användarnamn eller lösenord.");
            this.forward("login.xhtml");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Login servlet.";
    }  
}
