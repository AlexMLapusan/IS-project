(function ($) {
    $("#register").click(() => {
        let firstName = $("#first_name").val(),
            lastName = $("#last_name").val(),
            address = $("#address").val(),
            phoneNumber = $("#phone_number").val(),
            email = $("#email").val(),
            password = CryptoJS.MD5($("#password").val()).toString(),
            imageSrc = $("#image_src").val();

        var settings = {
            "url": window.location.origin + "/req/register/user",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({
                "firstName": firstName,
                "lastName": lastName,
                "address": address,
                "phoneNumber": phoneNumber,
                "email": email,
                "password": password,
                "image": imageSrc
            }),
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            if(response.status === "OK")
            {
                alert("Account created. You will now be redirected to the login page. Please confirm your email account. ");
                window.location.replace(window.location.origin + "/login");
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