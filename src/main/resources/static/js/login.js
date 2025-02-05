(function ($) {
    $("#login").click(() => {
        let email = $("#user_email").val(),
            password = CryptoJS.MD5($("#user_password").val()).toString();

        let url = window.location.origin+"/req/login";

        if($("#isAdmin").is(":checked"))
        {
            url += "/admin";
        }else
        {
            url += "/user";
        }

        let settings = {
            "url": url,
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
                if(response.data.firstName)
                {
                    localStorage.setItem('loggedUser', JSON.stringify(response.data));
                    window.location.replace(window.location.origin + "/home_user");
                }
                else
                {
                    localStorage.setItem('loggedAdmin', JSON.stringify(response.data));
                    window.location.replace(window.location.origin + "/home_admin");
                }
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
                    $("#reset_msg").css('display', "block");
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

   $("#password_reset").click(() => {

        let email = $("#user_email").val();
        let newPassword = Math.random().toString(10).substring(2,10);
        let newPasswordEncrypted = CryptoJS.MD5(newPassword).toString();
        let url = window.location.origin+"/req/";

        if($("#isAdmin").is(":checked"))
        {
            url+="admin/send-reset-email";
        }else
        {
            url+="user/send-reset-email";
        }

        var settings = {
            "url": url,
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({"email": email, "password": newPassword, "passwordEncrypted":newPasswordEncrypted}),
        };

        console.log(settings);

        $.ajax(settings).done(function (response) {
            console.log(response);
            if(response.status === "OK")
            {
                alert("An email was sended to your email account!");
                //window.location.replace(window.location.origin + "/login");
            }
            else
            {
                alert("Try again!");
            }
        });
    });

})(jQuery);