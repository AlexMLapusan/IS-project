(function ($) {

    function parseTime(hour, min) {
        return (hour % 10 === hour ? "0" + hour : "" + hour) + ":" + (min % 10 === min ? "0" + min : "" + min);
    }

    function generateTable($tableDiv) {
        let startingHour = $tableDiv.attr("startingHour"),
            endingHour = $tableDiv.attr("endingHour"),
            interval = parseInt($tableDiv.attr("routeInterval")),
            currentMin = parseInt(startingHour.substr(-2)),
            currentHour,
            parity = "odd";

        for (currentHour = parseInt(startingHour.substr(0, 2)); currentHour < parseInt(endingHour.substr(0, 2)); currentHour++) {
            currentMin = currentMin % 60;
            while (currentMin < 60) {
                let $newRow = $("<tr>\n" +
                    "    <td>" + parseTime(currentHour, currentMin) + "</td>\n" +
                    "    <td>" + parseTime(currentHour, currentMin) + "</td>\n" +
                    "</tr>").addClass(parity);
                $tableDiv.find('tbody').append($newRow);
                currentMin += interval;
                parity = parity === "odd" ? "even" : "odd";
            }
        }
        currentMin = currentMin % 60;
        while (currentMin < parseInt(endingHour.substr(-2))) {
            let $newRow = $("<tr>\n" +
                "    <td>" + currentHour + ":" + currentMin + "</td>\n" +
                "    <td>" + currentHour + ":" + currentMin + "</td>\n" +
                "</tr>").addClass(parity);
            $tableDiv.find("tbody").append($newRow);
            currentMin += interval;
            parity = parity === "odd" ? "even" : "odd";
        }

        $(".routes button").click(function () {
            $(".route_info").toggle(false);
            $("#" + $(this).val()).toggle(true);
        });
    }

    $(".timetable").each((key, table) => {
        generateTable($(table));
    });

})(jQuery);