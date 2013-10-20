package com.wannabeblocket.model;

public class UserRegistry extends AbstractDAO<Account, String> {

    public UserRegistry(String puName) {
        super(Account.class, puName);
    }

    public Account login(String userName, String password) {
        Account tmp = find(userName);
        return tmp != null && tmp.getPassword().equals(password) ? tmp : null;
    }
}
