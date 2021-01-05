(function ($) {
    $("#register").click(() => {
        let email = $("#email").val(),
            password = CryptoJS.MD5($("#password").val()).toString();

        var settings = {
            "url": window.location.origin + "/req/register/admin",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({
                "email": email,
                "password": password
            }),
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            if(response.status === "OK")
            {
                alert("Account created.  Please confirm email account!. ");
                $("#email").val("");
                $("#password").val("");
            }else{
                if(response.data === "email")
                {
                    alert("An account with this email address already exists!");
                }
                else
                {
                    alert("Something went wrong. Please try again");
                }
            }
        });
    });
})(jQuery);