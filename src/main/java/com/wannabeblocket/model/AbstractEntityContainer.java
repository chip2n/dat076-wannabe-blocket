package com.wannabeblocket.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A container for entities, base class for OrderBook, ProductCatalogue,
 * CustomerRegistry The fundamental common operations are here (CRUD).
 *
 * T is type for items in container K is type of id (primary key)
 *
 * @author hajo
 */
public class AbstractEntityContainer<T extends IEntity<K>, K> {

    private List<T> elems = new ArrayList();

    public void add(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Nulls not allowed");
        }
        elems.add(t);
    }

    public void remove(K id) {
        T t = find(id);
        if (t != null) {
            elems.remove(t);
        }
    }

    public void update(T t) {
        T old = find(t.getId());
        if (old != null) {
            elems.remove(old);
        }
        elems.add(t);
    }

    public T find(K id) {
        for (T t : elems) {
            if (t.getId().equals(id)) { // NOTE: equals, not ==
                return t;
            }
        }
        return null;
    }

    public List<T> getRange(int first, int nItems) {
        // From inclusive, to exclusive
        return elems.subList(first, first + nItems);
    }

    public int getCount() {
        return elems.size();
    }

    public void sort(Comparator<T> comp) {
        Collections.sort(elems, comp);
    }
}
