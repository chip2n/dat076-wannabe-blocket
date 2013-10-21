package com.wannabeblocket.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AuctionHouse extends AbstractDAO<Listing, Long> implements IAuctionHouse {

    public AuctionHouse(String puName) {
        super(Listing.class, puName);
    }

    public static IAuctionHouse newInstance(String puName) {
        return new AuctionHouse(puName);
    }

    @Override
    public List<Listing> getListingsBySeller(Account seller) {
        return getListingsBySeller(seller, -1, -1);
    }

    @Override
    public List<Listing> getListingsBySeller(Account seller, int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Listing c WHERE c.seller = :id").setParameter("id", seller);
        if (first != -1 && nItems != -1) {
            q.setMaxResults(nItems);
            q.setFirstResult(first);
        }
        return q.getResultList();
    }

    @Override
    public List<Listing> getListingsByCategory(Category category) {
        return getListingsByCategory(category, -1, -1, false);
    }

    @Override
    public List<Listing> getListingsByCategory(Category category, boolean showCompletedListings) {
        return getListingsByCategory(category, -1, -1, showCompletedListings);
    }

    @Override
    public List<Listing> getListingsByCategory(Category category, int first, int nItems, boolean showCompletedAuctions) {
        EntityManager em = emf.createEntityManager();
        Query q;
        if (showCompletedAuctions) {
            q = em.createQuery("SELECT c FROM Listing c WHERE c.category = :id AND c.endingTime >= :now")
                    .setParameter("id", category).setParameter("now", new Date());
        } else {
            q = em.createQuery("SELECT c FROM Listing c WHERE c.category = :id").setParameter("id", category);
        }
        if (first != -1 && nItems != -1) {
            q.setMaxResults(nItems);
            q.setFirstResult(first);
        }
        return q.getResultList();
    }

    @Override
    public List<Listing> getListingsByCategory(Category category, int first, int nItems) {
        return getListingsByCategory(category, first, nItems, false);
    }

    
    
    @Override
    public List<Listing> searchDescription(String query) {
        return searchDescription(query, false, -1, -1);
    }
    
    @Override
    public List<Listing> searchDescription(String query, int first, int nItems) {
        return searchDescription(query, false, first, nItems);
    }
    
    @Override
    public List<Listing> searchDescription(String query, boolean showCompletedListings) {
        return searchDescription(query, showCompletedListings, -1, -1);
    }
    
    @Override
    public List<Listing> searchDescription(String query, boolean showCompletedListings, int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        List<Listing> all;
        if (!showCompletedListings) {
            all = em.createQuery("SELECT c FROM Listing c WHERE c.endingTime >= :now").setParameter("now", new Date()).getResultList();
        } else {
            all = getAll();
        }
        return search(all, query, first, nItems);
    }

    @Override
    public List<Listing> searchDescription(String query, Category category) {
        return searchDescription(query, category, false, -1, -1);
    }

    @Override
    public List<Listing> searchDescription(String query, Category category, int first, int nItems) {
        return searchDescription(query, category, false, first, nItems);
    }
    
    @Override
    public List<Listing> searchDescription(String query, Category category, boolean showCompletedListings) {
        return searchDescription(query, category, false, -1, -1);
    }

    @Override
    public List<Listing> searchDescription(String query, Category category, boolean showCompletedListings, int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        List<Listing> all = new ArrayList();
        if (!showCompletedListings) {
            all = em.createQuery("SELECT c FROM Listing c WHERE c.category = :id AND c.endingTime >= :now").setParameter("id", category).setParameter("id", category).getResultList();
        } else {
            all = em.createQuery("SELECT c FROM Listing c WHERE c.category = :id").setParameter("id", category).getResultList();
        }
        return search(all, query, first, nItems);
    }

    private List<Listing> limitSearch(List<Listing> found, int first, int nItems) {

        if (first != -1 && nItems != -1) {
            if (found.size() > first + nItems) {
                found = found.subList(first, first + nItems);
            } else {
                found = found.subList(first, found.size());
            }
        }
        return found;
    }

    private List<Listing> search(List<Listing> all, String query, int first, int nItems) {
        List<Listing> found = new ArrayList();
        for (Listing l : all) {
            if (l.getDescription().toLowerCase().contains(query.toLowerCase()) || l.getName().toLowerCase().contains(query.toLowerCase())) {
                found.add(l);
            }
        }
        return limitSearch(found, first, nItems);
    }
}
