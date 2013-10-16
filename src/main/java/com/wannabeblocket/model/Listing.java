package com.wannabeblocket.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Listing extends AbstractEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Account seller;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endingTime;
    private Category category;
    /*
    @OneToMany(mappedBy = "listing", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Bid> bids;
    @OneToMany(mappedBy = "listing", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments;
    */

    public Listing(Account seller, String description, Date endingTime, Category category) {
        this.seller = seller;
        this.description = description;
        this.endingTime = endingTime;
        this.category = category;
    }

    public Listing(Long id, Account seller, String description, Date endingTime, Category category) {
        super(id);
        this.seller = seller;
        this.description = description;
        this.endingTime = endingTime;
        this.category = category;
    }

    public Listing() {
    }

    public Account getSeller() {
        return this.seller;
    }

    /**
     *
     * @param seller
     */
    public void setSeller(Account seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndingTime() {
        return this.endingTime;
    }

    /**
     *
     * @param endingTime
     */
    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }

    public Category getCategory() {
        return category;
    }
    
}
