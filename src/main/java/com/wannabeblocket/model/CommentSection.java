package com.wannabeblocket.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentSection extends AbstractEntityContainer {

    public CommentSection() {
    }
    
    public List<Comment> getComments() {
        List<Comment> elems = new ArrayList();
        elems.add(
                new Comment(
                    new Listing(
                        new User("Joppe"), "micket fint produkt. micket billig okså", new Date()
                   ), new User("Sebastian"), "din mamma", new Date()
                )
        );
        return elems;
    }

}
