package com.wannabeblocket.ah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Page;
import com.wannabeblocket.core.constants.Servlet;
import com.wannabeblocket.core.constants.SessionAttribute;

@WebServlet(urlPatterns = {"/" + Servlet.LOGOUT})
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
        getSession().removeAttribute(SessionAttribute.USER);
        this.forward(Page.MAIN);
    }
}
