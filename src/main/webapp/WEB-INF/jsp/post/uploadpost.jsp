<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/mainStyle.css" type="text/css">
</head>
<body>

	<div class="post-box">
		<div class="d-flex justify-content-between align-items-center mt-3">
			<button type="button" class="btn btn-danger my-3 mx-3"><a href="/post/homepage" class="text-white">cancel</a></button>
			<button type="button" class="btn btn-success my-3 mx-3" id="uploadBtn">upload</button>
		</div>
		<div class="post-content">
		<div>
			
		</div>
			
			<div class="border rounded">
			<textarea rows="10" class="form-control border-0" id="contentsInput" placeholder="내용을 입력해주세요."></textarea>
			
			<div class="mt-3 ml-1">
			
			<label class="input-file-button" for="fileInput"><i class="bi bi-camera"></i></label>
				<input type="file" id="fileInput" class="d-none">
			</div>
			</div>
		</div>
		
	</div>




<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		
		$("#uploadBtn").on("click", function(){
			
			let contents = $("#contentsInput").val();
			let file = $("#fileInput")[0].files[0];
			
			// $("#fileInput").click(); // 클릭한 것 과 같은 기능
			
			if(contents == ""){
				alert("내용을 입력해주세요");
				return;
			}
			
			if(file == null){
				console.log(file);
				alert("파일을 선택해주세요");
				return;
			}
			
			let formData = new FormData();
			formData.append("contents", contents);
			formData.append("imageFile", file);
			
			$.ajax({
				type:"post"
				, url:"/post/create"
				, data:formData
				, enctype:"multipart/form-data" // 파일 업로드 필수 옵션
				, processData:false // 파일 업로드 필수 옵션
				, contentType:false // 파일 업로드 필수 옵션
				, success:function(data){
					if(data.result == "success"){
						location.href = "/post/homepage";
					} else {
						alert("글쓰기 실패");
					}
				}
				, error:function(){
					alert("글쓰기 에러");
				}
			})
			
			
			
			
		});
		
		
		
		
	});

</script>


</body>
</html>