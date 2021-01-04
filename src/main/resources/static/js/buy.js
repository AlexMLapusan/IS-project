(function ($) {
    let retrievedObject = localStorage.getItem('loggedUser');
    let loggedUser = JSON.parse(retrievedObject);

    $("#buyTicket").click(() => {
        var quantity = $("#ticketQuantity").val();
    var settings = {
        "url": window.location.origin+"/req/buy/ticket/" + quantity,
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data" : loggedUser.id
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        window.location.replace(window.location.origin + "/user_account");
    });
});

    $("#buyTripSub").click(() => {
        var tripInput = $("#tickets_subscription").val();
    var tripNumber = (tripInput === "nelimitat") ? 150 : tripInput;
    var settings = {
        "url": window.location.origin+"/req/buy/trip_sub/" + tripNumber,
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data" : loggedUser.id
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        window.location.replace(window.location.origin + "/user_account");
    });
});

    $("#buy1RouteSub").click(() => {
        var routeId = $("#one_line_option").val();
    var settings = {
        "url": window.location.origin + "/req/buy/route_1_sub/" + routeId,
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": loggedUser.id
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        window.location.replace(window.location.origin + "/user_account");
    });
});

    $("#buy2RoutesSub").click(() => {
        var route1Id = $("#two_lines_option_1").val();
    var route2Id = $("#two_lines_option_2").val();
    var settings = {
        "url": window.location.origin+"/req/buy/route_2_sub/" + route1Id + route2Id,
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data" : loggedUser.id
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        window.location.replace(window.location.origin + "/user_account");
    });
});
})(jQuery);