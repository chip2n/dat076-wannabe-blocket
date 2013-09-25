/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.core;

import com.wannabeblocket.core.navigation.Navigation;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aram Timofeitchik
 */
public class ServletBase extends HttpServlet {
    private HttpServletRequest _request;
    private HttpServletResponse _response;
    private Navigation _sideMenu;
    private Navigation _topMenu;
    
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
     * Returns the side menu nodes.
     * @return the side menu nodes.
     */
    protected Navigation getSideMenu(){ return this._sideMenu; }    
    
    /**
     * Returns the top menu nodes.
     * @return the top menu nodes.
     */
    protected Navigation getTopMenu(){ return this._topMenu; }
    
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
        
        this._request.setAttribute("sideMenu", _sideMenu = new Navigation());
        this._request.setAttribute("topMenu", _topMenu = new Navigation());
    }
}
