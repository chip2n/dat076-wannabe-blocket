package com.wannabeblocket.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CommentSection extends AbstractDAO<Comment, Long> {

    public CommentSection(String puName) {
        super(Comment.class, puName);
    }
    
    public List<Listing> getCommentsByListing(Listing listing, int first, int nItems) {
       EntityManager em = emf.createEntityManager();
       Query q = em.createQuery("SELECT c FROM Comment c WHERE c.category = :id").setParameter("id", listing);
        if (first != -1 && nItems != -1) {
            q.setMaxResults(nItems);
            q.setFirstResult(first);
        }
        return q.getResultList();
    }
}
