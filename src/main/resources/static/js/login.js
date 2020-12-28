(function ($) {
    $("#login").click(() => {
        let email = $("#user_email").val(),
            password = CryptoJS.MD5($("#user_password").val()).toString();

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
            if(response.status === "OK")
            {
                localStorage.setItem('loggedUser', JSON.stringify(response.data));
                window.location.replace(window.location.origin + "/home_user");
            }
            else
            {
                if(response.data === "confirm")
                {
                    alert("Confirm your email address!");
                }
                else if(response.data === "email"){
                    $("#user_email").css('border', "solid 2px red");
                }
                else
                {
                    $("#user_password").css('border', "solid 2px red");
                }
            }
        });
    });

    $("#user_email").on('input',function () {
        $("#user_email").css('border', "");
    });

    $("#user_password").on('input',function () {
        $("#user_password").css('border', "");
    });
})(jQuery);