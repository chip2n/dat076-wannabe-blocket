var ProductCatalogue = function(url) {
    this.url = url;
};

ProductCatalogue.prototype = (function() {
    return {
        getRange: function(first, nItems) {
            return $.getJSON("http://localhost:8080/ah/rs/auctions/range?fst=" + first + "&max=" + nItems);
        }
    };
})();