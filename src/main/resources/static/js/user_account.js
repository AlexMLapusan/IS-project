(function ($) {
    // check if a user is logged
    const retrievedObject = localStorage.getItem('loggedUser');
    if (!retrievedObject) {
        window.location.replace(window.location.origin + "/login");
    }
    //declare the user that is currently logged in
    let loggedUser = JSON.parse(retrievedObject);

    //update user
    (function refetchLoggedUser(userId) {
        let settings = {
            "url": window.location.origin + "/req/user/" + userId,
            "method": "GET",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            },
        };

        $.ajax(settings).done(function (response) {
            localStorage.setItem('loggedUser', JSON.stringify(response));
            loggedUser = response;
            mainBody()
        });
    })(loggedUser.id)


    //WARNING posibil sa fie problema la tickets (daca nu le trimit o sa fie [] dupa update) da rezolvi tu

    function renderAssets() {
        let $ticketSubscription = $("#ticket_subscription"),
            $oneRouteSubscription = $('#one_route_subscription'),
            $twoRoutesSubsctiption = $('#two_routes_subscription');

        let noOfTicketsAvailable = loggedUser.tickets.filter(ticket => !ticket.activity).length,
            ticketSubscription = loggedUser.ticketSubscriptions,
            oneRouteSubscription = loggedUser.routeSubscriptions.filter(sub => sub.type === "_1_ROUTE_SUBSCRIPTION"),
            twoRoutesSubscription = loggedUser.routeSubscriptions.filter(sub => sub.type === "_2_ROUTES_SUBSCRIPTION");

        function displaySubInfo(subscription) {
            let $subInfo = null;
            if (!subscription.routes) {
                //ticket subscription
                $subInfo = $("<div>" + subscription.type.replace('_', ' ').toLowerCase() + " available until: " + subscription.expiryDate.substr(0,10) + "</div>");
            } else {
                $subInfo = $("<div>" + subscription.type.replace('_', ' ').toLowerCase() + " available until: " + subscription.expiryDate.substr(0,10) + " on routes: " +
                    subscription.routes.map(route => route.alias).join(', ') + "</div>");
            }
            return $subInfo;
        }

        if (ticketSubscription.length) {
            let $toAppend = $("<div></div>");
            ticketSubscription.forEach(sub=>{
                $toAppend.append(displaySubInfo(sub));
            });
            $ticketSubscription.append($toAppend);
        }
        if (oneRouteSubscription.length) {
            let $toAppend = $("<div></div>");
            oneRouteSubscription.forEach(sub=>{
                $toAppend.append(displaySubInfo(sub));
            });
            $oneRouteSubscription.append($toAppend);
        }
        if (twoRoutesSubscription.length) {
            let $toAppend = $("<div></div>");
            twoRoutesSubscription.forEach(sub=>{
                $toAppend.append(displaySubInfo(sub));
            });
            $twoRoutesSubsctiption.append($toAppend);
        }

        $("#no_of_tickets").val(noOfTicketsAvailable).text(noOfTicketsAvailable);
        $("#user_assets button").click(() => {
            if (noOfTicketsAvailable === 0) {
                alert("No tickets available");
            } else {
                let settings = {
                    "url": window.location.origin + "/req/user/use-ticket",
                    "method": "PUT",
                    "timeout": 0,
                    "headers": {
                        "Content-Type": "application/json"
                    },
                    "data": JSON.stringify({"id": loggedUser.id}),
                };

                $.ajax(settings).done(function (response) {
                    if (response) {
                        alert("Ticket activated for the next 30 minutes");
                        localStorage.setItem('loggedUser', JSON.stringify(response));
                        noOfTicketsAvailable = response.tickets.filter(ticket => !ticket.activity).length;
                        $("#no_of_tickets").val(noOfTicketsAvailable).text(noOfTicketsAvailable);
                    }
                });
            }
        });
    }

    function mainBody() {

        renderAssets();

        $("#first_name").val(loggedUser.firstName);
        $("#last_name").val(loggedUser.lastName);
        $("#address").val(loggedUser.address);
        $("#phone_number").val(loggedUser.phoneNumber);
        $("#email").val(loggedUser.email);
        $("#image_src").attr("src", loggedUser.image);

        $("#update_button").click(() => {
            let inputPassword = CryptoJS.MD5($("#password").val()).toString(),
                newPassword = $("#new_password").val(),
                newPasswordConfirmation = $("#confirmed_password").val();
            if (inputPassword === loggedUser.password && newPassword === newPasswordConfirmation) {
                if (newPassword === "") {
                    newPassword = inputPassword;
                } else {
                    newPassword = CryptoJS.MD5(newPassword).toString();
                }
                let firstName = $("#first_name").val(),
                    lastName = $("#last_name").val(),
                    address = $("#address").val(),
                    phoneNumber = $("#phone_number").val(),
                    email = $("#email").val(),
                    confirmed = 1,
                    imageSrc = $("#image_src").attr("src");

                /*if(email !== loggedUser.email)
                    confirmed = 0;
                } */


                var settings = {
                    "url": window.location.origin + "/req/user/update",
                    "method": "PUT",
                    "timeout": 0,
                    "headers": {
                        "Content-Type": "application/json"
                    },
                    "data": JSON.stringify({
                        "id": loggedUser.id,
                        "confirmed": confirmed,
                        "firstName": firstName,
                        "lastName": lastName,
                        "address": address,
                        "phoneNumber": phoneNumber,
                        "email": email,
                        "password": newPassword,
                        "image": imageSrc
                    }),
                };

                $.ajax(settings).done(function (response) {
                    console.log(response);
                    if (response.status === "OK") {

                        loggedUser.firstName = firstName;
                        loggedUser.lastName = lastName;
                        loggedUser.address = address;
                        loggedUser.phoneNumber = phoneNumber;
                        loggedUser.email = email;
                        loggedUser.imageSrc = imageSrc;
                        loggedUser.password = newPassword;
                        localStorage.setItem('loggedUser', JSON.stringify(loggedUser));

                        alert("Account updated successfully.");
                        location.reload();
                    } else {
                        if (response.data === "email") {
                            alert("An account with this email address already exists!");
                        } else {
                            alert("Something went wrong. Please try again");
                        }
                    }
                });
            } else {
                alert("Wrong password or new password does not match the confirmation.");
            }
        });
    }
})(jQuery);