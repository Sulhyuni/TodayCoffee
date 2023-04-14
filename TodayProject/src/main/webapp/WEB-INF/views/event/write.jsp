<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<!-- 라이브러리 등록  : CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src = "/js/regEx.js"></script>
 
<script type="text/javascript">

	$(function() {
		
		//alert("jquery 동작 함.")
		//등록시 한번 더 묻기
		$("#writeBtn").click(function() {
			if(!confirm("등록 하시겠습니까?")) return false;
		});
		$("#writeForm").submit(function() {
			if(!checkData(reg_title, $("#title"), reg_title_error_msg, 1)) return false;
			if(!checkData(reg_content, $("#content"), reg_content_error_msg, 1)) return false;
				
		});
 	 
 		
		//취소(이전으로) 이벤트
		$("#cancelBtn").click(function() {
		//	alert("클릭함");
			history.back();
		});
		
		 // StartDate와 EndDate의 값을 가져옵니다.
		  var startDate = new Date($('#datepicker1').val());
		  var endDate = new Date($('#datepicker2').val());

		  // EndDate 입력값이 변경되면 StartDate와 EndDate를 다시 가져와서 검증합니다.
		  $('#datepicker2').on('change', function() {
		    startDate = new Date($('#datepicker1').val());
		    endDate = new Date($('#datepicker2').val());

		    // StartDate가 EndDate보다 이전인 경우 경고 메시지를 표시합니다.
		    if (startDate > endDate) {
		      alert('종료일은 시작일보다 이전일 수 없습니다.');
		      $('#datepicker2').val($('#datepicker1').val());
		    }
		  });

		  // StartDate 입력값이 변경되면 StartDate와 EndDate를 다시 가져와서 검증합니다.
		  $('#datepicker1').on('change', function() {
		    startDate = new Date($('#datepicker1').val());
		    endDate = new Date($('#datepicker2').val());

		    // StartDate가 EndDate보다 이전인 경우 경고 메시지를 표시합니다.
		    if (startDate > endDate) {
		      alert('종료일은 시작일보다 이전일 수 없습니다.');
		      $('#datepicker1').val($('#datepicker2').val());
		    }
		  });
		
	});
	

</script>

</head>
<body>
<div class="container">
	<div class="col-md-12" >
		<h2>New Event</h2>
		<hr>
	</div>
	
	<form action="write.do" method="post" id="writeForm">
		<input type="hidden" name = "page" value="${param.page }">	
		<input type="hidden" name = "perPageNum" value="${param.perPageNum }">
		<input type="hidden" name = "key" value="${param.key}">
		<input type="hidden" name = "word" value="${param.word }">	
		
		
		<div class="form-group">
			<label for="title">Title: </label>
			<input  class="form-control" name="title"  id="title"  required="required" value="[이벤트]">
		</div>
		<div class="form-group">
			<label for="content">Content: </label>
			<textarea  class="form-control" id="content" name="content" rows="10"  
			required="required"> 



*회사 사정에 따라 일정이 변경 될 수 있습니다.*</textarea>
		</div>
		<div class="form-group">
			<label for="startDate">StartDate: </label>
			<input class="form-control" name = "startDate" id ="datepicker1" type="date"  required="required"> 
		</div>
		<div class="form-group">
			<label for="endDate">EndDate: </label>
			<input class="form-control" name = "endDate" id ="datepicker2" type="date"  required="required"> 
		</div>

<!-- 등록, 새로입력, 취소(이전으로) 버튼 생성 -->
	<div>
		<button id="writeBtn">등록</button>
		<button type="reset">새로입력</button>
		<button type="button" id="cancelBtn">취소</button>
	</div>
	</form>
</div>
</body>
</html>