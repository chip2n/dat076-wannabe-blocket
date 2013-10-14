package com.wannabeblocket.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BiddingHistory extends AbstractEntityContainer {

    public BiddingHistory() {
    }

    public List<Bid> getBids() {
        List<Bid> elems = new ArrayList();
        elems.add(
                new Bid(
                    new Listing(
                        new User("Christoffer"), "micket fint produkt. micket billig okså", new Date()
                   ), new User("Aram"), 99999, new Date()
                )
        );
        return elems;
    }
}
