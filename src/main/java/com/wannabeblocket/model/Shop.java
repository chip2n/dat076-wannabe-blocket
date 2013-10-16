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

    final static String PU_NAME = "com.wannabeblocket_ah_war_1.0-SNAPSHOTPU";
    
    private final UserRegistry userRegistry = new UserRegistry(PU_NAME);
    private final AuctionHouse auctionHouse = new AuctionHouse(PU_NAME);
    private final CommentSection commentSection = new CommentSection(PU_NAME);
    private final BiddingHistory biddingHistory = new BiddingHistory(PU_NAME);

    public Shop() {
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
