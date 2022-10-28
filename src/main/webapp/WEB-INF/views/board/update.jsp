<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
		<form action="update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${vo.num}">
			<div class="mb-3">
			  <label for="title" class="form-label">Title</label>
			  	<input type="text" value="${vo.title}" name="title" class="form-control" id="title" placeholder="제목">
			</div>
			<div class="mb-3">
			  <label for="writer" class="form-label">Writer</label>
			  	<input type="text" value="${vo.writer}" name="writer" class="form-control" id="writer" placeholder="작성자">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" name="contents" id="contents"></textarea>
			</div>
			
			<div class="mb-3" id="fileAddResult" data-file-size="${vo.qnaFiles.size()}">
				<c:forEach items="${vo.qnaFiles}" var="fileVO">
					<p>
						${fileVO.oriName}
						<button type="button" class="deleteFile" data-file-num="${fileVO.fileNum}">X</button>
					</p>
				</c:forEach>
				
			</div>
			<div class="mb-3">
				<button type="button" id="fileAdd">FileAdd</button>
			</div>

			
			<div>
				<button class="btn btn-danger">Update</button>
			</div>
		</form>
		</div>
	</div>
	</div>
	
	<script type="text/javascript">
    $('#contents').summernote({
        tabsize: 4,
        height: 250
      });
    
    $('#contents').summernote('code', '${vo.contents}')
    
    
	</script>

</body>
</html>