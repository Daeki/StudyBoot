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
	<h1>Detail Page</h1>
	<h3>Title : ${vo.title}</h3>
	
	<c:forEach items="${vo.qnaFiles}" var="fileVO">
		<img alt="" src="/file/qna/${fileVO.fileName}">
		<a href="/fileDown/qna?fileNum=${fileVO.fileNum}">${fileVO.oriName}</a>
	</c:forEach>

</body>
</html>