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
    private final CategoryList categoryList;
    
    private static Shop _shop;

    private Shop(String puName) {
        userRegistry = new UserRegistry(puName);
        auctionHouse = new AuctionHouse(puName);
        commentSection = new CommentSection(puName);
        biddingHistory = new BiddingHistory(puName);
        categoryList = new CategoryList(puName);
    }
    
    public static enum Mode 
    {
        Release("ah_pu"), 
        Debug("ah_pu_test");
        
        private String puName;
        
        private Mode(String puName)
        {
            this.puName = puName;
        }
        
        @Override
        public String toString()
        {
            return puName;
        }
    }
    
    public static Shop getInstance(Mode mode) {
        if(_shop == null)
            _shop = new Shop(mode.toString());
        return _shop;
    }
    
    public static Shop getInstance() {
            return getInstance(Mode.Release);
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

    public CategoryList getCategoryList() {
        return categoryList;
    }
}
