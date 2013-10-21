package com.wannabeblocket.ah.beans;

import javax.inject.Named;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.enterprise.context.RequestScoped;
import com.wannabeblocket.core.constants.Servlet;
import com.wannabeblocket.core.navigation.NavigationBeanBase;
import com.wannabeblocket.core.navigation.NavigationNode;

@Named("topmenu")
@RequestScoped
public class TopMenuBean extends NavigationBeanBase {
    public TopMenuBean() throws ServletException, IOException {
        if(this.isUserLoggedIn()){
            this.getChildren().add(new NavigationNode("Skapa annons", Servlet.CREATE_LISTING));  
            this.getChildren().add(new NavigationNode("Min sida", Servlet.MY_PAGE));                
            this.getChildren().add(new NavigationNode("Logga out (" + this.getUser().getUserName() + ")", Servlet.LOGOUT));
        }
        else{
            this.getChildren().add(new NavigationNode("Logga in", Servlet.LOGIN));
            this.getChildren().add(new NavigationNode("Registrera", Servlet.REGISTER));
        }
    }
}
