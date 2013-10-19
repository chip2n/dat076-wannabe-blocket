var ah = (function() {
    var baseUri = "http://localhost:8080/ah/rs/";
    var auctionHouse = new AuctionHouse(baseUri + "auctions");
    
    return {
        getAuctionHouse: function() {
            return auctionHouse;
        }
    };
})();