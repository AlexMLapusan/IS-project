(function ($) {
    $("#login").click(() => {
        let email = $("#user_email").val(),
            password = $("#user_password").val();

        var settings = {
            "url": window.location.origin+"/req/login/user",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({"email": email, "password": password}),
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            window.location.replace(window.location.origin + "/home_user");
        });
    });
})(jQuery);