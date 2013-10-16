/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

/**
 *
 * @author joppe
 */
public class CategoryList extends AbstractDAO<Category, Long> {

    public CategoryList(String puName) {
        super(Category.class, puName);
    }
    
}
