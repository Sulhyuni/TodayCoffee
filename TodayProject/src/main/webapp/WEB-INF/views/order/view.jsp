<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order View</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".statusModifyBtn").click(function(){
		var orderNo = $("#orderNo").val();
		$("#orderNo").val(orderNo);
		var orderStatus = $("#orderStatus").val();
		$(".formStatus").val([orderStatus]);
		$("#statusModal").modal("show");
		return false;
	});
	$("#formStatusModifyBtn").click(function(){
		$("#statusModifyForm").submit();
	});
});
</script>
<style type="text/css">
fieldset.orderInfo {
  border: 5px solid #c7bbad !important;
  padding: 1.4em 1.4em 0em 1.4em !important;
  margin: 0 0 1.5em 0 !important;
  margin-top: 30px !important;
}

legend.orderInfo {
  font-size: 1.8em !important;
  font-weight: bold !important;
  text-align: left !important;
  width: auto;
  padding: 0 10px;
  border-bottom: none;
  margin-top: -15px;
  background-color: white;
  color: #6b7770;
}
.content {
	padding: 10px 0;
	font-size: 1.3em !important;
	font-weight: bold !important;
}
</style>
</head>
<body>
	<!-- 보이는 화면 -->
	<div class="container">
		<fieldset class="orderInfo">
			<input type="hidden" id="orderNo" value="${vo.orderNo }">			
			<input type="hidden" id="orderStatus" value="${vo.orderStatus }">			
			<legend class="orderInfo">${vo.id }님의 주문 : ${vo.orderStatus }</legend>
			<table class="table">
				<thead>
					<tr>
						<th>No. ${vo.orderNo }</th>
						<th>상품명</th>
						<th>분류</th>
						<th>옵션</th>
						<th>금액</th>
						<th>수량</th>
					</tr>					
				</thead>
				<tbody>
					<c:forEach items="${view }" var="vo">
						<tr class="dataRow">
							<td><img src="${vo.fileName }" class="img"
									alt="${vo.fileName }" width="50px;" height="50px;"></td>
							<td>${vo.goodsName }</td>
							<td>${vo.goodsDiv }</td>
							<c:if test="${vo.goodsDiv ne 'food' }">
							<td>${vo.cupSize } | ${vo.cup } | ${vo.syrup } </td>
							</c:if>
							<c:if test="${vo.goodsDiv eq 'food' }">
							<td>${vo.heating }</td>
							</c:if>
							<td>${vo.orderPrice }</td>
							<td>${vo.quantity }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div style="text-align: right; width:96%">
				<div class="content" style="width:auto; display:inline-block;">총 주문금액  ${vo.totalPrice }원 |</div>
				<div class="content" style="width:auto; display:inline-block;">결제수단  ${vo.payMethod } |</div>
				<div class="content" style="width:auto; display:inline-block;">결제금액  ${vo.payPrice }원</div>
			</div>

		</fieldset>
		<c:if test="${vo.gradeNo eq '9' }">
			<button class="statusModifyBtn" data-toggle="modal" data-target="#statusModal">주문상태변경</button>
		</c:if>
		<button type="button" onclick="location='/order/list.do'" style="float: right;">돌아가기</button>
	</div>
	<!-- 보이는화면 끝 -->
	
	
	
	<!-- 상태변경 모달창 시작-->
	<div id="statusModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h4 class="modal-title">주문상태변경</h4>
				</div>
				<div class="modal-body">
					<form action="update.do" method="post" id="statusModifyForm">
						<input type="hidden" name="orderNo" value="${param.no }">
						<div>
							<label class="radio-inline">
	        					<input type="radio" name="orderStatus" class="formStatus" value="준비중">준비중
	        				</label>
							<label class="radio-inline">
	        					<input type="radio" name="orderStatus" class="formStatus" value="픽업대기">픽업대기
	        				</label>
							<label class="radio-inline">
	        					<input type="radio" name="orderStatus" class="formStatus" value="픽업완료">픽업완료
	        				</label>
							<label class="radio-inline">
	        					<input type="radio" name="orderStatus" class="formStatus" value="주문취소">주문취소
	        				</label>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default" id="formStatusModifyBtn">변경</button>
	       			<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 상태변경 모달창 끝 -->
	
	
</body>
</html>