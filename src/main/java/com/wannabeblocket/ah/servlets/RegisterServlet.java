package com.wannabeblocket.ah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.core.constants.Pages;
import com.wannabeblocket.core.constants.Servlets;

@WebServlet(urlPatterns = {"/" + Servlets.REGISTER})
public class RegisterServlet extends ServletBase {
    
    @Override
    protected void doGet() throws ServletException, IOException {
        if(isUserLoggedIn()){
            this.forward(Pages.MAIN);
        }
        else{
            this.forward(Pages.REGISTER);
        }
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        if(isUserLoggedIn()){
            this.forward(Pages.MAIN);
        }
        else{
            this.forward(Pages.REGISTER);
        }
    } 
}
