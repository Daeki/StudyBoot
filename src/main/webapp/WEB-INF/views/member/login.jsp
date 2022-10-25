<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 page</h1>
	<section class="container-fluid col-lg-4 mt-5 min-vh-100">
		<div class="row">
			<form action="./login" method="post" id="frm" >
			  <div class="mb-3">
			    <label for="userName" class="form-label">Enter ID</label>
			    <input type="text" name="id" class="form-control" id="userName" aria-describedby="emailHelp">
			    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
			  </div>
			  <div class="mb-3">
			    <label for="password" class="form-label">Enter Password</label>
			    <input type="password" name="pw" class="form-control" id="password">
			  </div>
			  <div class="mb-3 form-check">
			    <input type="checkbox" class="form-check-input" id="exampleCheck1">
			    <label class="form-check-label" for="exampleCheck1">Check me out</label>
			  </div>
			  <button type="submit" class="btn btn-primary" id="btn">Submit</button>
			</form>
			
		
		</div>
	</section>
</body>
</html>