/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joppe
 */
public class UserRegistryTest {
    private Shop _shop;
    
    @Before
    public void setUp() {
        _shop = Shop.getInstance(Shop.Mode.Release);
    }

    @Test
    public void hello() {
        Account p1 = new Account("user1");
        Account p2 = new Account("user2");
        UserRegistry ur = _shop.getUserRegistry();
        int count = ur.getAll().size();
        ur.add(p1);
        ur.add(p2);
        
        assertTrue(ur.find(p1.getId()).equals(p1));
        assertFalse(ur.find(p1.getId()).equals(p2));
        
        assertTrue(ur.getAll().size() == count + 2);
    }
}