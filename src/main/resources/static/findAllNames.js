$(document).ready(function () {
    $('#searchButton').click(function (event) {

        event.preventDefault();
        getNames();
    });

    function getNames() {
        var option = $('#optionalDiv').val();
        if (option == "name") {
            option = $('#search').val();
            $.ajax({
                url: '/findName/' + option,
                type: 'GET',
                success: function (result) {
                    $('#searchLine').find('.search').empty();
                    $.each(result, function (i, line) {
                        var line = "Id : " + line.id + " , Value : " + line.name + "<br>";
                        $('#searchLine').find('.search').append(line);
                    });
                }
            })
        } else if (option=="id"){
            option = $('#search').val();
            $.ajax({
                url: '/findId/' + option,
                type: 'GET',
                success : function (name) {
                    $('#searchLine').find('.search').empty();
                    var line = "Id : " + option + " , Value : " + name + "<br>";
                    $('#searchLine').find('.search').append(line);
                }
            })
        }
    }
});
