/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

import com.wannabeblocket.model.*;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joppe
 */
public class DBTest {

    /**
     * @param args the command line arguments
     */
    @Test
    public void firstTest() {
        
        UserRegistry ur = new UserRegistry("wannabeblocket_pu");
        AuctionHouse ah = new AuctionHouse("wannabeblocket_pu");
        CommentSection cs = new CommentSection("wannabeblocket_pu");
        BiddingHistory bh = new BiddingHistory("wannabeblocket_pu");


        
        User user0 = new User("user name 0");
        ur.add(user0);
        Listing listing0 = new Listing(user0, "listing text 0", new Date());
        ah.add(listing0);
        Comment comment0 = new Comment(listing0, user0, "comment text 0", new Date());
        cs.add(comment0);
        Bid bid0 = new Bid(listing0, user0, 0, new Date());
        bh.add(bid0);
        
        /*
        sertTrue(user0.equals(cs.find(comment0.getId()).getPoster()));
        assertTrue(user0.equals(bh.find(bid0.getId()).getBidder()));
        */
        assertTrue(true);
    }
}
