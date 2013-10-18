package com.wannabeblocket.ah;

import com.wannabeblocket.core.navigation.Navigation;
import com.wannabeblocket.core.navigation.NavigationNode;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.model.Shop;
import java.util.List;
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
        List<Category> categories = Shop.getInstance(Shop.Mode.Release).getCategoryList().getAll();
        
        if(categories != null) {
            for(Category category : categories){
                NavigationNode node = new NavigationNode(category.getName(), null);
                    //node.getChildren().add(new NavigationNode("Sublink " + i, null));

                this.getChildren().add(node);
            }
        }
    }
}
