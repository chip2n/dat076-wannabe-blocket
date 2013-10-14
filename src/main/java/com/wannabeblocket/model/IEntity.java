package com.wannabeblocket.model;

import java.io.Serializable;

/**
 * All entity classes must have a unique id
 * (later id will be auto generated by database)
 * Also they all must be serializable
 * 
 * K is type of id (primary key)
 * 
 * @author hajo
 */
public interface IEntity<K> extends Serializable  {
    public K getId();
}
