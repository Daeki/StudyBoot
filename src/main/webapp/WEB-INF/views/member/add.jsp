<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 page</h1>
	<div class="row justify-content-center mt-5">
    		<div class="col-lg-6">
        	<form action="./add" id="joinForm" method="post">
			  <div class="row mb-3">
			    <label for="inputUserName" class="col-sm-2 col-form-label">ID</label>
			    <div class="col-sm-10">
			      <input type="text" name="id" class="form-control" id="inputUserName" placeholder="ID 입력">
				  <div id="inputUserNameResult" ></div>
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			    <div class="col-sm-10">
			      <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password 입력">
				  <div id="inputPasswordResult"></div>
			    </div>
			  </div>

			  <div class="row mb-3">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			    <div class="col-sm-10">
			      <input type="password" name="pw" class="form-control" id="inputPasswordCheck" placeholder="Password 입력">
				  <div id="inputPasswordCheckResult"></div>
			    </div>
			  </div>

			  <div class="row mb-3">
			    <label for="inputName" class="col-sm-2 col-form-label">Name</label>
			    <div class="col-sm-10">
			      <input type="text" name="name" class="form-control" id="inputName" placeholder="이름 입력">
				  <div></div>
			    </div>
			  </div>
			  
			  <div class="row mb-3">
			    <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
			    <div class="col-sm-10">
			      <input type="email" required name="email" class="form-control" id="inputEmail" placeholder="Email 입력">
				  <div></div>
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputPhone" class="col-sm-2 col-form-label">Phone</label>
			    <div class="col-sm-10">
			      <input type="text" name="phone" class="form-control" id="inputPhone" placeholder="전화번호 입력">
				  <div></div>
			    </div>
			  </div>
			  
			  <div class="row mb-3">
			    <label for="files" class="col-sm-2 col-form-label">Photo</label>
			    <div class="col-sm-10">
			      <input type="file" name="photo" class="form-control" id="files" placeholder="전화번호 입력">
			    </div>
			  </div>
			  
			  
			  <div class="row justify-content-end">
			  	<div >
			  		<button type="submit" id="joinButton" class="btn btn-primary mb-3">Sign in</button>
			  	</div>
			  </div>
			</form>
        	</div>
        
        </div>

</body>
</html>