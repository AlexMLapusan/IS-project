(function ($) {

    function getButtonForStation(station) {
        return "<button station_id = '" + station.id + "' class=\"btn delete_station_button\"><i class=\"fa fa-close\"></i>" + station.name + "</button>";
    }

    function populateTable(routes) {
        console.log(routes);
        let $table = $("#routes_table").DataTable({
            columns: [
                {title: 'ID'},
                {title: 'Alias'},
                {title: 'Starting Hour'},
                {title: 'Ending Hour'},
                {title: 'Interval'},
                {title: 'Stations'},
                {title: 'Add station'},
                {title: 'Action'}
            ]
        });

        let newRow = [null,
            "<input id='route_alias' type='text'>",
            "<input id='route_start_hour' type='text'>",
            "<input id='route_end_hour' type='text'>",
            "<input id='route_interval' type='text'>",
            null,
            null,
            "<button id = 'add_button'>Add station</button>"];

        $table.row.add(newRow);

        routes.forEach(route => {
            //this is bad code, DO NOT DO IT (except now, not it's fine)
            let stations = route.stations.map(getButtonForStation),
                $addStation = $("<span></span>").append($("<select></select>").addClass("station_select").html($("#stations").html())).append("<button class='add_station' >Add</button>");

            newRow = [route.id, route.alias, route.startingHour, route.endingHour, route.routeInterval, stations, $addStation.html()];

            newRow.push("<button class = \"delete\">Delete</button>");
            $table.row.add(newRow);
        });

        $table.draw();

        //delete station event
        $(".delete_station_button").click(function () {
            let routeId = $($(this).parents("tr").find("td")[0]).text(),
                stationId = $(this).attr('station_id'),
                settings = {
                    url: window.location.origin + "/req/route/remove_station/" + stationId,
                    method: "PUT",
                    timeout: 0,
                    headers: {
                        "Content-Type": "application/json"
                    },
                    data: JSON.stringify({id: routeId}),
                };

            $.ajax(settings).done(function (response) {
                location.reload();
            });
        });

        //delete button event
        $(".delete").click(function () {
            const id = $($(this).parents("tr").find("td")[0]).text();
            console.log(id);
            var settings = {
                "url": window.location.origin + "/req/route/delete/" + id,
                "method": "DELETE",
                "timeout": 0,
            };

            $.ajax(settings).done(function (response) {
                if (response) {
                    location.reload();
                }
            });
        });

        //add station button event
        $(".add_station").click(function () {
            let routeId = $($(this).parents("tr").find("td")[0]).text(),
                stationId = $(this).prev("select").val(),
                settings = {
                    "url": window.location.origin + "/req/route/add_station/" + stationId,
                    "method": "PUT",
                    "timeout": 0,
                    headers: {
                        "Content-Type": "application/json"
                    },
                    data: JSON.stringify({
                        id: routeId
                    }),
                };

            $.ajax(settings).done(function (response) {
                if (response) {
                    location.reload();
                }
            });
        });

        //add new route button event
        $("#add_button").click(function () {
            let alias = $("#route_alias").val(),
                startingHour = $("#route_start_hour").val(),
                endingHour = $("#route_end_hour").val(),
                interval = $("#route_interval").val(),
                settings = {
                    "url": window.location.origin + "/req/route/insert",
                    "method": "POST",
                    "timeout": 0,
                    headers: {
                        "Content-Type": "application/json"
                    },
                    data: JSON.stringify({
                        alias: alias,
                        startingHour: startingHour,
                        endingHour: endingHour,
                        routeInterval: interval
                    }),
                };

            $.ajax(settings).done(function (response) {
                if (response) {
                    location.reload();
                }
            });
        });
    }

    const settings = {
        url: window.location.origin + "/req/route/all",
        method: "GET",
        timeout: 0,
        dataType: 'json',
    };

    $.ajax(settings).done(function (response) {
        console.log({"data": response});
        if (response.length !== 0) {
            populateTable(response);
        }
    });
})(jQuery);