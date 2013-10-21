$(function() {
    var dateString = $('#endingDate').text();
    CountDownTimer(dateString, 'countdown');
});

function CountDownTimer(dt, id)
{
    var end = new Date(dt);

    var _second = 1000;
    var _minute = _second * 60;
    var _hour = _minute * 60;
    var _day = _hour * 24;
    var timer;

    function showRemaining() {
        var now = new Date();
        var distance = end - now;
        if (distance < 0) {

            clearInterval(timer);
            document.getElementById(id).innerHTML = '<font color="red">Avslutad!</font>';

            return;
        }
        var days = Math.floor(distance / _day);
        var hours = Math.floor((distance % _day) / _hour);
        var minutes = Math.floor((distance % _hour) / _minute);
        var seconds = Math.floor((distance % _minute) / _second);

        if(days > 0) {
            document.getElementById(id).innerHTML = days + ' dagar ';
        } else if(hours > 0) {
            document.getElementById(id).innerHTML = hours + ' tim ';
            document.getElementById(id).innerHTML += minutes + ' min ';
        } else if(minutes > 0) {
            document.getElementById(id).innerHTML = minutes + ' min ';
            document.getElementById(id).innerHTML += seconds + ' s';
        } else {
            document.getElementById(id).innerHTML = seconds + ' s';
        }
    }

    showRemaining();
    timer = setInterval(showRemaining, 1000);
}