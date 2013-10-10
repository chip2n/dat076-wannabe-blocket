package com.wannabeblocket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class User extends AbstractEntity{

    private String userName;

    public User(String userName, Long id) {
        super(id);
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