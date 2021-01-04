(function ($) {
    $("#buyTicket").click(() => {
        var quantity = $("#ticketQuantity").val();
        var settings = {
            "url": window.location.origin+"/req/buy/ticket/" + quantity,
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            }
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            window.location.replace(window.location.origin + "/user_account");
        });
    });
})(jQuery);