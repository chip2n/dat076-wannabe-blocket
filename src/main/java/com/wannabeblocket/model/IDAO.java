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

    void add(T t);

    T find(K id);

    List<T> getAll();

    int getCount();

    List<T> getRange(int maxResults, int firstResult);

    void remove(K id);

    /**
     * Using out parameter
     */
    void update(T t);
}
