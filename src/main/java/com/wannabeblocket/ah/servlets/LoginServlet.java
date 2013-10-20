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

@WebServlet(urlPatterns = {"/" + Servlet.LOGIN})
public class LoginServlet extends ServletBase {
    
    private void setUser(Account account) throws ServletException, IOException{
        this.getSession().setAttribute(SessionAttribute.USER, account);
    }
    
    @Override
    protected void doGet() throws ServletException, IOException {
        if(isUserLoggedIn()){
            this.forward(Page.MAIN);
        }
        else{
            this.forward(Page.LOGIN);
        }
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        if(isUserLoggedIn()){
            this.forward(Page.MAIN);
        }
        else{    
            String username = this.getParameter(Parameter.USERNAME);
            String password = this.getParameter(Parameter.PASSWORD);
            Account account = this.getShop().getUserRegistry().find(username);

            if(account != null){        
                this.setUser(account);
                this.redirect(Page.MAIN);
            }
            else{
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Felaktigt användarnamn eller lösenord.");
                this.forward(Page.LOGIN);
            }
        }
    } 
}
