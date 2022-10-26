console.log("start");

$("#btn").click(function(){
    console.log("click");
});

//const buttons = document.getElementsByClassName("buttons");
//const buttons = document.querySelectorAll(".buttons")

$(".buttons").click(function(){
    console.log("buttons");
})

$("#test").on("click", "#btn2", function(){});

