package com.wannabeblocket.ah.beans;

import java.util.List;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.enterprise.context.RequestScoped;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.AuctionHouse;

@Named("search")
@RequestScoped
public class SearchBean {

    @NotNull(message = "Vad söker du?")
    private String _searchQuery;
    
    private String _categoryValue;
    private List<Listing> _found;
    
    public SearchBean() {
    }
    
    public String search() {
        //FacesContext context = FacesContext.getCurrentInstance();
        //HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        
        AuctionHouse auctionHouse = Shop.getInstance(Shop.Mode.Release).getAuctionHouse();
        
        _found = auctionHouse.searchDescription(_searchQuery, Shop.getInstance().getCategoryList().find(Long.parseLong(_categoryValue)));
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
