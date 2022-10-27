console.log("FileManger");

let count=0;

$("#fileAdd").click(function(){
    
    if(count<5){
        let r = '<div class="mb-3">';
        r = r+'<label for="contents" class="form-label">File</label>';
        r = r+'<input type="file" name="files">';
        r = r+'</div>';
        $("#fileAddResult").append(r);
        count++;
    }else {
        alert("최대 5개만 가능")
    }


    
});