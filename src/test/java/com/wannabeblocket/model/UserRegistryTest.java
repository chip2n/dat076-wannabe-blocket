/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author joppe
 */
public class UserRegistryTest {
    private Shop _shop;
    
    @Before
    public void setUp() {
        _shop = Shop.getInstance("shop_test_embedded_pu");
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