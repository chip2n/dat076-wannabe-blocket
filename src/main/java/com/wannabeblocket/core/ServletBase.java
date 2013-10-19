package com.wannabeblocket.core;

import com.wannabeblocket.core.constants.SessionAttributes;
import com.wannabeblocket.model.Account;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     * Returns the current session.
     * @return the current session.
     */
    protected HttpSession getSession() { return this.getRequest().getSession(); }
    
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
    public String getServletInfo(){
        return "";
    }
    
    /**
     * Gets the currently logged on user.
     * 
     * @return the currently logged on user.
     * @throws ServletException
     * @throws IOException 
     */
    protected Account getUser() throws ServletException, IOException{
        return (Account) getSession().getAttribute(SessionAttributes.USER);    
    }
    
    /**
     * Checks whether a user is logged in.
     * 
     * @return true if a user is logged in; otherwise, false.
     * @throws ServletException
     * @throws IOException 
     */
    protected boolean isUserLoggedIn() throws ServletException, IOException{
        return getUser() != null;    
    }
}
