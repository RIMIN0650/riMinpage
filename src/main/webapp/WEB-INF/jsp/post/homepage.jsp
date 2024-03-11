<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>riMin Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/mainStyle.css" type="text/css">
</head>
<body>
	
	<div id="wrap">
		<section class="contents d-flex">
			<nav class="main-menu">
				<div class="d-flex justify-content-center align-items-center logo bg-success">
					<h1>riMin</h1>
				</div>
				<div class="d-flex justify-content-center align-items-center menu-link">
				<ul class="nav flex-column flex-item menu-link">
					<center>
						<li class="nav-item"><button class="btn btn-success my-3">Home</button>
						<li class="nav-item"><button class="btn btn-success my-3">Message</button>
						<li class="nav-item"><button class="btn btn-success my-3">Search</button>
						<li class="nav-item"><button class="btn btn-success my-3">Like</button>
						<li class="nav-item"><button class="btn btn-success my-3">Add</button>
						<li class="nav-item"><button class="btn btn-success my-3">Setting</button>
					</center>
				</ul>
				</div>
			</nav>
			<article class="main-contents bg-secondary">
				<div class="logo-status d-flex justify-content-end align-items-center">
					<c:if test="${not empty userId }">
						<div class="mr-3">${loginId } 님 <a href="/user/logout"> 로그아웃</a></div>
					</c:if>
				</div>
				
				
				<div>
					<div class="post-container bg-success mb-3">
						<div class="show-id bg-info">작성자 아이디 칸</div>
						<div class="show-image bg-danger">사진 칸</div>
						<button type="button" class="btn text-white"><i class="bi bi-heart text-danger"></i></button>
						<button type="button" class="btn"><i class="bi bi-heart-fill text-danger"></i></button>
						<div class="show-reply bg-warning"><b>rimin</b> 2000년 3월 23일</div>
						<div class="d-flex justify-content-center align-items-center mt-3">
							<input type="text" class="form-control text-input col-10 mr-3"><button type="button" class="btn btn-info" id="postReplyBtn">게시</button>
						</div>
					</div>
				</div>
			</article>
		</section>
		<footer>
			<div>@riMinpage</div>
		</footer>
	
	</div>



	
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		$("#postReplyBtn").on("click",function(){
			alert("댓글 작성 버튼");
			
		
		});
		
		
		
	});
</script>

</body>
</html>