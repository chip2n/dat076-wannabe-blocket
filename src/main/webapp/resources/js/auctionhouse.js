var AuctionHouse = function(url) {
    this.url = url;
};

AuctionHouse.prototype = (function() {
    return {
        search: function(query, first, nItems) {
            return $.getJSON("http://localhost:8080/ah/rs/auctions/range?fst=" + first + "&max=" + nItems + "&query=" + query);
        },
        getRange: function(first, nItems) {
            return $.getJSON("http://localhost:8080/ah/rs/auctions/range?fst=" + first + "&max=" + nItems + "&query=glad");
        },
        getCount: function() {
            return $.getJSON("http://localhost:8080/ah/rs/auctions/count");
        }
    };
})();