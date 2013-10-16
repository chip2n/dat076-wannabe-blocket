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
public class AuctionHouseTest {
    private Shop _shop;
    
    @Before
    public void setUp() {
        _shop = Shop.getInstance("shop_test_embedded_pu");
    }

    @Test
    public void addGetRemove() {
        AuctionHouse ah = _shop.getAuctionHouse();
        int count = ah.getAll().size();
        
        Listing listing = new Listing(new Account("Svante"), "Beskrivning", new Date(), new Category("test kategori"));
        ah.add(listing);
        assertTrue(ah.find(listing.getId()) != null);
        assertTrue(ah.getAll().size() == count + 1);
        
        ah.remove(listing.getId());
        assertTrue(ah.find(listing.getId()) == null);
        assertTrue(ah.getAll().size() == count);
        
    }
}