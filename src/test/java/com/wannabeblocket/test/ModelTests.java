/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.test;

import com.wannabeblocket.model.Account;
import com.wannabeblocket.model.AuctionHouse;
import com.wannabeblocket.model.BiddingHistory;
import com.wannabeblocket.model.CommentSection;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.model.UserRegistry;
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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSequence1() throws ClassNotFoundException
    {
        System.out.println(getClass().getResource("META-INF/persistence.xml"));
        System.out.println(Class.forName("org.eclipse.persistence.jpa.PersistenceProvider"));
    }
    
    @Test
    public void testSequence2()
    {
        UserRegistry usrreg = shop.getUserRegistry();
        AuctionHouse ah = shop.getAuctionHouse();
        CommentSection csec = shop.getCommentSection();
        BiddingHistory bhist = shop.getBiddingHistory();
        
        // add users
        Account[] accs = {
            new Account("Olle", "12345"),
            new Account("Bengt", "54321"),
            new Account("Lisa", "hemligt"),
            new Account("Greger", "ange lösenord")
        };
        
        int acc_count = usrreg.getCount();
        
        for(Account a : accs)
            usrreg.add(a);
        
        
        assert(usrreg.getCount() == acc_count + accs.length);
    }
    
}