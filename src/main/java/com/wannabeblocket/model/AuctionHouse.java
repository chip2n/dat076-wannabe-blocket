package com.wannabeblocket.model;

public class AuctionHouse extends AbstractDAO<Listing, Long> {

    public AuctionHouse() {
        super(Listing.class);
    }

    /**
     *
     * @param listing
     */
    public void createListing(Listing listing) {
        add(listing);
    }

    /**
     *
     * @param id
     */
    public void deleteListing(long id) {
        remove(id);
    }

    /**
     *
     * @param id
     */
    public Listing getListingById(long id) {
        return find(id);
    }

    /**
     *
     * @param seller
     */
    public Listing[] getListingsBySeller(Account seller) {
        // TODO - implement AuctionHouse.getListingsBySeller
        throw new UnsupportedOperationException();
    }
}
