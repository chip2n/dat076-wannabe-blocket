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

    List<Bid> getBidsByListing(Listing listing);

    List<Bid> getBidsByListing(Listing listing, int first, int nItems);
    
}
