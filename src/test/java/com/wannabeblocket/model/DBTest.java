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
public class DBTest {
    
    public DBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Ignore
    @Test
    public void hello() {
        Account p1 = new Account("user1");
        Account p2 = new Account("user2");
        UserRegistry ur = new UserRegistry("shop_test_pu");
        int count = ur.getAll().size();
        ur.add(p1);
        ur.add(p2);
        
        assertTrue(ur.find(p1.getId()).equals(p1));
        assertFalse(ur.find(p1.getId()).equals(p2));
        
        assertTrue(ur.getAll().size() == count + 2);
    }
}