package com.wannabeblocket.core;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wannabeblocket.model.Account;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.core.constants.SessionAttribute;

public abstract class ServletBase extends HttpServlet {
    private HttpServletRequest _request;
    private HttpServletResponse _response;
    private Shop _shop;
    
    /**
     * Returns the shop.
     * @return the shop.
     */
    protected Shop getShop(){ return this._shop; } 
    
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
    protected HttpSession getSession() { return this._request.getSession(); }
    
    /**
     * Returns the context path of the servlet.
     * @return the context path of the servlet.
     */
    protected String getContextPath(){ return this._request.getServletContext().getContextPath(); }  
    
    /**
     * Forwards the request to the specified path.
     * @param path the path to forward the request too.
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void forward(String path) throws ServletException, IOException{ 
        this._request.getRequestDispatcher(path).forward(this.getRequest(), this.getResponse()); 
    } 
    
    /**
     * Redirects to the specified path.
     * @param path the path to redirect too.
     * @throws java.io.IOException
     */
    protected void redirect(String path) throws IOException{ 
        this._response.sendRedirect(path); 
    }     
    
    /**
     * Gets the value of the parameter with the specified name as a Long.
     * @param name the name of the parameter.
     * @return the value of the parameter with the specified name as a Long.
     */
    protected String getParameter(String name){ 
        return this._request.getParameter(name); 
    }
    
    /**
     * Gets the parameter with the specified name.
     * @param name the name of the parameter.
     * @return the value of the parameter with the specified name.
     */
    protected Long getParameterAsLong(String name){ 
        return Long.getLong(this._request.getParameter(name)); 
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
        this._shop = Shop.getInstance();
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
        return (Account) this.getSession().getAttribute(SessionAttribute.USER);    
    }
    
    /**
     * Checks whether a user is logged in.
     * 
     * @return true if a user is logged in; otherwise, false.
     * @throws ServletException
     * @throws IOException 
     */
    protected boolean isUserLoggedIn() throws ServletException, IOException{
        return this.getUser() != null;    
    }
}
