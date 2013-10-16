/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

/**
 *
 * @author Joppe
 */
public class Shop {
    private final UserRegistry userRegistry = new UserRegistry();
    private final AuctionHouse auctionHouse = new AuctionHouse();
    private final CommentSection commentSection = new CommentSection();
    private final BiddingHistory biddingHistory = new BiddingHistory();
    
    private static Shop _shop;

    private Shop() {}
    
    public static Shop getInstance() {
        if(_shop == null) {
            _shop = new Shop();
        }
        
        return _shop;
    }

    public UserRegistry getUserRegistry() {
        return userRegistry;
    }

    public AuctionHouse getAuctionHouse() {
        return auctionHouse;
    }

    public CommentSection getCommentSection() {
        return commentSection;
    }

    public BiddingHistory getBiddingHistory() {
        return biddingHistory;
    }

    
}
