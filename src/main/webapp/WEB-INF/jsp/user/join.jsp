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
		<div id="main-page" class="square-border mt-4">
			<header class="d-flex align-items-center justify-content-center">
					<h1>riMinpage</h1>
			</header>
			<section class="d-flex justify-content-center">
				<div class="my-3 text-center">
					<div class="mb-3 d-flex justify-content-center align-items-bottom">
						<input type="text" class="form-control col-6" placeholder="ID" id="identifier">
						<button type="button" class="ml-3 btn btn-info" id="checkIdBtn">중복확인</button>
					</div>
					<div>
						<div class="text-danger small d-none mb-3" id="duplicateId">중복된 id 입니다.</div>
						<div class="text-info small d-none mb-3" id="availableId">사용 가능한 id 입니다.</div>
					</div>
					<center>
						<input type="password" class="form-control col-10 mb-3" placeholder="Password" id="password">
						<input type="password" class="form-control col-10 mb-3" placeholder="Password 확인" id="checkPwd">
						<input type="text" class="form-control col-10 mb-3" placeholder="UserName" id="name">
						<input type="text" class="form-control col-10 mb-3" placeholder="e-mail" id="email">
					</center>
					<button type="button" class="btn btn-info col-10" id="joinBtn">회원가입</button>
				</div>
			</section>
		</div>
		<div class="d-flex justify-content-center">
			<footer id="footer" class="square-border mt-3 d-flex justify-content-center align-items-center">
				<div>이미 계정이 있으신가요?&nbsp; </div>
				<a href="/user/login">로그인</a>
			</footer>
		</div>	
	</div>




	
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		
		// 중복된 아이디일때 회원가입 안되도록 막기 위해 변수 선언
		let checkDup;
		let checkIdBtn = 0;
		
		// 아이디를 수정했으면 아이디 중복확인을 다시 하도록 변수 초기화해줌
		$("#identifier").on("input",function(){
			checkIdBtn = 0;
			$("#duplicateId").addClass("d-none");
			$("#availableId").addClass("d-none");
		});
		
		
		$("#checkIdBtn").on("click",function(){

			let id = $("#identifier").val();
			
			if(id == ""){
				alert("Id를 입력하세요");
			}
			
			$.ajax({
				type:"get"
				, url:"/user/duplicate-id"
				, data:{"loginId" : id}
				, success:function(data){
					
					checkIdBtn = 1; // 아이디 중복 확인 버튼을 누른 경우 1로 바꿔서 버튼을 눌렀음을 확인
					if((id != "")){
						if(data.isDuplicateId){
							checkDup = data.isDuplicateId;
							$("#duplicateId").removeClass("d-none");
							$("#availableId").addClass("d-none");
						} else {
							checkDup = data.isDuplicateId;
							$("#duplicateId").addClass("d-none");
							$("#availableId").removeClass("d-none");
						}
					}
				}
				, error:function(){
					alert("중복 확인 에러");
				}
			});
		});
				
		$("#joinBtn").on("click",function(){
			
			let id = $("#identifier").val();
			let password = $("#password").val();
			let checkPwd = $("#checkPwd").val();
			let name = $("#name").val();
			let email = $("#email").val();
			
			if(id == ""){
				alert("아이디를 입력하세요.");
				return;
			}
			if(password == ""){
				alert("비밀번호를 입력하세요.");
				return;
			}
			if(password != checkPwd){
				alert("비밀번호를 확인하세요.");
				return;
			}
			if(name == ""){
				alert("이름을 입력하세요.");
				return;
			}
			if(email == ""){
				alert("이메일을 입력하세요.");
				return;
			}
			
			$.ajax({
				type:"post"
				, url:"/user/join"
				, data:{"loginId":id, "password":password, "name":name, "email":email}
				, success:function(data){
					if(checkIdBtn != 0){
					if(data.result == "success" && !(checkDup)){
						alert("회원가입 성공! 환영합니다~ 로그인 페이지로 이동합니다.");
						location.href = "/user/login"
					} else {
						alert("회원 가입 실패. 아이디를 확인하세요.");
					}
					} else {
						alert("id 중복을 확인하세요");
					}
				}
				, error:function(){
					alert("회원 가입 에러");
				}
			});
		});
	});


</script>



</body>
</html>