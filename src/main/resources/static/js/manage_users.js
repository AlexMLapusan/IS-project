(function ($) {

    function populateTable(users) {
        console.log(users);
        let $table = $("#users_table").DataTable({
            columns: [
                {title: 'ID'},
                {title: 'First name'},
                {title: 'Last name'},
                {title: 'Address'},
                {title: 'Phone Number'},
                {title: 'Email'},
                {title: 'Password'},
                {title: 'Confirmed'},
                {title: 'Image'},
                {title: 'Tickets'},
                {title: 'Action'}
            ]
        });

        users.forEach(user => {
            let newRow = [...user];
            newRow.push("<button class = \"delete\">Delete</button>");
            $table.row.add(newRow);
        });

        $table.draw();
        $(".delete").click(function () {
            const id = $($(this).parents("tr").find("td")[0]).text();
            console.log(id);
            var settings = {
                "url": window.location.origin + "/req/user/delete/" + id,
                "method": "DELETE",
                "timeout": 0,
            };

            $.ajax(settings).done(function (response) {
                if(response){
                    location.reload();
                }
            });

        });
    }

    const settings = {
        url: window.location.origin + "/req/user/all",
        method: "GET",
        timeout: 0,
        dataType: 'json',
    };

    $.ajax(settings).done(function (response) {
        console.log({"data": response});
        if (response.length !== 0) {
            populateTable(response.map(object => Object.values(object)));
        }
    });
})(jQuery);