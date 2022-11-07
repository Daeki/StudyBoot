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
	<section class="container-fluid col-lg-4 mt-5 min-vh-100">
		<div class="row">
			<h1>로그인 page</h1>
			
			<div>
				<h3>${param.error}</h3>
				<h3>${param.message}</h3>
				<h3>${msg}</h3>
			</div>
			
			<form action="login" method="post" id="frm" >
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			  <div class="mb-3">
			    <label for="userName" class="form-label">Enter ID</label>
			    <input type="text" name="id" value="${cookie.userId.value}" class="form-control" id="userName" aria-describedby="emailHelp">
			    
			  </div>
			  <div class="mb-3">
			    <label for="password" class="form-label">Enter Password</label>
			    <input type="password" name="pw" value="admin1" class="form-control" id="password">
			  </div>
			  <div class="mb-3 form-check">
			    <input type="checkbox" name="rememberId" class="form-check-input" id="exampleCheck1">
			    <label class="form-check-label" for="exampleCheck1">ID기억하기</label>
			  </div>
			  
			  <div class="mb-3 form-check">
			    <input type="checkbox" name="rememberMe" class="form-check-input" id="exampleCheck2">
			    <label class="form-check-label" for="exampleCheck2">RememberMe</label>
			  </div>
			  
			  <button type="submit" class="btn btn-primary" id="btn">Submit</button>
			</form>
			
		
		</div>
	</section>
	<script type="text/javascript">
		//history.replaceState({}, null, location.pathname)
	</script>
</body>
</html>