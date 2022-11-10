<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">
<script defer src="/js/test.js"></script>

</head>
<body>
	<h1>Index page</h1>
	<h1><spring:message code="hi" var="h"></spring:message> </h1>
	<h1><spring:message code="test" text="code가 없을 때 출력 하는 메세지"></spring:message> </h1>
	
	<div>
		
		<!-- 로그인 성공 -->
		<sec:authorize access="isAuthenticated()">		
			<sec:authentication property="Principal" var="member"/>
			<h3><spring:message code="welcome" arguments="${member.name}"></spring:message> </h3>
			<h3><spring:message code="welcome2" arguments="${member.id}:${member.name}" argumentSeparator=":"></spring:message> </h3>
			<a href="./member/mypage">myPage</a>
			<a href="#" id="logout">Logout</a>
			<button type="button" id="kakao">Kakao Logout</button>
			<form id="outForm" action="./member/logout" method="post">
				<sec:csrfInput/>
				<button>Logout</button>
			</form>
			
			<a href="/member/delete">회원탈퇴</a>

		</sec:authorize>	
		
		<sec:authorize access="!isAuthenticated()">	
			<!-- 로그인 전 -->
			<a href="./member/login">login</a>
			<a href="/oauth2/authorization/kakao">Kakao Login</a>
			
			<a href="./member/add">Join</a>
		</sec:authorize>
		
		<sec:authorize url="/admin">
			<a href="/admin">GO Admin</a>
		</sec:authorize>
		
		<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
			<a href="/manager">Go Manager</a>
		</sec:authorize>
	</div>
	
	<img src="./images/winter.jpg" id="id1">
	<a href="./qna/list">QNA</a>
	<div>
		<img alt="" src="/file/qna/75aaf265-c34f-4ed6-a881-1d152e806b18_아이유.jpg">
		<img alt="" src="/file/notice/iu2.jpg">
		<a href="/fileDown/qna?fileNum=2">QnaDown</a>
		<a href="/fileDown/notice?fileNum=2">NoticeDown</a>
	</div>

	<button id="btn">CLICK</button>

	<button class="buttons">BTN1</button>
	<button class="buttons">BTN2</button>
	<button class="buttons">BTN3</button>

	<div id="test">


	</div>
	<h1>${h}</h1>
	<h1>${h}</h1>
	<h1>${h}</h1>
	<h1>${h}</h1>
	<script type="text/javascript">
		$("#logout").click(function() {
			$("#outForm").submit();
		})
		
		$("#kakao").click(function() {
			$.get("https://developers.kakao.com/logout", function () {
				location.reload();
			})
		});
	</script>
</body>
</html>