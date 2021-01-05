(function ($) {

    let retrievedObject = localStorage.getItem('loggedAdmin');
    if(retrievedObject == null)
    {
        window.location.replace(window.location.origin + "/login");
    }
    let loggedAdmin = JSON.parse(retrievedObject);

    $("#email").val(loggedAdmin.email);

    $("#update_button").click(() => {
        let inputPassword = CryptoJS.MD5($("#password").val()).toString(),
            newPassword = $("#new_password").val(),
            newPasswordConfirmation = $("#confirmed_password").val();
        if(inputPassword === loggedAdmin.password && newPassword === newPasswordConfirmation){
            if(newPassword === "")
            {
                newPassword = inputPassword;
            }
            else
            {
                newPassword = CryptoJS.MD5(newPassword).toString();
            }
            let email = $("#email").val(),
                confirmed = 1;

            var settings = {
                "url": window.location.origin + "/req/admin/update",
                "method": "PUT",
                "timeout": 0,
                "headers": {
                    "Content-Type": "application/json"
                },
                "data": JSON.stringify({
                    "id": loggedAdmin.id,
                    "confirmed": confirmed,
                    "email": email,
                    "password": newPassword,
                }),
            };

            $.ajax(settings).done(function (response) {
                console.log(response);
                if (response.status === "OK") {

                    loggedAdmin.email = email;
                    loggedAdmin.password = newPassword;
                    localStorage.setItem('loggedAdmin', JSON.stringify(loggedAdmin));

                    alert("Account updated successfully.");
                    location.reload();
                } else {
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
        }else {
            alert("Wrong password or new password does not match the confirmation.");
        }
    });
})(jQuery);