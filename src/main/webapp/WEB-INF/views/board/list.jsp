<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>

	<div class="container-fluid">
	<div class="row justify-content-center">
	<div class="col-8">
	<h1>List Page</h1>
	
	<div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>NUM</th>
					<th>TILTE</th>
					<th>WRITER</th>
					<th>HIT</th>
					<th>DATE</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td><a href="detail?num=${vo.num}">${vo.title}</a></td>
					<td>${vo.writer}</td>
					<td>${vo.hit}</td>
					<td>${vo.regDate}</td>
				</tr>	
			</c:forEach>
			
			</tbody>
			
			
		</table>
	
	</div>
	
	<div>
		<a href="./add" class="btn btn-danger">WRITE</a>
	</div>
	</div>
	</div>
	</div>
	
	<script type="text/javascript">
		let result = '${param.result}';
		console.log("result  " , result)
		if(result != ""){
			if(result == '1'){
				alert('등록 성공');
			}else {
				alert('등록 실패');
			}
		}
	
	</script>
	
</body>
</html>