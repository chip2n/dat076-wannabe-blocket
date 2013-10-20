package com.wannabeblocket.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserRegistry extends AbstractDAO<Account, String> {

    public UserRegistry(String puName) {
        super(Account.class, puName);
    }

    public Account login(String userName, String password) {
        Account tmp = find(userName);
        return tmp != null && tmp.getPassword().equals(password) ? tmp : null;
    }

    public Account findEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Account a;
        try {
        a = (Account) em.createQuery("SELECT a FROM Account a WHERE a.email = :email")
                .setParameter("email", email).getSingleResult();
        } catch(Exception ex)
        {
            return null;
        }
        return a;
    }
}
