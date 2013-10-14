package com.wannabeblocket.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRegistry extends AbstractEntityContainer {

    public UserRegistry() {
    }

    public List<User> getUsers() {
        List<User> elems = new ArrayList();
        elems.add(new User("Andreas"));
        return elems;
    }

}
