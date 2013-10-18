/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wannabeblocket.ah;

import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.model.Shop;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author chip
 */
@Named
@ManagedBean
@RequestScoped
public class CategoryBean {
    List<Category> _categories;
    
    public List<Category> getCategories() {
        return Shop.getInstance(Shop.Mode.Release).getCategoryList().getAll();
    }
    
}
