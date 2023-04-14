<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응모 현황</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".statusModifyBtn").click(function() {
			var winNo = $(this).closest(".dataRow").find(".no").text();
			$("#formWinNo").val(winNo);
			var winStatus = $(this).closest(".dataRow").find(".winStatus");
// 			alert("번호 : " + winNo);
// 			alert("상태 : " + winStatus);
			$(".formStatus").val([winStatus]);
			$("#statusModal").modal("show");
			return false;
		});
		
		$("#formStatusModifyBtn").click(function(){
// 			alert("formStatusModifyBtn 클릭함");
			$("#statusModifyForm").submit();
		});
	});
</script>

</head>
<body>
	<div class="container">
		<div class="col-md-12">
		<a href = "list.do?page=${param.page }&perPageNum=${param.perPageNum}"><button style="float: right; margin-bottom: 10px;">리스트</button></a>
			<h2>내 응모 List</h2>
		</div>
		<div class="col-md-12">
			<hr>
		</div>
		<!-- 관리자일 경우 모든 회원의 응모 리스트를 볼 수 있다. -->
		<!-- 로그인 회원 본인일 경우 - 응모한 이벤트 리스트  -->
<%-- 		<input type="hidden" id="orderNo" value="${vo.winNo }">			 --%>
<%-- 		<input type="hidden" id="orderStatus" value="${vo.win }">			 --%>
			
		<table class="table">
			<thead>
				<tr>
					<th>응모번호</th>
					<th>event 번호</th>
					<th>event 제목</th>
					<th>응모자</th>
					<th>당첨여부</th>
					<c:if test="${login !=null && login.gradeNo ==9}">
						<th>변경하기</th>
					</c:if>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list }" var="vo">
					<tr class="dataRow">
						<td class="no">${vo.winNo}</td>
						<td>${vo.eventNo}</td>
						<td>${vo.title}</td>
						<td>${vo.id}</td>
						<td class="winStatus">${vo.win}</td>
						<c:if test="${login !=null && login.gradeNo ==9}">
							<td><button class="btn btn-default statusModifyBtn" data-toggle="modal" data-target="#statusModal">변경하기</button></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<!-- 당첨여부 상태변경 모달 창 -->
	<div id="statusModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h4 class="modal-title">당첨 상태 변경</h4>
				</div>
				<div class="modal-body">
					<form action="applyUpdate.do" method="post" id="statusModifyForm">
<!-- 						<input type="hidden" id="changeWinNo" name="winNo" > -->
						<div class = "form-group">
							<input type = "hidden" name="winNo" id = "formWinNo" readonly="readonly" class="form-control">
						</div>
						<div>
							<label class="radio-inline">
	        					<input type="radio" name="winStatus" class="formStatus" value="당첨">당첨
	        				</label>
							<label class="radio-inline">
	        					<input type="radio" name="winStatus" class="formStatus" value="미당첨">미당첨
	        				</label>
						</div>
					</form>
				</div>
				<div class ="modal-footer">
					<button type="submit" class="btn btn-default" id="formStatusModifyBtn" >변경</button>
	       			<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>