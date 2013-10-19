package com.wannabeblocket.ah.beans;

import java.util.List;
import javax.inject.Named;
import javax.annotation.ManagedBean;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.model.Category;
import javax.enterprise.context.RequestScoped;

@Named("category")
@ManagedBean
@RequestScoped
public class CategoryBean {
    List<Category> _categories;
    
    public List<Category> getCategories() {
        return Shop.getInstance(Shop.Mode.Release).getCategoryList().getAll();
    }
    
}
