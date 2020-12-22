(function ($) {
    $("#register").click(() => {
        let firstName = $("#first_name").val(),
            lastName = $("#last_name").val(),
            address = $("#address").val(),
            phoneNumber = $("#phone_number").val(),
            email = $("#email").val(),
            password = $("#password").val(),
            imageSrc = $("#image_src").val();

        var settings = {
            "url": window.location.origin + "/register/user",
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
            if(response !== null)
            {
                alert("Account created. You will now be redirected to the login page");
                window.location.replace(window.location.origin + "/login");
            }else{
                alert("Something went wrong. Please try again later");
            }
        });
    });
})(jQuery);