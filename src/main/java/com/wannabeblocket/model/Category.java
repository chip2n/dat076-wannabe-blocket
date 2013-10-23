/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author joppe
 */
@Entity
public class Category extends AbstractEntity {
    @Column
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Long id) {
        super(id);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
