<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 오류</title>
</head>
<body>
<div class="container">
	<h1>페이지 없음</h1>
	<!-- 요청한 페이지 uri를 보여줌 -->
	<div class="well">${uri }</div>
	<p>요청한 페이지가 없습니다. 다시 한 번 시도 해 주세요.</p>
</div>
</body>
</html>
<%
	// uri 한번 보여주고 새로고침하면 사라지게 하는 코드
	session.removeAttribute("uri");
%>