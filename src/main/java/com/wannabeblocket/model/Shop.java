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
    private final UserRegistry _userRegistry;
    private final AuctionHouse _auctionHouse;
    private final CommentSection _commentSection;
    private final BiddingHistory _biddingHistory;
    private final CategoryList _categoryList;
    
    private static Shop _shop;

    private Shop(String puName) {
        _userRegistry = new UserRegistry(puName);
        _auctionHouse = new AuctionHouse(puName);
        _commentSection = new CommentSection(puName);
        _biddingHistory = new BiddingHistory(puName);
        _categoryList = new CategoryList(puName);
    }
    
    public static enum Mode {Release, Debug}
    private static String s_puDebug = "shop_test_embedded_pu";
    private static String s_puRelease = "ah_pu";
    
    public static Shop getInstance() {
        return getInstance(Mode.Release);
    }
    
    public static Shop getInstance(Mode mode) {
        if(_shop == null)
            _shop = new Shop(mode == Mode.Debug ? s_puDebug : s_puRelease);
        return _shop;
    }

    public UserRegistry getUserRegistry() {
        return _userRegistry;
    }

    public AuctionHouse getAuctionHouse() {
        return _auctionHouse;
    }

    public CommentSection getCommentSection() {
        return _commentSection;
    }

    public BiddingHistory getBiddingHistory() {
        return _biddingHistory;
    }

    public CategoryList getCategoryList() {
        return _categoryList;
    }
}
