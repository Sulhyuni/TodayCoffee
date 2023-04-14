<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today:회원가입 성공</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(function(){
	$("#loginBtn").click(function(){
		location="/member/login.do";
	});
	
	$("#findPw").click(function(){
		location="/";
	});
	
});

</script>
</head>
<body>
<div class="container">
	<h1 style="font-size: xx-large;">회원가입 성공</h1>
	
	
	<button  id="loginBtn">로그인 하기</button>
	<button  id="findPw">메인으로 가기</button>
</div>
</body>
</html>