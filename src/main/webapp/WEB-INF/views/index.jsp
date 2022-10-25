<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">

</head>
<body>
	<h1>Index page</h1>
	
	<div>
		<c:choose>
			<c:when test="${not empty member}">
				<a href="./member/logout">logout</a>
			</c:when>
			<c:otherwise>
				<a href="./member/login">login</a>
				<a href="./member/add">Join</a>
			</c:otherwise>
			
		</c:choose>
	</div>
	
	<img src="./images/winter.jpg" id="id1">
	<a href="./qna/list">QNA</a>
	<div>
		<img alt="" src="/file/qna/75aaf265-c34f-4ed6-a881-1d152e806b18_아이유.jpg">
		<img alt="" src="/file/notice/iu2.jpg">
		<a href="/fileDown/qna?fileNum=2">QnaDown</a>
		<a href="/fileDown/notice?fileNum=2">NoticeDown</a>
	</div>


</body>
</html>