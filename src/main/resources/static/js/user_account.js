(function ($) {

    //WARNING posibil sa fie problema la tickets (daca nu le trimit o sa fie [] dupa update) da rezolvi tu

    $("#update_button").click(() => {
        let inputPassword = $("#password").val(),
            actualPassword = $("#current_password").text(),
            newPassword = $("#new_password").val(),
            newPasswordConfirmation = $("#confirmed_password").val();
        if(inputPassword === actualPassword && newPassword === newPasswordConfirmation){
            let id = $("#user_id").text(),
                confirmed = $("#confirmation_status").text(),
                firstName = $("#first_name").val(),
                lastName = $("#last_name").val(),
                address = $("#address").val(),
                phoneNumber = $("#phone_number").val(),
                email = $("#email").val(),
                imageSrc = $("#image_src").attr("src");

            var settings = {
                "url": window.location.origin + "/req/user/update",
                "method": "PUT",
                "timeout": 0,
                "headers": {
                    "Content-Type": "application/json"
                },
                "data": JSON.stringify({
                    "id": id,
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
                if (response !== null) {
                    alert("Account updated successfully.");
                    location.reload();
                } else {
                    alert("Something went wrong. Please try again");
                }
            });
        }else {
            alert("Wrong password or new password does not match the confirmation.");
        }
    });
})(jQuery);