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
public interface IBiddingHistory extends IDAO<Bid, Long> {

    List<Listing> getBidsByListing(Listing listing);

    List<Listing> getBidsByListing(Listing listing, int first, int nItems);
    
}
