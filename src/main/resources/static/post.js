$(document).ready(function () {


        $("#lineForm").submit(function (event) {
            saveJson();
            resetData();
            event.preventDefault();
        });

        function saveJson() {

            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/list",
                data : $("#lineVal").val(),
                // dataType : 'json',
                success: function (result) {
                    console.log("New line was created");
                    $('#getAllLines').trigger('click');
                }
            })
        }

        function resetData() {

            $('#lineVal').val("");
        }


    }
);