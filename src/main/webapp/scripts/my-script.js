$(document).ready(function(){
    
    $("#firstFormRef").click(function(){
        $("#form1").removeClass("hidden");
        $("#form2").addClass("hidden");
        $("#secondFormRef").removeClass("active");
        $("#firstFormRef").addClass("active");
    });

    $("#secondFormRef").click(function(){
        $("#form2").removeClass("hidden");
        $("#form1").addClass("hidden");
        $("#firstFormRef").removeClass("active");
        $("#secondFormRef").addClass("active");
    });

    $("#findBtn").click(function () {
        var firstName = $("#findInput").val();
        if (firstName === "" || firstName == undefined) {
            alert("No input parameters!");
        } else {
            $.post("/getPersons", {firstName: firstName}, function (data, status) {
                console.log(status);
                var answer = "";
                $(data).each(function(pos, person) {
                        answer += "Name: " + person.firstName + " " + person.lastName + ", phone - " + person.phoneNumber;
                        answer += "</br>";
                })
                $("#qwerty").html(answer);
            })
        }

    })
});