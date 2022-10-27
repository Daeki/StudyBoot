console.log("memberAdd");

$("#all").click(function(e){
    
   let ch = $(this).prop("checked");

   $(".check").prop("checked", ch);

   
})

$(".check").click(function(){

    //let flag=true;
    $("#all").prop("checked", true);

    $(".check").each(function(idx, item){
        let ch = $(item).prop("checked")
        if(!ch){
            //flag=false;
            $("#all").prop("checked", false);
            console.log(ch);
            return false;
        }        
    });

    // $("#all").prop("checked", flag);
    //모두 check?? 아니면 하나이상이 체크 X??



});
//id, pw, pwEquals, name, email
let results = [false, false, false, false, false];

//// ID Check
$("#inputId").blur(function(){
    console.log("start")
    let id = $("#inputId").val();
    let result = nullCheck(id, $("#inputIdResult"), "ID");
    results[0]=result;
    console.log(result)
    //단 id가 비어있지 않을 때
    $.get("./idCheck?id="+id, function(data){
        console.log("Data : ", data);
        if(data=='0'){
            $("#inputIdResult").html("사용가능한 ID");
            results[0]=true;
        }else {
            $("#inputIdResult").html("이미 사용중인 ID");
            results[0]=false;
        }

    })


});

//// pw check
// $("#inputPw").blur(function(){
//     let result = nullCheck($("#inputPw").val(), $("#inputPwResult"), "PW");
//     results[1]=result;

// })

// $("#inputPw").change(function(){
//     $("#inputPwCheck").val("");
//     results[2]=false;
//     $("#inputPwCheckResult").html("");
// });

$("#inputPw").on({
    blur: function(){
            let result = nullCheck($("#inputPw").val(), $("#inputPwResult"), "PW");
            results[1]=result;
        
        },
    change: function(){
            $("#inputPwCheck").val("");
            results[2]=false;
            $("#inputPwCheckResult").html("");
        }

});


//// pw Equal Check
$("#inputPwCheck").blur(function(){

    let result = equals($("#inputPw").val(), $("#inputPwCheck").val());
    if(result){
        $("#inputPwCheckResult").html("정상")
   }else {
    $("#inputPwCheckResult").html("PW가 틀립니다");
   }
   results[2]=result;
})

//// name check
$("#inputName").blur(function(){
    let result = nullCheck($("#inputName").val(),  $("#inputNameResult"), "Name")
    results[3]=result;
})

//// email check
$("#inputEmail").blur(function(){
    let result = nullCheck($("#inputEmail").val(), $("#inputEmailResult"), "Email")
    results[4]=result;
})

$("#joinButton").click(function(){

    if(results.includes(false)){
        alert("필수 입력은 다 입력해");
    }else {
        alert("전송");
        //$("#joinForm").submit();
    }

    // let c = true;
    // $.each(results, function(idx, item){
    //     if(!item){
    //         alert("필수 입력은 다 입력해");
    //         c=false;
    //         return c;
    //     }
    // })
    // //event 강제 실행
    // if(c){
    //  $("#joinForm").submit();
    // }
});