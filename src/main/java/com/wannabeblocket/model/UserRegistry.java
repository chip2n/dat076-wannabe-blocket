package com.wannabeblocket.model;

import java.util.List;
import javax.persistence.EntityManager;

public class UserRegistry extends AbstractDAO<Account, String> {

    public UserRegistry(String puName) {
        super(Account.class, puName);
    }

    public boolean login(String userName, String password) {
        if (find(userName).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }

    }
}
