/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.ah;

import com.wannabeblocket.model.AuctionHouse;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.Shop;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
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
    
    private String _categoryValue;
    private List<Listing> _found;
    
    public Search() {
    }
    
    public String search() {
        //FacesContext context = FacesContext.getCurrentInstance();
        //HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        //System.out.println("Searching HEEEJ!\n_searchQuery: " +_searchQuery+"\ncategoryValue: "+_categoryValue);
        //System.err.print("Searching HEEEJ!\n_searchQuery: " +_searchQuery+"\ncategoryValue: "+_categoryValue);
        AuctionHouse auctionHouse = Shop.getInstance(Shop.Mode.Release).getAuctionHouse();
        
        _found = auctionHouse.searchDescription(_searchQuery, Long.parseLong(_categoryValue));
        return "success";
    }
    
    
    public String getSearchQuery() {
        return this._searchQuery;
    }
    
    public void setSearchQuery(String searchQuery) {
        this._searchQuery = searchQuery;
    }
    
    public String getCategoryValue() {
        return this._categoryValue;
    }
    
    public void setCategoryValue(String categoryValue) {
        this._categoryValue = categoryValue;
    }
    
    public List<Listing> getFound() {
        return _found;
    }
}
