/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aram Timofeitchik
 */
public abstract class ServletBase extends HttpServlet {
    private HttpServletRequest _request;
    private HttpServletResponse _response;
    
    /**
     * Returns the servlet request.
     * @return the servlet request.
     */
    protected HttpServletRequest getRequest() { return this._request; }
    
    /**
     * Returns the servlet response.
     * @return the servlet response.
     */
    protected HttpServletResponse getResponse(){ return this._response; }
    
    /**
     * Returns the context path of the servlet.
     * @return the context path of the servlet.
     */
    protected String getContextPath(){ return this.getRequest().getServletContext().getContextPath(); }  
    
    /**
     * Forwards the request to the specified path.
     * @param path the path to forward the request too.
     */
    protected void forward(String path) throws ServletException, IOException{ 
        this.getRequest().getRequestDispatcher(path).forward(this.getRequest(), this.getResponse()); 
    } 
    
    /**
     * Handles the HTTP <code>GET</code> method.
     * 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet() throws ServletException, IOException { }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     * 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost() throws ServletException, IOException { } 
    
    /**
     * Handles the HTTP  <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.init(request, response);
        this.doGet();
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.init(request, response);
        this.doPost();
    }
    
    /**
     * Initializes private members.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    private void init(HttpServletRequest request, HttpServletResponse response){
        this._request = request;
        this._response = response;
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public abstract String getServletInfo();  
}
