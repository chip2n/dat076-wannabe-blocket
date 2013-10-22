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
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.validation.constraints.Min;

@Named("listing")
@RequestScoped
public class ListingBean extends BeanBase {
    private Listing _listing;

    @Min(value = 1, message = "Du måste buda minst 1 kr")
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
            // User must be logged in to place a bid
            if(this.getUser() == null) {
                this.redirect("/ah/login");
                return "not-logged-in";
            }
            _listing = this.getShop().getAuctionHouse().find(_id);
            boolean bidSuccessful = _listing.placeBid(getUser(), _bid);
            
            if(bidSuccessful) {
                this.getShop().getAuctionHouse().update(_listing); // TODO: another way?
                return "success";
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ListingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "failure";
    }
    
    public String getDateString() {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:m a", Locale.ENGLISH);
        return format.format(_listing.getEndingTime());
    }
    
    public String getNiceDateString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return format.format(_listing.getEndingTime());
    }
}
