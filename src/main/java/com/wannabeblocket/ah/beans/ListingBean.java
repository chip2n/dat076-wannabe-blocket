package com.wannabeblocket.ah.beans;

import javax.inject.Named;
import javax.annotation.ManagedBean;;
import javax.enterprise.context.RequestScoped;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.core.BeanBase;
import com.wannabeblocket.core.constants.Parameter;
import com.wannabeblocket.exception.ListingNotFoundException;
import com.wannabeblocket.model.Bid;
import com.wannabeblocket.model.Shop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

@Named("listing")
@ManagedBean
@RequestScoped
public class ListingBean extends BeanBase {
    private Listing _listing;
    private int _bid;
    private Long _id;
    
    public ListingBean() {
        _id = this.getParameterAsLong(Parameter.ID);
        
        if(_id !=  null) {
            _listing = this.getShop().getAuctionHouse().find(_id);
            
            if(_listing == null) {
                throw new ListingNotFoundException("There is no listing with id " + _id);
            }
        }
    }
    
    public Listing getListing() {
        return _listing;
    }
    
    public void setListing(Listing listing) {
        _listing = listing;
    }
    
    public void setBid(int bid) {
        _bid = bid;
    }
    
    public int getBid() {
        return _bid; 
    }
    
    public Long getListingId() {
        return _id;
    }
    
    public void setListingId(Long id) {
        _id = id;
    }
    
    public String placeBid() {
        try {
            _listing = this.getShop().getAuctionHouse().find(_id);
            _listing.placeBid(getUser(), _bid);
            this.getShop().getAuctionHouse().update(_listing); // TODO: another way?
            
            return "success";
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ListingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "failure";
    }
}
