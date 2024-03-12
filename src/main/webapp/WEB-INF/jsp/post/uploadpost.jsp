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
			<button type="button" class="btn btn-success my-3 mx-3">upload</button>
		</div>
		<div class="post-content">
		<div>
			<h3>게시글 내용 입력</h3>
		</div>
			<input type="text" class="form-control text-input" style="height:550px;">
			<div class="mt-3 ml-1">
			<label class="input-file-button" for="input-file"><i class="bi bi-camera"></i></label>
				<input type="file" id="input-file" class="d-none">
			</div>
		</div>
		
	</div>




<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

</body>
</html>