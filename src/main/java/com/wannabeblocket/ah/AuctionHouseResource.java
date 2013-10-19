package com.wannabeblocket.ah;

import com.wannabeblocket.model.Account;
import com.wannabeblocket.model.AuctionHouse;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.Shop;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    private AuctionHouse _auctionHouse;
    
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
        
        //return Response.ok().build();
    }
    
    @GET
    @Path("/range")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRange(@QueryParam("fst") int first, @QueryParam("max") int nItems) {
        List<Listing> listings = _auctionHouse.getRange(first, nItems);
        
        
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
