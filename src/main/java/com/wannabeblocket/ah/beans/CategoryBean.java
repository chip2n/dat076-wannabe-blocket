package com.wannabeblocket.ah.beans;


import java.util.List;
import javax.inject.Named;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import com.wannabeblocket.core.BeanBase;
import com.wannabeblocket.model.Category;

@Named("category")
@ManagedBean
@RequestScoped
public class CategoryBean extends BeanBase {
  
    public List<Category> getCategories() {
        return this.getShop().getCategoryList().getAll();
    }
}
