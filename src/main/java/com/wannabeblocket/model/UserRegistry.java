package com.wannabeblocket.model;

import javax.persistence.EntityManager;

public class UserRegistry extends AbstractDAO<Account, String> implements IUserRegistry {

    public UserRegistry(String puName) {
        super(Account.class, puName);
    }
    
    public static IUserRegistry newInstance(String puName) {
        return new UserRegistry(puName);
    }

    @Override
    public Account login(String userName, String password) {
        Account tmp = find(userName);
        return tmp != null && tmp.getPassword().equals(password) ? tmp : null;
    }

    @Override
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
