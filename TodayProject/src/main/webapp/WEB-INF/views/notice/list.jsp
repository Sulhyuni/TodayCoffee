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
<title>공지사항 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	


<style type="text/css">
.dataRow:hover {
	background: #ececec;
	cursor: pointer;
}
 
</style>

<script type="text/javascript">
$(function() {
	//alert("jquery 동작 함.")
	//데이터 한 줄을 클릭하면  글보기로 이동시키자
	$(".dataRow").click(function() {
		//alert("한줄 클릭함");
		//클릭한 글(tr)의 글번호를 찾아서   글을 가져오자.
		let no = $(this).find(".no").text();
		//alert=("클릭 번호: "+no)
		location ="view.do?no=" + no + "&inc=1&page=${param.page}&perPageNum=${param.perPageNum}";
			});
	
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
		<h2>Notice</h2>
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


<table class = "table">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>시작일</th>
			<th>종료일</th>
			<th>등록일(수정일)</th>
			<th>조회수</th>
		</tr>
	</thead>
	
	<tbody>
	<!-- 데이터 있는 만큼 반목문 처리 c:forEach - 자바 -->
    <c:forEach items="${list}" var="vo">
      <tr class="dataRow">
        <td class="no">${vo.no}</td> 
        <td>${vo.title}</td>
        <td>${vo.startDate}</td>
        <td>${vo.endDate}</td>
        <td>${vo.updateDate}</td>
        <td>${vo.hit}</td>
      </tr>
    </c:forEach>
	</tbody>
</table>
<div class = "row">
	<c:if test="${login != null && login.gradeNo == 9 }">
		<a href = "write.do?perPageNum=${pageObject.perPageNum}" style=" margin-top: 10px;"><button style= "float: right;">공지등록</button></a>
	</c:if>
	<div class="col-md-12" style="text-align: center; padding-top: 0px; margin-top: 50px;" >
		<pageNav:pageNav listURI="list.do" pageObject="${pageObject }" />
	</div>
</div>
</div>
</body>
</html>