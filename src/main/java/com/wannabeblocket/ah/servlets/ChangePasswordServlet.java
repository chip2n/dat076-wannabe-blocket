package com.wannabeblocket.ah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Page;
import com.wannabeblocket.core.constants.Parameter;
import com.wannabeblocket.core.constants.RequestAttribute;
import com.wannabeblocket.core.constants.Servlet;
import com.wannabeblocket.model.Account;

@WebServlet(urlPatterns = {"/" + Servlet.CHANGE_PASSWORD})
public class ChangePasswordServlet extends ServletBase { 
    
    @Override
    protected void doGet() throws ServletException, IOException {
        if(this.isUserLoggedIn()) {
            this.forward(Page.MY_PAGE);
        }
        else {
            this.forward(Page.MAIN);
        }
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        if(this.isUserLoggedIn()) {
            Account account = this.getUser();
            String oldPassword = this.getParameter(Parameter.OLD_PASSWORD);
            String password = this.getParameter(Parameter.PASSWORD);
            String repeat = this.getParameter(Parameter.REPEAT);
            
            if(password.length() < 4 || password.length() > 16){
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Lösenordet måste vara mellan 4 och 16 tecken långt.");
            }
            else if(!password.equals(repeat)){
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Lösenorden måste matcha.");         
            }
            else if(account.getPassword().equals(oldPassword)) {
                account.setPassword(password);
                this.getShop().getUserRegistry().update(account);
                this.getRequest().setAttribute(RequestAttribute.MESSAGE, "Lösenordet är uppdaterat!");
            } 
            else {
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Det angivna lösenordet är felaktigt.");
            }
            
            this.forward(Page.MY_PAGE);
        }
        else {
            this.forward(Page.MAIN);
        }
    } 
}
