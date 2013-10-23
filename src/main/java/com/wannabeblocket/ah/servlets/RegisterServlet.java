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
            String password = this.getParameter(Parameter.PASSWORD);
            String repeat = this.getParameter(Parameter.REPEAT);
            String email = this.getParameter(Parameter.EMAIL);
                    
            //Make sure to validate on server
            if(username.length() == 0){
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Ange ett användarnamn.");
            }
            else if(password.length() < 4 || password.length() > 16){
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Lösenordet måste vara mellan 4 och 16 tecken långt.");
            }
            else if(!password.equals(repeat)){
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Lösenorden måste matcha.");         
            }       
            else if(email.length() == 0){
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Ange en email adress.");
            }
            else if(!email.matches("^([a-zA-Z0-9_]+)?@(([a-zA-Z]+\\.)+)?([a-zA-Z]+)?$")){
                this.getRequest().setAttribute(RequestAttribute.ERROR, "Ange en giltig email adress.");
            }
            else if(this.getShop().getUserRegistry().exists(username)){
                this.getRequest().setAttribute(RequestAttribute.USERNAME, username);
                this.getRequest().setAttribute(RequestAttribute.ERROR, "En användare med det angivna användarnamnet finns redan.");
            }
            else if(this.getShop().getUserRegistry().findEmail(email) != null){
                this.getRequest().setAttribute(RequestAttribute.USERNAME, username);
                this.getRequest().setAttribute(RequestAttribute.PASSWORD, password);
                this.getRequest().setAttribute(RequestAttribute.REPEAT, repeat);
                this.getRequest().setAttribute(RequestAttribute.EMAIL, email);          
                this.getRequest().setAttribute(RequestAttribute.ERROR, "En användare med den angivna epost adressen finns redan.");              
            }
            else {
                this.getShop().getUserRegistry().add(new Account(username, password, email));
                this.getRequest().setAttribute(RequestAttribute.MESSAGE, "Användaren registrerad.");              
            }
            
            this.forward(Page.REGISTER);
        }
    }
}
