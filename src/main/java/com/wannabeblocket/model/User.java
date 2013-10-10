package com.wannabeblocket.model;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

    private String userName;

    public User(Long id, String userName) {
        super(id);
        this.userName = userName;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User() {
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
