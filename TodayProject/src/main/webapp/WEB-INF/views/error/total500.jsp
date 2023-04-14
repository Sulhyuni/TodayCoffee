<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버 실행 오류</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>서버 실행 오류</h1>
	<div class="alert alert-danger">
	※ 서버 내부 오류<br/>
	※ ${exception.message }
	</div>
	<p>다시 한 번 시도 하세요.</p>
	<div class="well">
		<a href="/"><button>메인으로 이동</button></a>
	</div>
</div>
</body>
</html>