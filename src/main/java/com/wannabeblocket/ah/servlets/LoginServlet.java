package com.wannabeblocket.ah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Pages;
import com.wannabeblocket.core.constants.RequestAttributes;
import com.wannabeblocket.core.constants.Servlets;
import com.wannabeblocket.core.constants.SessionAttributes;
import com.wannabeblocket.model.Account;

@WebServlet(urlPatterns = {"/" + Servlets.LOGIN})
public class LoginServlet extends ServletBase {
    
    private void setUser(Account account) throws ServletException, IOException{
        this.getSession().setAttribute(SessionAttributes.USER, account);
    }
    
    @Override
    protected void doGet() throws ServletException, IOException {
        if(isUserLoggedIn()){
            this.forward(Pages.MAIN);
        }
        else{
            this.forward(Pages.LOGIN);
        }
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        if(isUserLoggedIn()){
            this.forward(Pages.MAIN);
        }
        else{    
            String username = this.getRequest().getParameter("username");
            String password = this.getRequest().getParameter("password");

            if(username.equals("User") && password.equals("1234")){        
                this.setUser(new Account(username, password));
                this.getResponse().sendRedirect(Pages.MAIN);
            }
            else{
                this.getRequest().setAttribute(RequestAttributes.ERROR, "Felaktigt användarnamn eller lösenord.");
                this.forward(Pages.LOGIN);
            }
        }
    } 
}
