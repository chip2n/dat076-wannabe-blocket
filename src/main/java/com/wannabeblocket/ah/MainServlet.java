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
}
