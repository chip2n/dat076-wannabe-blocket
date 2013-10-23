// Stuff to do when document has fully loaded
function login() {
    $(".pop").slideFadeToggle(function() {
        $("#username").focus();
    });
    return false;
}

/*$(function() {
    // Bind login button to display a login popup
    var loginLink = $('a').filter(function(index) { return $(this).text() === "Logga in"; }); // TODO: Add special ID so that we dont have to search for the login link
    loginLink.click(function() {
        $(".pop").slideFadeToggle(function() { 
                $("#username").focus();
            });
    });
    
})
*/
$.fn.slideFadeToggle = function(easing, callback) {
    return this.animate({ opacity: 'toggle', height: 'toggle' }, "fast", easing, callback);
};