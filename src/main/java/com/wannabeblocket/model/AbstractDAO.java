package com.wannabeblocket.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Base class any persisting collection
 *
 * NOTE: This is ** Application Managed Persistence ** and RESOURCE_LOCAL
 * transactions because we will run JUnit test's i.e. **** Java SE ****
 *
 * @author hajo
 */
public abstract class AbstractDAO<T, K> implements IDAO<T, K> {

    //@PersistenceUnit
    protected EntityManagerFactory emf;

    private final Class<T> clazz;

    public AbstractDAO(Class<T> clazz, String puName) {
        emf = Persistence.createEntityManagerFactory(puName);

        this.clazz = clazz;
    }

    @Override
    public void add(T t) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(t);
            tx.commit();
        } catch (Exception ex) {
            if(tx.isActive())
                tx.rollback();
        } finally {
                em.close();
        }
    }

    @Override
    public void remove(K id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(em.getReference(clazz, id));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(T t) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public T find(K id) {
        EntityManager em = emf.createEntityManager();
        T t = em.find(clazz, id);
        return t;
    }

    @Override
    public List<T> getRange(int first, int nItems) {
        // From inclusive, to exclusive
        EntityManager em = emf.createEntityManager();
        List<T> ts = new ArrayList();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
            Query q = em.createQuery(cq);
            q.setMaxResults(nItems);
            q.setFirstResult(first);
            ts.addAll(q.getResultList());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return ts;
    }
    
    @Override
    public List<T> getAll() {
        EntityManager em = emf.createEntityManager();
        
        List<T> found = new ArrayList();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(clazz));
        Query q = em.createQuery(cq);

        found.addAll(q.getResultList());
        return found;
    }

    @Override
    public int getCount() {
        EntityManager em = emf.createEntityManager();
        int count = -1;
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(clazz);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            count = ((Long) q.getSingleResult()).intValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return count;
    }
}
