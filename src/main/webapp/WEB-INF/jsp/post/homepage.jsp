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
				<div class="d-flex justify-content-center align-items-center logo bg-dark">
					<h1 class="text-white"><i class="bi bi-moon-stars"></i></h1>
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
			<article class="main-contents">
				<div class="logo-status d-flex justify-content-between align-items-center">
					<c:if test="${not empty userId }">
						<h1 class="ml-3">riMinPage</h1>
						<div class="mr-3">${loginId } 님 <a href="/user/logout"> 로그아웃</a></div>
					</c:if>
				</div>
				
				
				<!-- 타임라인 layout -->
				<div class="timeline my-4">
				<c:forEach var="post" items="${postList }">
				<!-- card -->
					<div class="post-container bg-white mt-3 mb-3 card">
						<div>
							<div class="show-id d-flex justify-content-between align-items-end mx-1 mt-1">
								@${post.userLoginId }
								<i class="bi bi-three-dots-vertical"></i>
							</div>
						</div>
						<div class="show-image bg-danger mx-1 my-1">
							<img src="${post.imagePath }" class="w-100">
						</div>
						<div class="d-flex justify-content-top align-items-center">
							<button type="button" class="btn text-white like-icon" data-post-id="${post.postId }"><i class="bi bi-heart text-danger"></i></button>
							<!-- <button type="button" class="btn d-none" id="fullHeartBtn"><i class="bi bi-heart-fill text-danger"></i></button>  -->
							<div>14개</div>
						</div>
						<div class="show-reply bg-warning my-1 mx-1 p-2">
							<b>${post.userLoginId }</b> ${post.contents }
						</div>
						<hr>
						<!-- reply -->
						<div class="my-3 mx-1">
							<div>
								<div>댓글</div>
								<div><b>asdf</b> &nbsp; zxcijuzcviizcxv!</div>
								<div><b>asdf</b> &nbsp; zxcijuzcviizcxv!</div>
							</div>
							<div class="d-flex justify-content-center align-items-center">
								<input type="text" class="form-control text-input col-11 my-3 mr-1" id="reply${post.postId }">
								<button type="button" class="btn btn-info reply-btn" data-post-id="${post.postId }">게시</button>
							</div>
						</div>
						<!-- /reply -->
					</div>
					<!-- card -->
					</c:forEach>
				</div>
				<!-- /타임라인 layout -->
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
		
		$(".like-icon").on("click",function(){
			
			//이벤트가 발생한 태그 객체 > this
			let postId = $(this).data("post-id");
			
			$.ajax({
					type:"post"
					, url:"/post/like"
					, data:{"postId" : postId}
					, success:function(data){
						if(data.result == "success"){
							location.reload();
						} else {
							alert("좋아요 실패");
						}
					}
					, error:function(){
						alert("좋아요 에러");
					}
			});
		});
		
		
		$(".reply-btn").on("click",function(){
			
			
			let postId = $(this).data("post-id");
			
			// let commentId = "reply" + postId;
			// let reply = $('"#' + commentId + '"').val();
			
			
			// post-id 를 활용한 방법
			let content = $("#reply" + postId).val();
			
			
			// 클릭 이벤트가 발생한 버튼 태그 객체
			// 태그 위치 기반으로 태그 얻어올 수 있음
			// let content = $(this).prev().val();
			// 태그구성은 수시로 바껴서 안정적이지 않음
			
			
			
			
			
			// 버튼 태그 옆에 있는 태그
			
			$.ajax({
					type:"post"
					,url:"/post/comment/create"
					,data:{"postId": postId, "contents":content}
					,success:function(data){
						if(data.result == "success"){
							location.reload();
						} else {
							alert("댓글 실패");
						}
					}
					,error:function(){
						alert("댓글 에러");
					}
				
			});
			
			
		});
		
		
		
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