package com.wannabeblocket.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Listing extends AbstractEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private User seller;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endingTime;

    public Listing(User seller, String description, Date endingTime) {
        this.seller = seller;
        this.description = description;
        this.endingTime = endingTime;
    }

    public Listing(Long id, User seller, String description, Date endingTime) {
        super(id);
        this.seller = seller;
        this.description = description;
        this.endingTime = endingTime;
    }

    public Listing() {
    }

    public User getSeller() {
        return this.seller;
    }

    /**
     *
     * @param seller
     */
    public void setSeller(User seller) {
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
}
