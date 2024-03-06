<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>riMinpage Join</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	
	<div id="wrap">
		<header class="d-flex align-items-center justify-content-center">
				<h1>riMinpage</h1>
		</header>
		<section class="d-flex justify-content-center">
			<div class="my-3">
				<div class="d-flex mb-3">
					<input type="text" class="form-control col-6" placeholder="ID" id="identifier">
					<button type="button" class="ml-3 btn btn-info" id="checkIdBtn">중복확인</button>
				</div>
				<input type="text" class="form-control col-10 mb-3" placeholder="Password" id="password">
				<input type="text" class="form-control col-10 mb-3" placeholder="Password 확인" id="checkPwd">
				<input type="text" class="form-control col-10 mb-3" placeholder="UserName" id="name">
				<input type="text" class="form-control col-10 mb-3" placeholder="e-mail" id="email">
				<button type="button" class="btn btn-info col-10" id="joinBtn">회원가입</button>
			</div>
		</section>
		<footer>
		
		</footer>
		
	
	</div>




	
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		
		let id = $("#identifier").val();
		password
		checkPwd
		name
		email
		
		
		$("#joinBtn").on("click",function(){
			alert("회원가입 버튼 정상 작동");
		});
		$("#checkIdBtn").on("click",function(){
			alert("중복 버튼 정상 작동")
		});
		
		
	});


</script>



</body>
</html>