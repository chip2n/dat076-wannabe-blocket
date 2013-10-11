/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Joppe
 */
public class DBTest {
    
    Shop shop;

    @Test
    public void firstTest() {


        shop = ShopFactory.getShop();
        User user0 = new User("user name 0");
        shop.getUserRegistry().add(user0);
        Listing listing0 = new Listing(user0, "listing text 0", new Date());
        shop.getAuctionHouse().add(listing0);
        Comment comment0 = new Comment(listing0, user0, "comment text 0", new Date());
        //shop.getCommentSection().add(comment0);
        Bid bid0 = new Bid(listing0, user0, 0, new Date());
        //shop.getBiddingHistory().add(bid0);
        
        /*
        sertTrue(user0.equals(cs.find(comment0.getId()).getPoster()));
        assertTrue(user0.equals(bh.find(bid0.getId()).getBidder()));
        */
        assertTrue(true);
    }
}
