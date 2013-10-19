package com.wannabeblocket.model;

import java.util.List;
import javax.persistence.EntityManager;

public class CommentSection extends AbstractDAO<Comment, Long> {

    public CommentSection(String puName) {
        super(Comment.class, puName);
    }
    
    public List<Listing> getCommentsByListing(Listing listing) {
       EntityManager em = emf.createEntityManager();
       return em.createQuery("SELECT c FROM Comment c WHERE c.category = :id").setParameter("id", listing).getResultList();
    }
}
