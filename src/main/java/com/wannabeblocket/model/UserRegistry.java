package com.wannabeblocket.model;

import java.util.List;
import javax.persistence.EntityManager;

public class UserRegistry extends AbstractDAO<Account, Long> {

    public UserRegistry(String puName) {
        super(Account.class, puName);
    }
}
