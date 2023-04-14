<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  jstl 코드 입력 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	.dataRow:hover{
		cursor: pointer;
		background: #ececec;
	}
</style>
	
	
<script type="text/javascript">
	$(function() {
		//alert("제이쿼리 동작됨");
		//클릭이벤트
		$(".dataRow").click(function() {
			//alert("클릭함");
			let no = $(this).find(".no").text();
			location = "view.do?no="+ no + "&inc=1&page=${param.page}&perPageNum=${param.perPageNum}";
		});
		//응모현황 보러가기 버튼
		$("#applyBtn").click(function() {
			if(${login != null}){
			location = "applyList.do";
			}else
				alert("로그인 후 이용 가능합니다");
			return false;
		})
	
		
		//key 세팅
		if("${param.key}") 
			$("#key").val("${param.key}");
		//perPageNum 세팅
		if("${param.perPageNum}") 
			$("#perPageNum").val("${param.perPageNum}");
		
		//한페이지에 보여 줄 데이터 수
		$("#perPageNum").change(function() {
			$("#changePerPageNumForm").submit();
			});
	});
	
</script>
	
</head>
<body>
<div class = "container">
	<div class="col-md-12" >
		<h2>Event</h2>
		<hr>
	</div>
<!-- 검색 -->
<div class ="row">
	<div class="col-md-9">
	<form class="form-inline">
		<input name="perPageNum" value="${param.perPageNum }" type="hidden">
		<div class="form-group">
			<select class="form-control" id="key" name="key">
				<option value="tc" selected="selected">전체</option>
				<option value="t">제목</option>
				<option value="c">내용</option>
			</select>
		</div>
		<div class = "form-group">
		<input type="text" class="form-control" placeholder="Search" 
				name="word" value="${param.word }">
		</div>
		<button type="submit">
			<i class="glyphicon glyphicon-search"></i>
		</button>
	</form>
	</div>
	<div class="col-md-3 text-right">
		<form class="form-inline" id="changePerPageNumForm">
			 <div class="form-group">
			 	<label>데이터 수</label>
			 	<select name="perPageNum" id="perPageNum" class="form-control">
			 		<option>5</option>
			 		<option selected="selected">10</option>
			 		<option>30</option>
			 	</select>
			 </div>
		</form>
	</div>
</div>	

<table class="table">
	<thead>
		<tr>
			<th>이벤트 번호</th>
			<th>제목</th>
			<th>시작일</th>
			<th>종료일</th>
			<th>등록일(수정일)</th>
			<th>조회수</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${list }" var="vo">
			<tr class="dataRow">
				<td class="no">${vo.eventNo}</td> 
		        <td>${vo.title}</td>
		        <td>${vo.startDate}</td>
		        <td>${vo.endDate}</td>
		        <td>${vo.updateDate}</td>
		        <td>${vo.hit}</td>
		      </tr>
		</c:forEach>
	</tbody>
</table>
<div class="row">
	<c:if test="${login != null && login.gradeNo == 9 }">
		<a href = "write.do?perPageNum=${pageObject.perPageNum}" style="margin-top: 15px;"><button style= "float: right;">새 이벤트 등록</button></a>
	</c:if>
		<a href = "applyList.do" style="margin-top: 15px;"><button style= "float: right;" id="applyBtn">내 응모현황 보러가기</button></a>
	<div class="col-md-12" style="text-align: center; margin-top: 10px;"  >
		<pageNav:pageNav listURI="list.do" pageObject="${pageObject }" />
	</div>
</div>
	
</div>
</body>
</html>