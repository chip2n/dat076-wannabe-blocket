package com.wannabeblocket.ah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Page;
import com.wannabeblocket.core.constants.Parameter;
import com.wannabeblocket.core.constants.Servlet;
import com.wannabeblocket.model.Account;

@WebServlet(urlPatterns = {"/" + Servlet.MY_PAGE})
public class MyPageServlet extends ServletBase { 
    
    @Override
    protected void doGet() throws ServletException, IOException {
        this.forward();
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        this.forward();
        Account account = this.getUser();
        
        if(isUserLoggedIn()) {
            String oldPassword = account.getPassword();
            
        }
    } 
    
    private void forward() throws ServletException, IOException{
        if(this.isUserLoggedIn()){
            this.forward(Page.MY_PAGE);
        }   
        else {
            this.forward(Page.MAIN);
        }
    }
}
