package com.wannabeblocket.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Bid extends AbstractEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Listing listing;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Account bidder;
    private int amount;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date timePlaced;

    public Bid(Listing listing, Account bidder, int amount, Date timePlaced) {
        this.listing = listing;
        this.bidder = bidder;
        this.amount = amount;
        this.timePlaced = timePlaced;
    }

    public Bid(Long id, Listing listing, Account bidder, int amount, Date timePlaced) {
        super(id);
        this.listing = listing;
        this.bidder = bidder;
        this.amount = amount;
        this.timePlaced = timePlaced;
    }

    public Bid() {
    }

    public Account getBidder() {
        return this.bidder;
    }

    public void setBidder(Account bidder) {
        this.bidder = bidder;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimePlaced() {
        return this.timePlaced;
    }

    public void setTimePlaced(Date timePlaced) {
        this.timePlaced = timePlaced;
    }
}
