package com.wannabeblocket.ah;

import com.wannabeblocket.core.navigation.Navigation;
import com.wannabeblocket.core.navigation.NavigationNode;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Administrator
 */
@Named
@RequestScoped
public class TopMenu extends Navigation{

    public TopMenu() {
        this.getChildren().add(new NavigationNode("Logga in", "login.xhtml"));
        this.getChildren().add(new NavigationNode("Logga out", null));
        this.getChildren().add(new NavigationNode("Min sida", "myPage.xhtml"));
        this.getChildren().add(new NavigationNode("Skapa annons", "createListing.xhtml"));
    }
}
