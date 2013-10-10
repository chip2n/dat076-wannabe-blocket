package com.wannabeblocket.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Comment extends AbstractEntity {

    @ManyToOne( cascade={CascadeType.PERSIST})
    private User poster;
    @ManyToOne( cascade={CascadeType.PERSIST})
    private Listing listing;
    private String text;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date submissionTime;

    public Comment(User poster, Listing listing, String text, Date submissionTime, Long id) {
        super(id);
        this.poster = poster;
        this.listing = listing;
        this.text = text;
        this.submissionTime = submissionTime;
    }
    
    
    
    public Comment() {
    }

    public User getPoster() {
        return this.poster;
    }

    /**
     *
     * @param poster
     */
    public void setPoster(User poster) {
        this.poster = poster;
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

    public String getText() {
        return this.text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    public Date getSubmissionTime() {
        return this.submissionTime;
    }

    /**
     *
     * @param submissionTime
     */
    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }
}