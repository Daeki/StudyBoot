<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script defer type="text/javascript" src="/js/fileManger.js"></script>
<body>
	
	<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="col-6">
		<h1>Board Write Page</h1>
		<form action="add" method="post" enctype="multipart/form-data">
			<input type="hidden" num="123">
		
			<sec:csrfInput/>
			
			<div class="mb-3">
			  <label for="title" class="form-label">Titlea</label>
			  	<input type="text" name="title" class="form-control" id="title" placeholder="제목">
			</div>
			<div class="mb-3">
			  <label for="writer" class="form-label">Writer</label>
			  	<input type="text" name="writer" class="form-control" id="writer" placeholder="작성자">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" name="contents" id="contents"></textarea>
			</div>
			
			<div class="mb-3" id="fileAddResult">
				
			</div>
			<div class="mb-3">
				<button type="button" id="fileAdd">FileAdd</button>
			</div>
			
<!-- 		<div class="mb-3">
			  <label for="contents" class="form-label">File</label>
			  <input type="file" name="files">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">File</label>
			  <input type="file" name="files">
			</div> -->
			
			<div>
				<button class="btn btn-danger">WRITE</button>
			</div>
		</form>
		</div>
	</div>
	</div>
	
	<script type="text/javascript">
    $('#contents').summernote({
        tabsize: 4,
        height: 250,
		callbacks:{
			onImageUpload:function(file){
				console.log("ImageUpload");	
				//ajax file server로 upload후 경로를 받아서 사용
				uploadFile(file);		
			},
			onMediaDelete:function(file){
				console.log("Delete Media");
				console.log("DeleteFile => ", file)
				deletFile(file);
			}
		}
      });

	  function deletFile(file){
			console.log("SRC => ", file.attr("src"));
			$.post("./summerFileDelete", {fileName:file.attr("src")}, function(result){
				console.log("result => ", result)
			})	
	  }

	  //ajax upload 함수
	  function uploadFile(file){
		console.log("file", file);
		console.log("fileName => ", file[0].name);
		//<form>
		const formData = new FormData();
		//<input type="file"
		formData.append('files', file[0])

		$.ajax({
			type:"POST",
			url:"summerFile",
			data:formData,
			//header
			cache:false,
			processData:false,
			contentType:false,
			enctype:'multipart/form-data',
			success:function(img){
				console.log("Image => ", img)
				// img = '<img src="'+img+'">'
				// $("#contents").summernote('pasteHTML', img);
				$("#contents").summernote('insertImage', img, file[0].name);
			},
			error:function(){
				console.log('Image upload Fail')
			}


		});
	  }
	</script>

</body>
</html>