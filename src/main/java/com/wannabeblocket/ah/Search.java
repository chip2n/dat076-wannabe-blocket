/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.ah;

import com.wannabeblocket.model.AuctionHouse;
import com.wannabeblocket.model.Shop;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
@Named
@RequestScoped
public class Search {

    @NotNull(message = "Vad söker du?")
    private String _searchQuery;
    
    public Search() {
    }
    
    public String search() {
        //FacesContext context = FacesContext.getCurrentInstance();
        //HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        AuctionHouse auctionHouse = Shop.getInstance(Shop.Mode.Release).getAuctionHouse();
        
        auctionHouse.searchDescription(_searchQuery);
        return "failure";
    }
    
    
    public String getSearchQuery() {
        return this._searchQuery;
    }
    
    public void setName(String searchQuery) {
        this._searchQuery = searchQuery;
    }
    
}
