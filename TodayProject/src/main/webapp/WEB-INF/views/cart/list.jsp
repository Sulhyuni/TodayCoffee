<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
<!-- 라이브러리 등록  : CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {

		// 선택 삭제로 바꾸기
		$(".deleteBtn").click(function() {
			var cartNo = $(this).closest("tr").find(".cartNo").text();
			// 		alert(cartNo);
			if (!confirm("이 상품을 장바구니에서 비우시겠습니까?"))
				return false;
		}); // end of deleteBtn
		// 전체 삭제 이벤트
		$("#delallBtn").click(function() {
			if (!confirm("주의 ※ 정말 모든 상품을 장바구니에서 비우시겠습니까?"))
				return false;
		}); // end of delallBtn
		
		// view로 이동해서 수량 처리
		$("#viewBtn").click(function(){
			let cartNo = $(this).data("no");
			location = "view.do?no="+cartNo;
		});

		//check박스 전체 선택 이벤트
		$('#selectAll').click(function() {
			$('.itemCheckbox').prop('checked', $(this).prop('checked'));
		}); // end of selectAll

		// -------------------------- 주문하기로 가는 jQuery 부분
		$("#orderBtn").click(
				function() {
					var cartNos = [];
					$(".itemCheckbox:checked").each(function() {
						cartNos.push($(this).val());
					});
					if (cartNos.length > 0) {
						var queryString = "cartNos="
								+ encodeURIComponent(cartNos.join(","));
						window.location.href = "/order/pay.do?" + queryString;
					} else {
						alert("주문할 상품을 선택해주세요.");
					}
				});

	}); // end of $(function(){
</script>
<style type="text/css">
.itemCheckbox:hover{
	cursor: pointer;
}
#selectAll:hover{
	cursor: pointer;
}
.btn{
background:#c7bbad;
	color:white;
	font-size:15px;
}
.btn:hover {
	background:#ac9a86;
	color:white;
}
</style>

</head>
<body>
	<div class="container">
		<div class="col-md-12">
			<a href="alldelete.do">
				<button type="button" style="float: right; margin-bottom: 10px;"
					id="delallBtn">전체삭제</button>
			</a>
			<button type="button" style="float: right; margin-bottom: 10px;"
				id="orderBtn" onclick="order()">주문하기</button>
			<h2>장바구니</h2><br/>
			<p style="text-align:center;margin-bottom:30px;">※ 수량 변경을 원하시면 수정 버튼을 클릭해주세요 ※</p>
			<form id="myForm" method="post" id="Form">
				<table class="table">
					<thead>
						<tr>
							<td><input type="checkbox" id="selectAll"></td>
							<td>번호</td>
							<td>이미지</td>
							<td>상품명</td>
							<td>분류</td>
							<td>옵션</td>
							<td>수량</td>
							<td>가격</td>
							<td>수정&nbsp;/&nbsp;삭제</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="vo">
							<tr class="dataRow" data-no="${vo.cartNo }">
								<td><input type="checkbox" class="itemCheckbox"
									value="${vo.cartNo}"></td>
								<td class="cartNo">${vo.cartNo }</td>
								<td><img src="${vo.fileName }" class="img"
									alt="${vo.fileName }" width="50px;" height="50px;"></td>
								<td>${vo.name_kr }</td>
								<td>${vo.goodsDiv }</td>
								<c:if test="${vo.goodsDiv ne 'food' }">
									<td>${vo.cup_size }|${vo.cup }|${vo.syrup }</td>
								</c:if>
								<c:if test="${vo.goodsDiv eq 'food' }">
									<td>${vo.heating }</td>
								</c:if>
								<td>${vo.quantity }</td>
								<td>${vo.totalPrice }</td>
								<td>
								 <a href="view.do?no=${vo.cartNo}">
										<button type="button" id="viewBtn"
											class="viewBtn btn btn-default">수정</button>
								</a>
								 <a href="delete.do?no=${vo.cartNo}">
										<button type="button" id="deleteBtn"
											class="deleteBtn btn btn-default">삭제</button>
								</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>