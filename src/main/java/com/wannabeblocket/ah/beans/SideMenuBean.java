package com.wannabeblocket.ah.beans;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.core.navigation.NavigationBeanBase;
import com.wannabeblocket.core.navigation.NavigationNode;

@Named("sidemenu")
@RequestScoped
public class SideMenuBean extends NavigationBeanBase {

    public SideMenuBean() {
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
