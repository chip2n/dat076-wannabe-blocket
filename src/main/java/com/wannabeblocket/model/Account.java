package com.wannabeblocket.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account implements Serializable /*extends AbstractEntity */ {

    @Id
    private String userName;
    private String password;
    /*
     @OneToMany(mappedBy = "bidder", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
     private List<Bid> bids;
     @OneToMany(mappedBy = "poster", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
     private List<Comment> comments;
     */

    /*
     public Account(Long id, String userName, String password) {
     super(id);
     this.userName = userName;
     this.password = password;
     }
     */
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Account() {
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        if (!Objects.equals(this.userName, other.id)) {
            return false;
        }
        return true;
    }
}
