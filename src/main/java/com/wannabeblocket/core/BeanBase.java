package com.wannabeblocket.core;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wannabeblocket.core.constants.SessionAttribute;
import com.wannabeblocket.model.Account;
import com.wannabeblocket.model.Shop;

/**
 * Bean base class.
 */
public class BeanBase implements Serializable{
    private HttpServletRequest _request = null;
    private HttpServletResponse _response = null; 
    private Shop _shop;  
       
    /**
     * Initializes a new instance of the BeanBase class.
     */
    public BeanBase(){
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        
        _request = (HttpServletRequest) context.getRequest();
        _response = (HttpServletResponse) context.getResponse();
        _shop = Shop.getInstance();
    }
    
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
    protected HttpServletResponse getResponse() { return this._response; }
    
    /**
     * Returns the current session.
     * @return the current session.
     */
    protected HttpSession getSession() { return this._request.getSession(); }
    
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
