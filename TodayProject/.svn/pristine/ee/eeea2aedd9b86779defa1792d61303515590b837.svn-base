<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pay</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){

		var totalPrice = 0; // 1. totalPrice 변수를 초기값 0으로 설정
		$('td[id=orderPrice]').each(function() {
		  var orderPrice = parseInt($(this).text().replace(/\D/g,'')); // 문자열에서 숫자만 추출
		  totalPrice += orderPrice;
		  });
		  
		  $('#totalPrice').val(totalPrice); // 총 주문금액을 표시
		  $('#payPrice').val(totalPrice); // 총 주문금액 결제금액에 표시		  
		  
		  $("#payForm").submit(function(event){
			  event.preventDefault();
			  
			  var cartNos = [];
			 $("[id^=cartNo]").each(function(){
				 var cartNo = $(this).val();
				 if(!cartNos.includes(cartNo)){
					 cartNos.push(cartNo);
				 }
			 }); 
			 
			 var cartNosInput = $("<input>")
			 .attr("type", "hidden")
			 .attr("name", "cartNos")
			 .val(cartNos.join(","))
			 $("payForm").append(cartNosInput);
			 
			 this.submit();
		  });
	  

	 $('#usePoint').on('input', function() {
		  var usePoint = parseInt($(this).val());
		  var point = parseInt($('#point').val());
		  if (isNaN(usePoint)) usePoint = 0; // 값이 제대로 입력되지 않은 경우, 0으로 설정
		  if (usePoint > point) {
		    alert('사용가능한 포인트를 초과할 수 없습니다.');
		    usePoint = point;
		    $(this).val(usePoint);
		  }
		  if (usePoint > totalPrice) {
		    alert('사용할 포인트가 총 주문금액보다 큽니다.');
		    usePoint = totalPrice;
		    $(this).val(usePoint);
		    var payPrice = 0;
		    $('#payPrice').val(payPrice);   
		  } else {
		    var payPrice = totalPrice - usePoint;
		    $('#payPrice').val(payPrice);
		  }
		});
});

</script>
<style type="text/css">
input:focus {outline:none;}

fieldset.payInfo {
  border: 5px solid #c7bbad !important;
  padding: 1.4em 1.4em 0em 1.4em !important;
  margin: 0 0 1.5em 0 !important;
  margin-top: 30px !important;
}

legend.payInfo {
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
#usePoint {
  border-left: none;
  border-right: none;
  border-top: none;
}
label,input {
  font-size: 1.2em;
  font-weight: bold;
}
</style>
</head>
<body>
<div class="container">
	<form method="post" id="payForm">
	<fieldset class="payInfo">
	<legend class="payInfo">주문정보</legend>
		<!-- 장바구니, 나만의메뉴에서 가져올 때 -->
		<c:if test="${not empty list}">
			<div id="cartOrder">
				<table class="table">
				<thead>
					<tr>
						<th>상품이미지</th>
						<th>상품명</th>
						<th>분류</th>
						<th>옵션</th>
						<th>수량</th>
						<th>금액</th>
					</tr>					
				</thead>
					<tbody>
						<c:forEach items="${list }" var="vo">
							<tr>
								<td><img src="${vo.fileName }" class="img" alt="${vo.fileName }" width="50px;" height="50px;"></td>
								<td>${vo.goodsName }</td>
								<td>${vo.goodsDiv }</td>
								<c:if test="${vo.goodsDiv ne 'food' }">
									<td>${vo.cupSize } | ${vo.cup } | ${vo.syrup }</td>
								</c:if>
								<c:if test="${vo.goodsDiv eq 'food' }">
									<td>${vo.heating }</td>
								</c:if>
								<td>${vo.quantity }개</td>
								<td id="orderPrice">${vo.orderPrice }원</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>		
			</div>
		</c:if>
		
		<!-- 개별주문 -->
		<c:if test="${empty list}">
			<div id="EachOrder">
				<table class="table">
				<thead>
					<tr>
						<th>상품명</th>
						<th>분류</th>
						<th>옵션</th>
						<th>금액</th>
						<th>수량</th>
					</tr>					
				</thead>
					<tbody>
						<tr>
							<td><img src="${vo.fileName }" class="img" alt="${vo.fileName }" width="50px;" height="50px;"></td>
							<td>${vo.goodsName }</td>
							<td>${vo.goodsDiv }</td>
							<c:if test="${vo.goodsDiv ne 'food' }">
								<td>${vo.cupSize } | ${vo.cup } | ${vo.syrup }</td>
							</c:if>
							<c:if test="${vo.goodsDiv eq 'food' }">
								<td>${vo.heating }</td>
							</c:if>
							<td>${vo.quantity }개</td>
							<td id="orderPrice">${vo.orderPrice }원</td>
						</tr>
					</tbody>
				</table>		  	
			</div>
		</c:if>
		</fieldset>
			<fieldset class="payInfo">	
				<legend class="payInfo">결제정보</legend>
				
					<div class="form-group col-md-6 inline-left" style="width: auto">
					    <label for="totalPrice" style="width: 300px">총 주문금액</label>
					    <input id="totalPrice" name="totalPrice" value="" readonly style="border:none; text-align:right;">
				    </div>		    
			    	 	
				    <div class="form-group col-md-6 inline-left" style="width: auto">
						<label for="point" style="width: 300px">사용 가능한 포인트</label>
						<input id="point" name="point" value="${vo.point }" readonly style="border:none; text-align:right;">
					</div>
									
			    	<div class="form-group col-md-6 inline-right" style="width: auto">
				        <label for="usePoint" style="width: 300px">사용할 포인트</label>
				        <input id="usePoint" name="usePoint" value="" style="text-align:right;" placeholder="0">
			    	</div>
			    	
					<div class="form-group col-md-6 inline-right" style="width: auto">
				        <label for="payPrice" style="width: 300px">결제하실 금액</label>
				        <input id="payPrice" name="payPrice" value="" readonly style="border:none; text-align:right">
			    	</div>  
					<div class="form-group">
						<label for="payMethod">결제수단</label>
						<select class="form-control" id="payMethod" name="payMethod" style="width: 350px">
							<option selected="selected">신용카드</option>
						</select>
					</div>
		    			    	
			</fieldset>
				
			<input type="hidden" id="optionNo" name="optionNo" value="${vo.optionNo }">
			<input type="hidden" id="goodsNo" name="goodsNo" value="${vo.goodsNo }">
			<input type="hidden" id="quantity" name="quantity" value="${vo.quantity }">
			<input type="hidden" id="orderPrice" name="orderPrice" value="${vo.orderPrice }">
		<button type="submit" formaction="pay.do" style="float: right;">결제하기</button>
	
	</form>

</div>
</body>
</html>