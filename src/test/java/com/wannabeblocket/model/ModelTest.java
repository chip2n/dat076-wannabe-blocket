/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author stoffe
 */
public class ModelTest {
    
    private static Shop shop;
    private static IUserRegistry usrreg;
    private static IAuctionHouse ah;
    private static ICommentSection csec;
    private static IBiddingHistory bhist;
    private static CategoryList clist;
    
    private static final Account[] accs_arr = {
            new Account("olle", "12345", "olle@somecompany.com"),
            new Account("bengt", "54321", "bengt69@somecompany.com"),
            new Account("lisa", "hemligt", "lisa@somecompany.com"),
            new Account("greger", "ange lösenord", "ggr@somecompany.com")
    };
    
    private static final Category[] cats_arr = {
            new Category("Gammal skit"),
            new Category("Stulet"),
            new Category("Barn"),
            new Category("Övrigt")
    };
    
    private static final Date now = new Date();
    private static final Date nowPlusOneDay = new Date(now.getTime() + 3600 * 24);
    
    private final static HashMap<String, Account> accs = new HashMap<>();
    private final static HashMap<String, Category> cats = new HashMap<>();
            
    public ModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        shop = Shop.getInstance(Shop.Mode.Debug);
        usrreg = shop.getUserRegistry();
        ah = shop.getAuctionHouse();
        csec = shop.getCommentSection();
        bhist = shop.getBiddingHistory();
        clist = shop.getCategoryList();
        
        // add some users
        assert(usrreg.getCount() == 0);
        for(Account a : accs_arr)
        {
            accs.put(a.getUserName(), a);
            usrreg.add(a);
        }
        assert(usrreg.getCount() == accs.size());
        
        // add some categories
        assert(clist.getCount() == 0);
        for(Category c : cats_arr)
        {
            cats.put(c.getName(), c);
            clist.add(c);
        }
        assert(clist.getCount() == cats.size());
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
    public void findEmailTest()
    {
        Account a = usrreg.find("olle");
        Account b = usrreg.findEmail(a.getEmail());
      
        assert(a.getUserName().equals(b.getUserName()));
        Account acc_null = usrreg.findEmail("hejhopp@akafoeof233.se");
        assert(null == acc_null);
    }
    
    @Test
    public void uniqueEmailTest()
    {
        Account a = usrreg.find("olle");
        Account b = new Account("trollUser", "passw", a.getEmail());
        usrreg.add(b);
        
        assert(usrreg.find(b.getUserName()) == null);
    }
    
    @Test
    public void passwordTest()
    {   
        // get temp account
        Account tmpAcc = accs.get("olle");
        assert(tmpAcc != null);
        
        // check test data
        String wrongPass = "wrong password!";
        assert(!tmpAcc.getPassword().equals(wrongPass));
        
        // test login method
        assert(usrreg.login(tmpAcc.getUserName(), tmpAcc.getPassword())
                .getUserName().equals(tmpAcc.getUserName()));
        
        // test that a wrong password can't be used to login
        assert(null == usrreg.login(
                tmpAcc.getUserName(), "wrong password"));
    }
    
    @Test
    public void duplicateAccountTest()
    {
        // get temp account
        Account tmpAcc = accs.get("lisa");
        assert(tmpAcc != null);
        
        // check that user already exist
        assert(tmpAcc.getUserName().equals( 
                usrreg.find(tmpAcc.getUserName()).getUserName()));
        
        // try to add an account with the same username
        Account dublicate_acc =
                new Account(tmpAcc.getUserName(), "hejhopp", "a@b.c");        
        usrreg.add(dublicate_acc);
        
        // check that no account got added
        assert(usrreg.getCount() == accs.size());
    }
    
    @Test
    public void testBids()
    {   
        Listing listing = new Listing(
                usrreg.find("olle"), "TestListing", "TestDescription",
                nowPlusOneDay, cats.get("Barn"));
        
        ah.add(listing);
        assert(ah.find(listing.getId()) != null);
        
        listing.placeBid(usrreg.find("olle"), 123);
        ah.update(listing);
        assert(ah.find(listing.getId()).getBids().size() == 1);
    }
    
    
    @Test
    public void cascadeTest()
    {   
        /*
            *** Init some test data ***
        */
        
        // get accounts
        Account tmpAcc = accs.get("bengt");
        assert(tmpAcc != null);
        
        Account tmpAcc2 = accs.get("lisa");
        assert(tmpAcc2 != null);
        
        Account tmpAcc3 = accs.get("greger");
        assert(tmpAcc3 != null);
        
        // get category
        Category c = cats.get("Gammal skit");
        assert(c != null);
        
        // add some listings
        Listing[] lList = {
            new Listing(tmpAcc, "Trasig stol", "Kommer i bitar.", nowPlusOneDay, c),
            new Listing(tmpAcc, "Volvo", "Modell okänd.", nowPlusOneDay, c)
        };
        
        for(Listing l : lList)
            ah.add(l);
        
        assert(ah.getListingsByCategory(c).size() == lList.length);
        
        /*
            *** Test Bids ***
        */
        
        // get first Listing
        Listing ltmp2 = ah.getListingsByCategory(c).get(0);
        assert(ltmp2 != null);
        
        final int bidNum = 8;
        
        // place some bids
        for(int i=0; i<bidNum; ++i)
            assert(ltmp2.placeBid( i%2==0 ? tmpAcc2 : tmpAcc3, (int)Math.pow(2, i) ));
        
        // save all bid IDs
        List<Bid> bidlst = ltmp2.getBids();
        assert(bidlst.size() == bidNum);
        
        Long[] bidsIDs = new Long[bidNum];
        
        for(int i = 0; i<bidlst.size(); ++i)
            bidsIDs[i] = bidlst.get(i).getId();
        
        // check that all bids are added to the persistence unit
        for(Long bidID : bidsIDs)
            assert(bhist.exists(bidID));
        
        // remove listing
        ah.remove(ltmp2.getId());
        
        // check that all bids are removed from the persistence unit
        for(Long bidID : bidsIDs)
            assert(!bhist.exists(bidID));
    }
}