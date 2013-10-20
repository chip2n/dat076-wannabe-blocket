/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.test;

import com.wannabeblocket.model.Account;
import com.wannabeblocket.model.AuctionHouse;
import com.wannabeblocket.model.BiddingHistory;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.CommentSection;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.model.UserRegistry;
import java.util.Date;
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
    private static UserRegistry usrreg;
    private static AuctionHouse ah;
    private static CommentSection csec;
    private static BiddingHistory bhist;
    
    
    static final Account[] accs = {
            new Account("Olle", "12345"),
            new Account("Bengt", "54321"),
            new Account("Lisa", "hemligt"),
            new Account("Greger", "ange lösenord")
    };
            
    public ModelTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        shop = Shop.getInstance(Shop.Mode.Debug);
        usrreg = shop.getUserRegistry();
        ah = shop.getAuctionHouse();
        csec = shop.getCommentSection();
        bhist = shop.getBiddingHistory();
        
        // add users
        assert(usrreg.getCount() == 0);
        
        for(int i = 0; i < accs.length; ++i)
        {
            usrreg.add(accs[i]);
            assert(usrreg.getCount() == i+1);
        }
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
    
    @Test
    public void accountTests()
    {   
        // test login method
        assert(usrreg.login(accs[0].getUserName(), accs[0].getPassword())
                .getUserName().equals(accs[0].getUserName()));
        
        assert(null == usrreg.login(
                accs[0].getUserName(), "wrong password"));
       
        // test so no users can have the same username
        int dindex = 2; // index to user
        
        Account dublicate_acc = 
                new Account(accs[dindex].getUserName(), "hejhopp");        
        usrreg.add(dublicate_acc);
        
        // check that no account got added
        assert(usrreg.getCount() == accs.length);
    }
    
    @Test
    public void test()
    {   
        Category[] cats = {
            new Category("Gammal skit"),
            new Category("Stulet"),
            new Category("Barn"),
            new Category("Övrigt")
        };
        
        Listing[] lList = {
            new Listing(accs[1], "Trasig stol", "Kommer i bitar.", new Date(), cats[0])
        };
    }
    
}