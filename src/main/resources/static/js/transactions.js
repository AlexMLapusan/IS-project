(function ($) {

    function populateTable(transactions) {
        let $table = $("#transactions_table").removeAttr('width').DataTable({
            columns: [
                {title: 'ID'},
                {title: 'Type'},
                {title: 'Income'},
                {title: 'Purchase Date'},
                {title: 'Item ID'},
            ]
        });

        transactions.forEach(transaction => {
            $table.row.add(transaction);
        });

        $table.draw();
    }

    const settings = {
        url: window.location.origin + "/req/transaction/all",
        method: "GET",
        timeout: 0,
        dataType: 'json',
    };

    $.ajax(settings).done(function (response) {
        console.log({"data": response});
        populateTable(response.map(object => Object.values(object)));
    });
})(jQuery);