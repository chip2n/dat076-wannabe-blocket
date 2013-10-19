package com.wannabeblocket.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Listing extends AbstractEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Account seller;
    private String name;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endingTime;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "LISTING")
    private List<Bid> bids;
    @OneToMany(mappedBy = "listing", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments;

    public Listing(Account seller, String name, String description, Date endingTime, Category category) {
        this.seller = seller;
        this.name = name;
        this.description = description;
        this.endingTime = endingTime;
        this.category = category;
    }

    public Listing(Long id, Account seller, String name, String description, Date endingTime, Category category) {
        super(id);
        this.seller = seller;
        this.name = name;
        this.description = description;
        this.endingTime = endingTime;
        this.category = category;
    }

    public Listing() {
    }

    public Account getSeller() {
        return this.seller;
    }

    public void setSeller(Account seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndingTime() {
        return this.endingTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }

    public Category getCategory() {
        return category;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
