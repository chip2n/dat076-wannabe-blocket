package com.wannabeblocket.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AuctionHouse extends AbstractDAO<Listing, Long> {

    public AuctionHouse(String puName) {
        super(Listing.class, puName);
    }

    public List<Listing> getListingsBySeller(Account seller) {
        return getListingsBySeller(seller, -1, -1);
    }

    public List<Listing> getListingsBySeller(Account seller, int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Listing c WHERE c.seller = :id").setParameter("id", seller);
        if (first != -1 && nItems != -1) {
            q.setMaxResults(nItems);
            q.setFirstResult(first);
        }
        return q.getResultList();
    }

    public List<Listing> getListingsByCategory(Category category) {
        return getListingsByCategory(category, -1, -1);
    }

    public List<Listing> getListingsByCategory(Category category, int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Listing c WHERE c.category = :id").setParameter("id", category);
        if (first != -1 && nItems != -1) {
            q.setMaxResults(nItems);
            q.setFirstResult(first);
        }
        return q.getResultList();
    }

    public List<Listing> searchDescription(String query, Category category) {
        return searchDescription(query, category, -1, -1);
    }

    public List<Listing> searchDescription(String query, Category category, int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        List<Listing> all;
        List<Listing> found = new ArrayList();

        if (category.getId() == -1) {
            all = em.createQuery("SELECT c FROM LISTING").getResultList();
        } else {
            all = em.createQuery("SELECT c FROM Listing c WHERE c.category = :id").setParameter("id", category).getResultList();
        }
        for (Listing l : all) {
            if (l.getDescription().contains(query)) {
                found.add(l);
            }
        }
        if (first != -1 && nItems != -1) {
            found.subList(first, nItems);
        }
        return found;
    }
}
