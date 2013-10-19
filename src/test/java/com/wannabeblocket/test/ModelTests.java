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
    public void accountTests()
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
        
        for(Account a : accs)
            usrreg.add(a);        
        
        // check that all accounts got added
        assert(usrreg.getCount() == accs.length);
        
        // test so no users can have the same username
        int dindex = 2; // index to user
        
        Account dublicate_acc = 
                new Account(accs[dindex].getUserName(), "hejhopp");        
        usrreg.add(dublicate_acc);
        
        // check that no account got added
        assert(usrreg.getCount() == accs.length);
        
        // check that the old account still exists and that the dublicate don't
        assert(usrreg.find(accs[dindex].getId()) != null);
        assert(usrreg.find(dublicate_acc.getId()) == null);
    }
    
}