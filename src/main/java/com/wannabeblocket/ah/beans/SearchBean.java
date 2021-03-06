package com.wannabeblocket.ah.beans;

import java.util.List;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.enterprise.context.RequestScoped;
import com.wannabeblocket.model.Listing;

@Named("search")
@RequestScoped
public class SearchBean {
    private String _searchQuery;
    
    private String _categoryValue;
    private List<Listing> _found;
    
    public SearchBean() {
    }
    
    public String search() {
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
