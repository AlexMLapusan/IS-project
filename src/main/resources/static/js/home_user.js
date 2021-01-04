(function ($) {
    let retrievedObject = localStorage.getItem('loggedUser');

    if(retrievedObject == null)
    {
        window.location.replace(window.location.origin + "/login");
    }

    $("#logout").click(() => {
        localStorage.removeItem("loggedUser");
    });
})(jQuery);