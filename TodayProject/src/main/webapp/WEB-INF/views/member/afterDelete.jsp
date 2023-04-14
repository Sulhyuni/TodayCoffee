<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today:회원탈퇴 성공</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(function(){
	
	$("#mainBtn").click(function(){
		location="/";
	});
	
});

</script>
</head>
<body>
<div class="container">
	<h1 style="font-size: xx-large;">회원탈퇴 성공</h1>
	<br/>
	<h2>
	그동안 Today Coffee를 이용해 주셔서 감사합니다.
	</h2>
	
	<button  id="mainBtn">메인으로 가기</button>
</div>
</body>
</html>