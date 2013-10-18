/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joppe
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
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
    @Test
    public void hello() {
        Shop shop = Shop.getInstance();
        UserRegistry ur = shop.getUserRegistry();
        AuctionHouse ah = shop.getAuctionHouse();
        CommentSection cs = shop.getCommentSection();
        BiddingHistory bh = shop.getBiddingHistory();
        
        Account account0 = new Account("Joppe", "qwerty");
        
        ur.add(account0);
        
        Listing listing0 = new Listing(account0, "SNABB DEAL FIN TELEFON", "micketfint produkt. micket billig okså", new Date(), new Category("actionfigurer"));
        
        ah.add(listing0);
        
        Comment comment0 = new Comment(listing0, account0, "du är värre än hitler", new Date());
        
        
    }
}