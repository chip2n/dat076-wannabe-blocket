package com.wannabeblocket.ah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Pages;
import com.wannabeblocket.core.constants.Servlets;

@WebServlet(urlPatterns = {"/" + Servlets.MY_PAGE})
public class MyPageServlet extends ServletBase { 
    
    @Override
    protected void doGet() throws ServletException, IOException {
        this.forward();
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        this.forward();
    } 
    
    private void forward() throws ServletException, IOException{
        if(this.isUserLoggedIn()){
            this.forward(Pages.MY_PAGE);
        }   
        else {
            this.forward(Pages.MAIN);
        }
    }
}
