package com.wannabeblocket.model;

public class UserRegistry extends AbstractDAO<User, Long> {

    public UserRegistry(String puName) {
        super(User.class, puName);
    }

    /**
     *
     * @param user
     */
    public User addUser(User user) {
        // TODO - implement UserRegistry.addUser
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public User getUserById(int id) {
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
