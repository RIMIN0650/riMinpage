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
				<form id="loginForm">
					<input type="text" class="form-control col-10 mb-3" placeholder="ID" id="identifier">
					<input type="password" class="form-control col-10 mb-3" placeholder="Password" id="password">
					<button type="submit" class="btn btn-success col-10 my-3" id="loginBtn">로그인</button>
				</form>
				</center>
				<hr align="center" style="border: dashed 1px black; width: 60%;"><br><br>
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
<script>
	$(document).ready(function(){
		
		$("#loginForm").on("submit", function(e){
			// submit 이벤트가 가진 페이지 이동 기능 취소
			// 이벤트가 가진 기본 기능을 취소한다
			e.preventDefault();
			
			let id = $("#identifier").val();
			let password = $("#password").val();
			
			if(id == ""){
				alert("아이디를 입력하세요");
				return;
			}
			
			if(password == ""){
				alert("비밀번호를 입력하세요");
				return;
			}
			
			$.ajax({
				type:"post"
				, url:"/user/login"
				, data:{"loginId":id, "password":password}
				, success:function(data){
					if(data.result == "success"){
						alert("환영합니다! " + id + "님");
						location.href = "/post/homepage";
					} else {
						alert("로그인 실패");
					}
				}
				, error:function(){
					alert("로그인 에러");
				}
			});
		});
	});

</script>





</body>
</html>