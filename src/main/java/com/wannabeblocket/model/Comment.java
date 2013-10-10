package com.wannabeblocket.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Comment extends AbstractEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Listing listing;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private User poster;
    private String text;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date submissionTime;

    public Comment(Listing listing, User poster, String text, Date submissionTime) {
        this.listing = listing;
        this.poster = poster;
        this.text = text;
        this.submissionTime = submissionTime;
    }

    public Comment(Long id, Listing listing, User poster, String text, Date submissionTime) {
        super(id);
        this.listing = listing;
        this.poster = poster;
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
