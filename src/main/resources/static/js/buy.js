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
            "data" : JSON.stringify({
                "id": loggedUser.id
            })
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            window.location.replace(window.location.origin + "/user_account");
        });
    });
})(jQuery);