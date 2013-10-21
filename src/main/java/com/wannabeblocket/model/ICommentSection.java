/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

import java.util.List;

/**
 *
 * @author joppe
 */
public interface ICommentSection extends IDAO<Comment, Long> {

    List<Listing> getCommentsByListing(Listing listing, int first, int nItems);
    
}
