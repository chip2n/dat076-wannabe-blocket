/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

/**
 *
 * @author joppe
 */
public interface IUserRegistry extends IDAO<Account, String> {
    
    Account findEmail(String email);

    Account login(String userName, String password);
    
}
