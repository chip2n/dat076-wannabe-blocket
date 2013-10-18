package com.wannabeblocket.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

public class AuctionHouse extends AbstractDAO<Listing, Long> {

    public AuctionHouse(String puName) {
        super(Listing.class, puName);
    }

    /**
     *
     * @param seller
     */
    public List<Listing> getListingsBySeller(Account seller) {
       EntityManager em = emf.createEntityManager();
       return em.createQuery("SELECT c FROM LISTING WHERE seller = " + seller.getId()).getResultList();
    }
    
    public List<Listing> getListingsByCategory(Category category) {
       EntityManager em = emf.createEntityManager();
       return em.createQuery("SELECT c FROM LISTING WHERE category = " + category.getId()).getResultList();
    }
    
    public List<Listing> searchDescription(String query, long categoryId) {
        EntityManager em = emf.createEntityManager();
        List<Listing> all = new ArrayList();
        List<Listing> found = new ArrayList();
        
        if (categoryId == -1) {
            all = em.createQuery("SELECT c FROM LISTING").getResultList();
        } else {
            all = em.createQuery("SELECT c FROM LISTING WHERE category = " + categoryId).getResultList();
        }
        for(Listing l : all) {
            if (l.getDescription().contains(query)) {
                found.add(l);
            }
        }
        return found;
    }
}
