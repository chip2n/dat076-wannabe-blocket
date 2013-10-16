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
    private final UserRegistry userRegistry;
    private final AuctionHouse auctionHouse;
    private final CommentSection commentSection;
    private final BiddingHistory biddingHistory;
    
    private static Shop _shop;

    private Shop(String puName) {
        userRegistry = new UserRegistry(puName);
        auctionHouse = new AuctionHouse(puName);
        commentSection = new CommentSection(puName);
        biddingHistory = new BiddingHistory(puName);
    }
    
    public static Shop getInstance(String persistanceUnitName) {
        if(_shop == null) {
            // TODO: Ugly :(
            _shop = new Shop(persistanceUnitName);
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
