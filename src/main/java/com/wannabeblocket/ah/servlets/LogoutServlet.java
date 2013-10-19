package com.wannabeblocket.ah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutServlet extends ServletBase { 
    @Override
    protected void doGet() throws ServletException, IOException {
        logoutAndForward();
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        logoutAndForward();
    } 
    
    private void logoutAndForward() throws ServletException, IOException{
        getSession().removeAttribute("User");
        this.forward("main.xhtml");
    }
}
