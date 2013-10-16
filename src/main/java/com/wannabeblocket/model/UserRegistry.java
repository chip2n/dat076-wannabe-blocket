package com.wannabeblocket.model;

public class UserRegistry extends AbstractDAO<Account, Long> {

    public UserRegistry(String puName) {
        super(Account.class, puName);
    }

    /**
     *
     * @param user
     */
    public Account addUser(Account user) {
        // TODO - implement UserRegistry.addUser
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public Account getUserById(int id) {
        // TODO - implement UserRegistry.getUserById
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public void deleteUser(int id) {
        // TODO - implement UserRegistry.deleteUser
        throw new UnsupportedOperationException();
    }
}
