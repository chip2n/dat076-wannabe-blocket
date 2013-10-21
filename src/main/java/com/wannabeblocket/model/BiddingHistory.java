package com.wannabeblocket.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BiddingHistory extends AbstractDAO<Bid, Long> implements IBiddingHistory {

    public BiddingHistory(String puName) {
        super(Bid.class, puName);
    }
    
    public static IBiddingHistory newInstance(String puName) {
        return new BiddingHistory(puName);
    }

    @Override
    public List<Bid> getBidsByListing(Listing listing) {
        return getBidsByListing(listing, -1, -1);
    }
    
    @Override
    public List<Bid> getBidsByListing(Listing listing, int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Bid c WHERE c.listing = :id").setParameter("id", listing);
        if (first != -1 && nItems != -1) {
            q.setMaxResults(nItems);
            q.setFirstResult(first);
        }
        return q.getResultList();
    }
}
