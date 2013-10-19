package com.wannabeblocket.ah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.model.Account;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends ServletBase {
    
    private boolean isUserLoggedIn() throws ServletException, IOException{
        return getSession().getAttribute("User") != null;    
    }
    
    @Override
    protected void doGet() throws ServletException, IOException {
        if(isUserLoggedIn()){
            this.forward("main.xhtml");
        }
        else{
            this.forward("WEB-INF/login.xhtml");
        }
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        if(isUserLoggedIn()){
            this.forward("main.xhtml");
        }
        else{    
            String username = this.getRequest().getParameter("username");
            String password = this.getRequest().getParameter("password");

            if(username.equals("User") && password.equals("1234")){        
                this.getRequest().getSession().setAttribute("User", new Account(username, password));
                this.getResponse().sendRedirect("main.xhtml");
            }
            else{
                this.getRequest().setAttribute("error", "Felaktigt användarnamn eller lösenord.");
                this.forward("login.xhtml");
            }
        }
    } 
}
