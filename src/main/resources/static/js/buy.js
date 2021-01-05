(function ($) {
    // check if a user is logged
    const retrievedObject = localStorage.getItem('loggedUser');
    if (!retrievedObject) {
        window.location.replace(window.location.origin + "/login");
    }
    let loggedUser = JSON.parse(retrievedObject);

    $("#buyTicket").click(() => {
        var quantity = $("#ticketQuantity").val();

        var settings = {
            "url": window.location.origin + "/req/buy/ticket/" + quantity,
            "method": "PUT",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({
                "id": loggedUser.id
            })
        };

        $.ajax(settings).done(function (response) {
            // console.log(response);
            alert("Tickets added to your account!");
        });
    });

    $("#buyTripSub").click(() => {
        let tripInput = $("#tickets_subscription").val(),
            tripNumber = (tripInput === "nelimitat") ? 150 : tripInput,
            settings = {
                "url": window.location.origin + "/req/buy/trip_sub/" + tripNumber,
                "method": "PUT",
                "timeout": 0,
                "headers": {
                    "Content-Type": "application/json"
                },
                "data": JSON.stringify({
                    "id": loggedUser.id
                })
            };

        $.ajax(settings).done(function (response) {
            console.log(response);
            alert("Subscription added to your account!");
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
            "data": JSON.stringify({
                "id": loggedUser.id
            })
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            alert("Subscription added to your account!");

        });
    });

    $("#buy2RoutesSub").click(() => {
        let route1Id = $("#two_lines_option_1").val(),
            route2Id = $("#two_lines_option_2").val(),
            settings = {
                "url": window.location.origin + "/req/buy/route_2_sub/",
                "method": "PUT",
                "timeout": 0,
                "headers": {
                    "Content-Type": "application/json"
                },
                "data": JSON.stringify({
                    "userID": loggedUser.id,
                    "route1ID": route1Id,
                    "route2ID": route2Id
                })
            };

        $.ajax(settings).done(function (response) {
            console.log(response);
            alert("Subscription added to your account!");

        });
    });
})(jQuery);