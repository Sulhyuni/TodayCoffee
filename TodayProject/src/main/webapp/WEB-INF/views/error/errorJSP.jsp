<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이 jsp는 예외를 처리하는 페이지라고 선언해 놓는 코드.
	 이렇게 선언 해 놓고 true값을 넣어 두면 exception 사용이 가능 하다.-->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Error</title>
</head>
<body>
<div class="container">
	<h1>JSP 오류</h1>
	<div class="alert alert-danger"><%= exception.getMessage() %></div>
	<p>다시 한 번 시도 하세요.</p>
</div>
</body>
</html>