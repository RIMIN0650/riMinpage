<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>riMinpage LogIn</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	
	<div id="wrap">
		<div id="main-page" class="square-border mt-4">
			<header class="d-flex align-items-center justify-content-center">
				<h1>riMinpage</h1>
			</header>
			<div class="d-flex align-items-center">
			<section>
			<center>
				<input type="text" class="form-control col-10 mb-3" placeholder="ID">
				<input type="password" class="form-control col-10 mb-3" placeholder="Password">
				<button type="button" class="btn btn-success col-10 my-3">로그인</button>
			</center>
			<hr align="center" style="border: dashed 1px black; width: 50%;"><br><br>
				<div class="d-flex justify-content-center">
					<a href="#">비밀번호를 잊으셨나요?</a>
				</div>
			</section>
			</div>
		</div>
		<div class="d-flex justify-content-center">
			<footer id="footer" class="square-border mt-3 d-flex justify-content-center align-items-center">
				<div>계정이 없으신가요?&nbsp;</div>
				<a href="/user/join-view">회원가입</a>
			</footer>
		</div>
		
	</div>
	
	
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>


</body>
</html>