package com.wannabeblocket.model;

import java.util.List;
import javax.persistence.EntityManager;

public class BiddingHistory extends AbstractDAO<Bid, Long> {

    public BiddingHistory(String puName) {
        super(Bid.class, puName);
    }

    public List<Listing> getBidsByListing(Listing listing) {
       EntityManager em = emf.createEntityManager();
       return em.createQuery("SELECT c FROM BID WHERE listing = " + listing.getId()).getResultList();
    }
}
