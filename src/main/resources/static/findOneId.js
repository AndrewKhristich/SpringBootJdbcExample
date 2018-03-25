$(document).ready(function () {
    $('#searchButton').click(function (event) {

        event.preventDefault();
        getNames();
    });

    function getNames() {
        var option = $('#optionalDiv').val();
        if (option == "id") {
            option = $('#search').val();
            $.ajax({
                url: '/findName/' + option,
                type: 'GET',
                success: function (result) {
                    $('#searchLine').find('.search').empty();
                        var line = "Id : " + option + " , Value : " + result + "<br>";
                        $('#searchLine').find('.search').append(line);
                }
            })
        }
    }
});
