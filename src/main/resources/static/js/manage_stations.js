(function ($) {
    function populateTable(stations) {
        console.log(stations);
        let $table = $("#stations_table").DataTable({
            columns: [
                {title: 'ID'},
                {title: 'Name'},
                {title: 'Address'},
                {title: 'Action'}
            ]
        });

        let newRow = [null,
            "<input id='station_name' type='text'>",
            "<input id='station_address' type='text'>",
            "<button id = 'add_button'>Add station</button>"];
        $table.row.add(newRow);

        stations.forEach(station => {
            newRow = [...station];
            newRow.push("<button class = \"delete\">Delete</button>");
            $table.row.add(newRow);
        });

        $table.draw();

        $(".delete").click(function () {
            const id = $($(this).parents("tr").find("td")[0]).text();
            console.log(id);
            var settings = {
                "url": window.location.origin + "/req/station/delete/" + id,
                "method": "DELETE",
                "timeout": 0,
            };

            $.ajax(settings).done(function (response) {
                if (response) {
                    location.reload();
                }
            });
        });

        $("#add_button").click(function () {
            let name = $("#station_name").val(),
                address = $("#station_address").val(),
                settings = {
                    "url": window.location.origin + "/req/station/insert",
                    "method": "POST",
                    "timeout": 0,
                    headers: {
                        "Content-Type": "application/json"
                    },
                    data: JSON.stringify({
                        name: name,
                        address: address
                    }),
                };

            $.ajax(settings).done(function (response) {
                if (response.status=="OK")
                {
                    location.reload();
                }
                else{
                    allert("Couldn't do it! It has same name with another station.");
                }
            });
        });
    }

    const settings = {
        url: window.location.origin + "/req/station/all",
        method: "GET",
        timeout: 0,
        dataType: 'json',
    };

    $.ajax(settings).done(function (response) {
        console.log({"data": response});
        populateTable(response.map(object => Object.values(object)));

    });
})(jQuery);