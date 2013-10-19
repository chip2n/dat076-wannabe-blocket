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
         /*
        // Set on click listeners for all rows, yo
        $("#products").find("tr").click(function() {
            var id = $(this).find("td").first().text();
            var deferred = shop.getProductCatalogue().find(id);
            deferred.done(function(product) {
                createEditDeleteDialog(product);
            });
            deferred.fail(function() {
                alert("Failed to retrieve data :(");
            });
        });
         */
    }
});