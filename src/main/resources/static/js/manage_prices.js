(function ($) {

    function populateTable(transactions) {
        let $table = $("#price_table").removeAttr('width').DataTable({
            columns: [
                {title: 'ID'},
                {title: 'Type'},
                {title: 'Price'},
                {title: 'Action'}
            ]
        });

        transactions.forEach(transaction => {
            let newRow = [transaction[0],
                transaction[1],
                "<input type='text' value='" + transaction[2] + "'>",
                "<button class = 'change_price'>Change price</button>"];
            $table.row.add(newRow);
        });

        $table.draw();
        $(".change_price").click(function () {
            const id = $($(this).parents("tr").find("td")[0]).text(),
                price = $(this).parents("tr").find("input").val();

            let settings = {
                "url": window.location.origin + "/req/prices/update/" + price,
                "method": "PUT",
                "timeout": 0,
                "headers": {
                    "Content-Type": "application/json"
                },
                "data": JSON.stringify({"id": id}),
            };

            $.ajax(settings).done(function (response) {
                if (response) {
                    location.reload();
                }
            });

        });

    }

    const settings = {
        url: window.location.origin + "/req/prices/all",
        method: "GET",
        timeout: 0,
        dataType: 'json',
    };

    $.ajax(settings).done(function (response) {
        console.log({"data": response});
        populateTable(response.map(object => Object.values(object)));
    });
})(jQuery);