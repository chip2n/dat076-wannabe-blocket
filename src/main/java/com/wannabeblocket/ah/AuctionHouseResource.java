package com.wannabeblocket.ah;

import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.IAuctionHouse;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.Shop;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Andreas Arvidsson
 */
@Path("/auctions")
public class AuctionHouseResource {
    private IAuctionHouse _auctionHouse;
    
    public AuctionHouseResource() {
        _auctionHouse = Shop.getInstance(Shop.Mode.Release).getAuctionHouse();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() { 
        List<Listing> listings = _auctionHouse.getAll();

        List<ListingProxy> proxyListings = new ArrayList<>(listings.size());
        
        for(Listing listing : listings) {
            proxyListings.add(new ListingProxy(listing));
        }
        
        GenericEntity<List<ListingProxy>> p = new GenericEntity<List<ListingProxy>>(proxyListings){};
        
        return Response.ok(p).build();
    }
    
    @GET
    @Path("/range")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRange(@QueryParam("fst") int first, @QueryParam("max") int nItems, @QueryParam("query") String query, @QueryParam("category") String category) {
        List<Listing> listings;
        
        if(query.equals("undefined")) {
            listings = _auctionHouse.getRange(first, nItems);
        } else if(category.equals("undefined")) {
            listings = _auctionHouse.searchDescription(query, first, nItems);
        } else {
            Long categoryId = Long.parseLong(category);
            if(categoryId == -1) listings = _auctionHouse.searchDescription(query, first, nItems);
            else {
                Category cat = Shop.getInstance().getCategoryList().find(categoryId);
                listings = _auctionHouse.searchDescription(query, cat, first, nItems);
            }
        }
        
        List<ListingProxy> proxyListings = new ArrayList<>(listings.size());
        
        for(Listing listing : listings) {
            proxyListings.add(new ListingProxy(listing));
        }
        
        return Response.ok(proxyListings).build();
    }
    
    @GET
    @Path("/count")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCount() {
        return Response.ok(_auctionHouse.getCount()).build();
    }
}
