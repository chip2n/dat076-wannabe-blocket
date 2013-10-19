$(function() {
     ah.getAuctionHouse().getRange(0, 3).done(function(listings) {
        createTable(listings);
    });
 
    function createTable(listings) {
        // Use JQuery and HTML
        // First, clear tbody
        $("tbody").empty();
        listings.forEach(function(entry) {
            var description = entry.description;
            $("#products").find("tbody").first().append("<tr><td>" + "hej" + "</td><td>" + description + "</td><td>" + "price" + "</td></tr>");
        });

        $("#prev-button").click(function() {
            nav.prev(createTable, fail);
        });
        $("#next-button").click(function() {
            nav.next(createTable, fail);
        });
    }
    
    function fail() {
        alert("Failed");
    }
});