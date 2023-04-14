<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글보기</title>

<!-- 라이브러리 등록 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <script type="text/javascript">
 $(function() {
	$("#deleteBtn").click(function() {
		//alert("클릭함");
		if(!confirm("삭제 하시겠습니까?")) return false;
	});
})
 </script>
 
 <style type="text/css">
	
	#endDate{
		background-color: #ececec;
	}
	
	th{
		width: 20%;
	}
	#content1, #content2{
 		height: 250px; 
		line-height: 3em;
	}
</style>
 

</head>
<body>
<div class="container">
	<!-- get방식 -->
	<div class="col-md-12">
		<c:if test="${login !=null && login.gradeNo ==9 }">
			<a href = "update.do?no=${vo.no}&page=${param.page }&perPageNum=${param.perPageNum}">
				<button style="float: right;" id="updateBtn">수정</button>
			</a>
			<a href="delete.do?no=${vo.no}&page=${param.page }&perPageNum=${param.perPageNum}">
				<button style="float: right; margin-bottom: 10px;" id = "deleteBtn">삭제</button>
			</a>
		</c:if>
	<a href = "list.do?page=${param.page }&perPageNum=${param.perPageNum}"><button style="float: right;">리스트</button></a>
	<h2>Notice</h2>
	</div>
	
	
	<table class = "table">
		<tbody >
			<tr>
				<th>번호</th>
				<td>${vo.no }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${vo.title }</td>
			</tr>
			<tr>
				<th id = "content1">내용</th>
				<td id = "content2">${vo.content }</td>
			</tr>
			<tr>
				<th>시작일</th>
				<td>${vo.startDate}</td>
			</tr>
			<tr id="endDate">
				<th>종료일</th>
				<td>${vo.endDate}</td>
			</tr>
			<tr>
				<th>등록일(수정일)</th>
				<td>${vo.updateDate }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${vo.hit}</td>
			</tr>
		</tbody>
	</table>
	
	
</div>

</body>
</html>