package com.wannabeblocket.ah.beans;

import javax.inject.Named;
import javax.annotation.ManagedBean;;
import javax.enterprise.context.RequestScoped;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.core.BeanBase;
import com.wannabeblocket.exception.ListingNotFoundException;

@Named("listing")
@ManagedBean
@RequestScoped
public class ListingBean extends BeanBase {
    private Listing _listing;
    private int _bid;
    
    public ListingBean() {
        Long id = this.getParameterAsLong("id");
        
        if(id !=  null) {
            _listing = this.getShop().getAuctionHouse().find(id);
            
            if(_listing == null) {
                throw new ListingNotFoundException("There is no listing with id " + id);
            }
        }
    }
    
    public Listing getListing() {
        return _listing;
    }
    
    public void setBid(int bid) {
        _bid = bid;
    }
    
    public int getBid() {
        return _bid; 
    }
}
