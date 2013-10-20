package com.wannabeblocket.ah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Page;
import com.wannabeblocket.core.constants.Parameter;
import com.wannabeblocket.core.constants.RequestAttribute;
import com.wannabeblocket.core.constants.Servlet;
import com.wannabeblocket.core.constants.SessionAttribute;
import com.wannabeblocket.model.Account;

@WebServlet(urlPatterns = {"/" + Servlet.REGISTER})
public class RegisterServlet extends ServletBase {
    
    @Override
    protected void doGet() throws ServletException, IOException {
        if(isUserLoggedIn()){
            this.forward(Page.MAIN);
        }
        else{
            this.forward(Page.REGISTER);
        }
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        if(isUserLoggedIn()){
            this.forward(Page.MAIN);
        }
        else
        {
            String username = this.getParameter(Parameter.USERNAME);
            
            if(this.getShop().getUserRegistry().exists(username)){
                this.getRequest().setAttribute(RequestAttribute.ERROR, "En användare med det angivna användarnamnet finns redan.");
                this.forward(Page.REGISTER);
            }
            else {
                String password = this.getParameter(Parameter.PASSWORD);
                String email = this.getParameter(Parameter.EMAIL);
                Account user = new Account(username, password);
                
                this.getShop().getUserRegistry().add(user);
                this.getSession().setAttribute(SessionAttribute.USER, user);
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Användaren registrerad.");
                this.forward(Page.REGISTER);
            }
        }
    }
}
