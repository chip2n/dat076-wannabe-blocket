/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

import java.util.List;

/**
 *
 * @author Joppe
 */
public interface IDAO<T, K> {

    public void add(T t);

    public T find(K id);

    public List<T> getAll();

    public int getCount();

    public List<T> getRange(int maxResults, int firstResult);

    public void remove(K id);

    public void update(T t);
}
