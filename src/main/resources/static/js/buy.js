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
            tripNumber = (tripInput === "unlimited") ? 150 : tripInput,
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
    $( "#tickets_subscription" ).change(function() {
        let tripInput = $("#tickets_subscription").val().toLowerCase(),
            tripNumber = (tripInput === "nelimitat") ? "150" : tripInput,
            settings = {
                "url": window.location.origin + "/req/buy/price_tickets_subscription",
                "method": "POST",
                "timeout": 0,
                "headers": {
                    "Content-Type": "application/json"
                },
                "data": tripNumber
            };

        $.ajax(settings).done(function (response) {
            $("#tickets_subscription_price").text("Price: " + response.data);
        });
    });

    let settings = {
        "url": window.location.origin + "/req/buy/price_oneRouteSub",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": ""
    };

    $.ajax(settings).done(function (response) {
        $("#OneRouteSub_price").text("Price: " + response.data);
    });

    settings = {
        "url": window.location.origin + "/req/buy/price_twoRouteSub",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": ""
    };

    $.ajax(settings).done(function (response) {
        $("#TwoRouteSub_price").text("Price: " + response.data);
    });

    $( "#ticketQuantity" ).change(function() {
        let quantity = $("#ticketQuantity").val();
            settings = {
                "url": window.location.origin + "/req/buy/price_ticket",
                "method": "POST",
                "timeout": 0,
                "headers": {
                    "Content-Type": "application/json"
                },
                "data": ""
            };

        $.ajax(settings).done(function (response) {
            let price = parseInt(response.data);
            $("#Tikets_price").text("Price: " + quantity * price);
        });
    });
    settings = {
        "url": window.location.origin + "/req/buy/price_tickets_subscription",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": "30"
    };

    $.ajax(settings).done(function (response) {
        $("#tickets_subscription_price").text("Price: " + response.data);
    });
})(jQuery);