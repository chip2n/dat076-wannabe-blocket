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
public class SideMenu extends Navigation{

    public SideMenu() {
        for(int i = 1; i < 6; ++i){
            NavigationNode node = new NavigationNode("Link " + i, null);
                node.getChildren().add(new NavigationNode("Sublink " + i, null));
                
            this.getChildren().add(node);
        }
    }
}
