/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

import java.util.List;

/**
 *
 * @author joppe
 */
public interface IAuctionHouse extends IDAO<Listing, Long> {

    List<Listing> getListingsByCategory(Category category, boolean searchCompletedListings);
    
    List<Listing> getListingsByCategory(Category category, int first, int nItems, boolean searchCompletedAuctions);
    
    List<Listing> getListingsByCategory(Category category);

    List<Listing> getListingsByCategory(Category category, int first, int nItems);

    List<Listing> getListingsBySeller(Account seller);

    List<Listing> getListingsBySeller(Account seller, int first, int nItems);

    List<Listing> searchDescription(String query);
    
    List<Listing> searchDescription(String query, boolean showCompletedListings);

    List<Listing> searchDescription(String query, int first, int nItems);
    
    List<Listing> searchDescription(String query, boolean showCompletedListings, int first, int nItems);

    List<Listing> searchDescription(String query, Category category);
    
    List<Listing> searchDescription(String query, Category category, boolean showCompletedListings);

    List<Listing> searchDescription(String query, Category category, int first, int nItems);
    
    List<Listing> searchDescription(String query, Category category, boolean showCompletedListings, int first, int nItems);
    
}
