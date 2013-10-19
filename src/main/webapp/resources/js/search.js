    
// Read a page's GET URL variables and return them as an associative array.
function getUrlVars()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}

$(function() {
    ah.getAuctionHouse().search(getUrlVars()["query"], 0, 3).done(function(listings) {
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