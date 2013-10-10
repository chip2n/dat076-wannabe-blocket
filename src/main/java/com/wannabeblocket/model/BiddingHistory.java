package com.wannabeblocket.model;

public class BiddingHistory extends AbstractDAO<Bid, Long> {

    public BiddingHistory(String puName) {
        super(Bid.class, puName);
    }

    /**
     *
     * @param bid
     */
    public void placeBid(Bid bid) {
        // TODO - implement BiddingHistory.placeBid
        throw new UnsupportedOperationException();
    }

    public Bid[] getHistory() {
        // TODO - implement BiddingHistory.getHistory
        throw new UnsupportedOperationException();
    }

    public Bid getHighestBid() {
        // TODO - implement BiddingHistory.getHighestBid
        throw new UnsupportedOperationException();
    }
}
