package com.wannabeblocket.ah;

import com.wannabeblocket.model.Account;
import com.wannabeblocket.model.AuctionHouse;
import com.wannabeblocket.model.Category;
import com.wannabeblocket.model.Listing;
import com.wannabeblocket.model.Shop;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
        _auctionHouse = Shop.getInstance("ah_pu").getAuctionHouse();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() { 
        List<Listing> listings = _auctionHouse.getAll();
        //listings.add(new Listing(new Account("Kalle"), "desc", new Date(), new Category("Hej")));
        List<ListingProxy> proxyListings = new ArrayList<ListingProxy>(listings.size());
        
        for(Listing listing : listings) {
            proxyListings.add(new ListingProxy(listing));
        }
        
        GenericEntity<List<ListingProxy>> p = new GenericEntity<List<ListingProxy>>(proxyListings){};
        
        return Response.ok(p).build();
        
        //return Response.ok().build();
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response add(@FormParam("seller") String seller, @FormParam("description") String description) {
        // TODO: Add listing to auction house. How should we handle authentication here?
        _auctionHouse.add(new Listing(new Account("HEJ"), "DESCRIPTION", new Date(), new Category("Yolo")));
        return Response.ok().build();
    }
}
