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

    public List<Listing> searchDescription(String query) {
        return searchDescription(query, null);
    }

    public List<Listing> searchDescription(String query, int first, int nItems) {
        return searchDescription(query, null, first, nItems);
    }

    public List<Listing> searchDescription(String query, Category category) {
        EntityManager em = emf.createEntityManager();
        List<Listing> all;
        List<Listing> found = new ArrayList();

        if (category == null) {
            all = getAll();
        } else {
            all = em.createQuery("SELECT c FROM Listing c WHERE c.category = :id").setParameter("id", category).getResultList();
        }
        for (Listing l : all) {
            if (l.getDescription().contains(query) || l.getName().contains(query)) {
                found.add(l);
            }
        }
        return found;
    }

    public List<Listing> searchDescription(String query, Category category, int first, int nItems) {
        return searchDescription(query, category).subList(first, nItems);
    }
}
