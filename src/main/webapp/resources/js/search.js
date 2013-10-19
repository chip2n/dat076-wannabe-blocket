$(function() {
    ah.getAuctionHouse().getRange(0, 3).done(function(listings) {
        createTable(listings);
    });
    
    var nav = new Navigator(ah.getAuctionHouse());

    $("#prev-button").click(function() {
        nav.prev(createTable, fail);
    });
    $("#next-button").click(function() {
        nav.next(createTable, fail);
    });
 
    function createTable(listings) {
        // Use JQuery and HTML
        // First, clear tbody
        $("tbody").empty();
        listings.forEach(function(entry) {
            var description = entry.description;
            $("#products").find("tbody").first().append("<tr><td>" + "hej" + "</td><td>" + description + "</td><td>" + "price" + "</td></tr>");
        });
    }
    
    function fail() {
        alert("Failed");
    }
    
    function success() {
        alert("Success");
    }
});