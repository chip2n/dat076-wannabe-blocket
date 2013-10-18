/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.test;

import com.wannabeblocket.model.Shop;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author stoffe
 */
public class ModelTests {
    
    private static Shop shop;
    
    public ModelTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        shop = Shop.getInstance(Shop.Mode.Debug);
        shop.getUserRegistry();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSequence1()
    {
        
    }
    
}