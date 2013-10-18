/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wannabeblocket.ah;

import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.model.Shop;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author chip
 */
@Named
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
    
    public String placeBid() {
        return "success";
    }
    
}
