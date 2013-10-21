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
        Listing listing = new Listing(usrreg.find("olle"), "TestListing", "TestDescription", new Date(), cats.get("Barn"));
        ah.add(listing);
        assert(ah.find(listing.id) != null);
        
        listing.placeBid(usrreg.find("olle"), 123);
        ah.update(listing);
        assert(ah.find(listing.id).getBids().size() == 1);
    }
    
    
    @Test
    public void test()
    {   
        // get accounts
        Account tmpAcc = accs.get("bengt");
        assert(tmpAcc != null);
        
        Account tmpAcc2 = accs.get("lisa");
        assert(tmpAcc2 != null);
        
        // get category
        Category c = cats.get("Gammal skit");
        assert(c != null);
        
        // add some listings
        Listing[] lList = {
            new Listing(tmpAcc, "Trasig stol", "Kommer i bitar.", new Date(), c),
            new Listing(tmpAcc, "Volvo", "Modell okänd.", new Date(), c)
        };
        
        for(Listing l : lList)
            ah.add(l);
        
        assert(ah.getListingsByCategory(c).size() == lList.length);
        
        // get first Listing
        Listing ltmp = ah.getListingsByCategory(c).get(0);
        assert(ltmp != null);
        
        // define some comments
        Comment[] comments = {
            new Comment(lList[0], tmpAcc2, "msg1", new Date()),
            new Comment(lList[0], tmpAcc, "msg2", new Date()),
            new Comment(lList[0], tmpAcc2, "msg3", new Date())
        };
        
        // get first Listing
        List<Comment> comlst = ltmp.getComments();
        
        // add all comments
        comlst.addAll(Arrays.asList(comments));
        assert(ltmp.getComments().size() == comments.length);
        
        // save comment ids
        Long[] idCommentList = new Long[comments.length];
        for(int i=0; i<comlst.size(); ++i)
            idCommentList[i] = comlst.get(i).getId();
        
        // check that all added comments are added to the persistence unit
        for(Long id : idCommentList)
            assert(csec.find(id) != null);
        
        // remove listing
        ah.remove(ltmp.getId());
        assert(ah.getListingsByCategory(c).size() == lList.length -1);
        
        // check that all comments now are removed from the persistence unit
        for(Long id : idCommentList)
            assert(csec.find(id) == null);
    }

    @Test
    public void bidTest()
    {
        Listing testListing = new Listing(accs_arr[0], "test titel", "test description", new Date(), cats_arr[1]);
        ah.add(testListing);
        assert(testListing.equals(ah.find(testListing.getId())));
        
        ah.find(testListing.getId()).placeBid(accs_arr[0], 99);
        assert(bhist.getBidsByListing(testListing).size() == 1);
    }
}