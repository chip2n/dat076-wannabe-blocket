package com.wannabeblocket.ah;

import com.wannabeblocket.core.navigation.Navigation;
import com.wannabeblocket.core.navigation.NavigationNode;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
@Named
@RequestScoped
public class TopMenu extends Navigation{

    public TopMenu() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest(); 
        
        if(request.getSession().getAttribute("User") == null){
            this.getChildren().add(new NavigationNode("Logga in", "login"));
        }
        else{
            this.getChildren().add(new NavigationNode("Logga out", null));
        }
        
        this.getChildren().add(new NavigationNode("Min sida", "myPage.xhtml"));
        this.getChildren().add(new NavigationNode("Skapa annons", "createListing.xhtml"));
    }
}
