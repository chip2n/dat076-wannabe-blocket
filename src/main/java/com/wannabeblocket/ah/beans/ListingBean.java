package com.wannabeblocket.ah.beans;

import com.wannabeblocket.exception.ListingNotFoundException;
import javax.inject.Named;
import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.enterprise.context.RequestScoped;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.model.Listing;

@Named("listing")
@ManagedBean
@RequestScoped
public class ListingBean {
    private Listing _listing;
    private int _bid;
    
    public ListingBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String sId = request.getParameter("id");
        
        if(sId !=  null) {
            Long id = Long.parseLong(request.getParameter("id"));
            _listing = Shop.getInstance(Shop.Mode.Release).getAuctionHouse().find(id);
            if(_listing == null) {
                throw new ListingNotFoundException("There is no listing with id " + sId);
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
