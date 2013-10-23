var AuctionHouse = function(url) {
    this.url = url;
};

AuctionHouse.prototype = (function() {
    return {
        search: function(query, category, first, nItems) {
            return $.getJSON("http://localhost:8080/ah/rs/auctions/range?fst=" + first + "&max=" + nItems + "&query=" + query + "&category=" + category);
        },
        getRange: function(first, nItems) {
            return $.getJSON("http://localhost:8080/ah/rs/auctions/range?fst=" + first + "&max=" + nItems);
        },
        getCount: function() {
            return $.getJSON("http://localhost:8080/ah/rs/auctions/count");
        }
    };
})();