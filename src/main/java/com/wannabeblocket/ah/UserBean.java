/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.ah;

/**
 *
 * @author Sebastian Lagerman
 */
public class UserBean {
    
     private String _username;
     private String _password;
     private String _firstName;
     private String _lastName;
     private boolean _valid;
     
     public String getFirstName() {
         return _firstName;
     }
     
     public void setFirstName(String newFirstName) {
         _firstName = newFirstName;
     }
     
     public String getLastName() {
         return _lastName;
     }
     
     public void setLastName(String newLastName) {
         _lastName = newLastName;
     }
     
     public boolean login(String username, String password) {
         _valid = _username.equals(username) && _password.equals(password);
         return _valid;
     }
     
     public void logout() {
         _valid = false;
     }
}
