package com.wannabeblocket.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Bid extends AbstractEntity {

    @ManyToOne( cascade={CascadeType.PERSIST})
    private User bidder;
    @ManyToOne( cascade={CascadeType.PERSIST})
    private Listing listing;
    private int amount;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date timePlaced;

    public Bid(Listing listing, int amount, Date timePlaced, Long id, User bidder) {
        super(id);
        this.bidder = bidder;
        this.listing = listing;
        this.amount = amount;
        this.timePlaced = timePlaced;
    }

    public Bid() {
    }

    public User getBidder() {
        return this.bidder;
    }

    /**
     *
     * @param bidder
     */
    public void setBidder(User bidder) {
        this.bidder = bidder;
    }
    
    public Listing getListing() {
        return listing;
    }
    
    /**
     *
     * @param listing
     */
    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public int getAmount() {
        return this.amount;
    }

    /**
     *
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimePlaced() {
        return this.timePlaced;
    }

    /**
     *
     * @param timePlaced
     */
    public void setTimePlaced(Date timePlaced) {
        this.timePlaced = timePlaced;
    }
}