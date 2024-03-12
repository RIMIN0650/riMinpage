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
						<li class="nav-item"><button class="btn btn-success my-3" id="homeBtn">Home</button>
						<li class="nav-item"><button class="btn btn-success my-3" id="msgBtn">Message</button>
						<li class="nav-item"><button class="btn btn-success my-3" id="searchBtn">Search</button>
						<li class="nav-item"><button class="btn btn-success my-3" id="likeBtn">Like</button>
						<li class="nav-item"><button class="btn btn-success my-3" id="addBtn">Add</button>
						<li class="nav-item"><button class="btn btn-success my-3" id="settingBtn">Setting</button>
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
					<div class="post-container bg-white mt-3 mb-3">
						<div class="show-id bg-info d-flex align-items-end mx-1 mt-1">@${loginId }</div>
						<div class="show-image bg-danger mx-1 my-1">사진 칸</div>
						<div class="show-content bg-primary mx-1 my-1">게시글 칸</div>
						<div class="d-flex justify-content-top align-items-center">
							<button type="button" class="btn text-white" id="emptyHeartBtn"><i class="bi bi-heart text-danger"></i></button>
							<button type="button" class="btn d-none" id="fullHeartBtn"><i class="bi bi-heart-fill text-danger"></i></button>
							<div>14개</div>
						</div>
						<div class="show-reply bg-warning my-1 mx-1">
							<b>${loginId }</b> 2000년 3월 23일
						</div>
						<div class="d-flex justify-content-center align-items-center my-3">
							<input type="text" class="form-control text-input col-11 my-3 mr-1" id="reply-content">
							<button type="button" class="btn btn-info" id="postReplyBtn">게시</button>
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
			let reply = $("#reply-content").val();
			alert(reply);
		});
		$("#emptyHeartBtn").on("click",function(){
			alert("좋아요");
			$("#emptyHeartBtn").addClass("d-none");
			$("#fullHeartBtn").removeClass("d-none");
		});
		$("#fullHeartBtn").on("click",function(){
			alert("좋아요 취소");
			$("#emptyHeartBtn").removeClass("d-none");
			$("#fullHeartBtn").addClass("d-none");
		});
		
		$("#homeBtn").on("click",function(){
			alert("homeBtn");
		});
		$("#msgBtn").on("click",function(){
			alert("msgBtn");
		});
		$("#searchBtn").on("click",function(){
			alert("searchBtn");
		});
		$("#likeBtn").on("click",function(){
			alert("likeBtn");
		});
		$("#addBtn").on("click",function(){
			location.href = "/post/uploadpost";
		});
		$("#settingBtn").on("click",function(){
			alert("settingBtn");
		});
		
		
	});
</script>

</body>
</html>