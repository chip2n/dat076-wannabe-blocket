package com.wannabeblocket.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AuctionHouse {

    
    public AuctionHouse() {
    }
    
    public List<Listing> getListings() {
        List<Listing> elems = new ArrayList();
        elems.add(new Listing(new User("Joppe"), "micket fint produkt. micket billig okså", new Date()));
        return elems;
    }
    

}
