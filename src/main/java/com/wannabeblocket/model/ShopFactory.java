/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.model;

/**
 *
 * @author Joppe
 */
public class ShopFactory {

    public ShopFactory() {
    }

    public static Shop getShop() {
        Shop s = new Shop();
        return s;
    }
}
