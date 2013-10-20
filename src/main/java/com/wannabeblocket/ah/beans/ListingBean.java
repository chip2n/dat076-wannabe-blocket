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
    private Long id;
    
    public ListingBean() {
        id = this.getParameterAsLong(Parameter.ID);
        
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
    
    public void setListing(Listing listing) {
        _listing = listing;
    }
    
    public void setBid(int bid) {
        _bid = bid;
    }
    
    public int getBid() {
        return _bid; 
    }
    
    public String placeBid() {
        try {
            _listing.placeBid(getUser(), _bid);
            
            return "success";
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ListingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "failure";
    }
}
