<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today:회원 리스트</title>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.dataRow:hover{
	background: #eee;
	cursor: pointer;
}
</style>

<script type="text/javascript">
$(function(){
	// key를 세팅해 보자.
	if("${param.key}") $("#key").val("${param.key}");
	// perPageNum를 세팅해 보자.
	if("${param.perPageNum}") $("#perPageNum").val("${param.perPageNum}");
	
	// 게시판 한줄을 클릭 이벤트
	$(".dataRow").click(function(){
		let id = $(this).find(".id").text();
		location = "view.do?id=" + id 
				+ "&page=${param.page}&perPageNum=${param.perPageNum}"
				+ "&key=${param.key}&word=${param.word}";
		
	});
	
	// 한페이지에 보여줄 데이터 개수 변경 이벤트
	$("#perPageNum").change(function(){
		$("#changePerPageNumForm").submit();
	});
	
		$(".gradeModifyBtn").click(function(){
//	 		alert("등급변경 버튼 클릭");
			// id 찾기와 셋팅
			var id = $(this).closest(".dataRow").find(".id").text();
			$("#formId").val(id);
			// 등급번호 찾기와 셋팅
			var gradeNo = $(this).closest(".dataRow").find(".gradeNo").text();
			$(".formGradeNo").val([gradeNo]);
			// 모달창 보여주기
			$("#myModal").modal("show");
			// 페이지 이동 막기
			return false;
		});
		
		// 등급수정 폼의 전달 버튼 이벤트
		$("#formGradeModifyBtn").click(function(){
			// 폼의 데이터 전송하기 -> 폼객체.submit()
			$("#gradeModifyForm").submit();
		});
		
		$(".statusModifyBtn").click(function(){
			// id 찾기와 셋팅
			var id = $(this).closest(".dataRow").find(".id").text();
			$("#statusId").val(id);
			// 상태 찾기와 셋팅
			var status = $(this).closest(".dataRow").find(".status").text();
			$(".formStatus").val([status]);
			//모달 보여주기
			$("#statusModal").modal("show");
			// 페이지 이동막기
			return false;
			
		});
		
		// 상태수정 폼의 전달 버튼 이벤트
		$("#formStatusModifyBtn").click(function(){
			// 폼의 데이터 전송하기 -> 폼객체.submit()
			$("#statusModifyForm").submit();
		});
		
	});


</script>

</head>
<body>
<div class="container">
<h1>회원 리스트</h1>
<div class="row">
	<div class="col-md-9">
		<form class="form-inline">
			<input name="perPageNum" value="${param.perPageNum }" type="hidden">
		  	<div class="form-group">
		  		<select class="form-control" id="key" name="key">
				    <option value="i">아이디</option>
				    <option value="n">이름</option>
				    <option value="b">생년월일</option>
				    <option value="t3">끝전화번호</option>
				    <option value="e">이메일</option>
				    <option value="s">상태</option>
				    <option value="inbt3es">전체</option>
				</select>
		  	</div>
			<div class="form-group">
			    <input type="text" class="form-control" placeholder="Search" 
			    name="word" value="${param.word }">
			</div>
		    <button class="btn btn-default" type="submit">
		        <i class="glyphicon glyphicon-search"></i>
		    </button>
		</form>
	</div>
	<div class="col-md-3 text-right"> 
		<form class="form-inline" id="changePerPageNumForm">
			<div class="form-group">
				<label>데이터 개수</label>
				<select name="perPageNum" id="perPageNum" class="form-control">
					<option>10</option>
					<option>15</option>
					<option>20</option>
				</select>
			</div>
		</form>
	</div>
</div>
<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>생년월일</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>상태</th>
			<th>등급이름</th>
			<th>포인트</th>
		</tr>
	</thead>
	<tbody>
		<!-- 데이터 있는 만큼 반복문 처리 -->
		<c:forEach items="${list }" var="vo">
			<tr class="dataRow">
				<td class="id" >${vo.id }</td>
				<td>${vo.name }</td>
				<td>${vo.gender }</td>
				<td>${vo.birth }</td>
				<td>${vo.tel1 }-${vo.tel2 }-${vo.tel3 }</td>
				<td>${vo.email }</td>
				<td ><span class="status">${vo.status }</span>
				<button class="statusModifyBtn" data-toggle="modal" data-target="#statusModal" style="width: 30px;font-size: small;height: 10px;">변경</button>
				</td>
				<td>${vo.gradeName }  <button class="gradeModifyBtn" data-toggle="modal" data-target="#myModal" style="width: 30px;font-size: small;height: 10px;">변경</button>
				</td>
				<td>${vo.point }</td>
				<td class="gradeNo" hidden="">${vo.gradeNo }</td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>
</div>
<div class="row">
	<div class="col-md-9 text-right" style="width: 1700px;" >
		<pageNav:pageNav listURI="list.do" pageObject="${pageObject }" />
	</div>
</div>
<!-- 상태 변경 Modal -->
<div id="statusModal" class="modal fade" role="dialog" >
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h4 class="modal-title">회원 상태 수정</h4>
      </div>
      <div class="modal-body">
        	<form action="changeStatus.do" method="post" id="statusModifyForm">
        	<input type="hidden" name="page" value="${param.page }">
			<input type="hidden" name="perPageNum" value="${param.perPageNum }">
			<input type="hidden" name="key" value="${param.key }">
			<input type="hidden" name="word" value="${param.word }">
        		<div class="form-group">
        			<label for="id">아이디</label>
        			<input name="id" id="statusId" readonly="readonly" class="form-control">
        		</div>
        		<div>
        			<div><label>상태</label></div>
        			<label class="radio-inline">
        				<input type="radio" name="status" class="formStatus" value="정상">정상</label>
        			<label class="radio-inline">
        				<input type="radio" name="status" class="formStatus" value="휴면">휴면</label>
        		</div>
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="formStatusModifyBtn">변경</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>
<!-- 등급 변경 Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h4 class="modal-title">등급 수정</h4>
      </div>
      <div class="modal-body">
        	<form action="changeGradeNo.do" method="post" id="gradeModifyForm">
        	<input type="hidden" name="page" value="${param.page }">
			<input type="hidden" name="perPageNum" value="${param.perPageNum }">
			<input type="hidden" name="key" value="${param.key }">
			<input type="hidden" name="word" value="${param.word }">
        		<div class="form-group">
        			<label for="id">아이디</label>
        			<input name="id" id="formId" readonly="readonly" class="form-control">
        		</div>
        		<div>
        			<div><label>등급</label></div>
        			<label class="radio-inline">
        				<input type="radio" name="gradeNo" value="1" class="formGradeNo">일반회원</label>
					<label class="radio-inline">
						<input type="radio" name="gradeNo" value="9" class="formGradeNo">관리자</label>
        		</div>
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="formGradeModifyBtn">변경</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
      </div>
    </div>
    </div>
    </div>
</body>
</html>