$(document).ready(function () {
    $("#getAllLines").click(function (event) {

        event.preventDefault();
        getJson();
    });

    function getJson() {
        $.ajax({
            url: '/list',
            type: 'GET',
            success: function (result) {
                $('#getResultDiv').find('.line-list').empty();
                $.each(result, function (i, line) {
                    var line = "Id : " + line.id + " , Value : " + line.name + "<br>";
                    $('#getResultDiv').find('.line-list').append(line);
                })
            }

        })
    }
});
