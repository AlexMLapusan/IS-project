(function ($) {
    $("#logout").click(() => {
        localStorage.removeItem("loggedUser");
    });
})(jQuery);