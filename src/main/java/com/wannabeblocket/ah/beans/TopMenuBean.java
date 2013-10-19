package com.wannabeblocket.ah.beans;

import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.enterprise.context.RequestScoped;
import com.wannabeblocket.core.navigation.Navigation;
import com.wannabeblocket.core.navigation.NavigationNode;

@Named("topmenu")
@RequestScoped
public class TopMenuBean extends Navigation{

    public TopMenuBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest(); 
        
        if(request.getSession().getAttribute("User") == null){
            this.getChildren().add(new NavigationNode("Logga in", "login"));
        }
        else{
            this.getChildren().add(new NavigationNode("Skapa annons", "createListing.xhtml"));  
            this.getChildren().add(new NavigationNode("Min sida", "myPage.xhtml"));                
            this.getChildren().add(new NavigationNode("Logga out", "logout"));
        }
    }
}
