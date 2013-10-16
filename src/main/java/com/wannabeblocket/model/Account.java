package com.wannabeblocket.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Account extends AbstractEntity {

    private String userName;
    /*
    @OneToMany(mappedBy = "bidder", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Bid> bids;
    @OneToMany(mappedBy = "poseter", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments;
    */

    public Account(Long id, String userName) {
        super(id);
        this.userName = userName;
    }

    public Account(String userName) {
        this.userName = userName;
    }

    public Account() {
    }

    public String getUserName() {
        return this.userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
