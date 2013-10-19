package com.wannabeblocket.ah.beans;

import javax.inject.Named;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.enterprise.context.RequestScoped;
import com.wannabeblocket.core.constants.Servlets;
import com.wannabeblocket.core.navigation.NavigationBeanBase;
import com.wannabeblocket.core.navigation.NavigationNode;

@Named("topmenu")
@RequestScoped
public class TopMenuBean extends NavigationBeanBase {
    public TopMenuBean() throws ServletException, IOException {
        if(this.isUserLoggedIn()){
            this.getChildren().add(new NavigationNode("Skapa annons", Servlets.CREATE_LISTING));  
            this.getChildren().add(new NavigationNode("Min sida", Servlets.MY_PAGE));                
            this.getChildren().add(new NavigationNode("Logga out", Servlets.LOGOUT));
        }
        else{
            this.getChildren().add(new NavigationNode("Logga in", Servlets.LOGIN));
        }
    }
}
