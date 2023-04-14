<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 상세</title>
<!-- 라이브러리 등록  : CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){ 
// 	$("#deleteBtn").click(function(){
// 		if(!confirm("이 상품을 장바구니에서 비우시겠습니까?"))return false;
// 	});// end of deleteBtn

	let price = ${vo.totalPrice / vo.quantity };
	
	let quantity = ${vo.quantity};
	let quantityElement = $("#quantity");
	$("#increaseBtn").click(function(){
		quantity++;
		quantityElement.val(quantity);
		calculateTotalPrice();
	});
	
	$("#decreaseBtn").click(function(){
	  if (quantity > 1) {
		  quantity--;
		  quantityElement.val(quantity);
	    calculateTotalPrice();
	  }
	});
	  function calculateTotalPrice() {
		  let totalPrice = price * quantity;
		  $("#totalPrice").val(totalPrice);
		}
}); 
</script> 
<style type="text/css">
/* #btn{ */
/* 	margin-top:5px;	 */
/* 	position:absolute; */
/* 	right:500px; */
	
/* } */
.btn{
background:#c7bbad;
	color:white;
	font-size:15px;
}
.btn:hover {
	background:#ac9a86;
	color:white;
}
#totalPrice{
	width:60px;
}
#quantity{
	width:30px;
	height:32px;
}
#aa{
	position:absolute;
	right:300px;
	top:200px;
}
#bb{
	position:absolute;
	right:250px;
	top:310px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="col-md-12">
			<a href="list.do">
				<button style="float: right; margin-bottom: 10px;">장바구니</button>
			</a>
			<h2>상세옵션</h2>
		</div>
		<div class="col-md-12">
			<hr>
		</div>
		<div class="row">
			<div class="col-md-4">
				<img src="${vo.fileName }" class="img-thubnail" />
			</div>
			<div class="col-md-8">상품명:&nbsp; ${vo.name_kr }
				<div style="margin-top: 20px;">
					<hr>
					<div class="row">
						<div class="col-md-8"
							style="margin-bottom: 30px; margin-top: -20px;margin-bottom:10px;">상품 설명
							:&nbsp;${vo.goodsview }</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10"style="margin-bottom:-30px;">분류 : &nbsp;${vo.goodsDiv }</div>
				<c:if test="${vo.goodsDiv ne 'food' }">
			<div class="col-md-10"style="margin-bottom:-30px;">사이즈 :&nbsp; ${vo.cup_size }</div>
			<div class="col-md-10"style="margin-bottom:-30px;">컵 : &nbsp;${vo.cup }</div>
			<div class="col-md-10"id="syrup"style="margin-bottom:-30px;">시럽 : &nbsp;${vo.syrup }</div>
			</c:if>
			<c:if test="${vo.goodsDiv eq 'food' }">
			<div class="col-md-10"id="heating"style="margin-bottom:-20px;">${vo.heating }</div>
			</c:if>
			</div>	
			<form method="post"id="updateForm">
			<input type="hidden" name="goodsNo" value="${vo.goodsNo }">
				<div id="aa" class="form-group">
			<label for="quantity"style="margin-top:20px;">수량</label><br/>
			<button type="button" id="increaseBtn"class="btn btn-default">+</button>
			<input id="quantity" name="quantity" readonly="readonly" value="${vo.quantity }"></input>
			<button type="button" id="decreaseBtn"class="btn btn-default">-</button>
		</div>
			<div id="bb">
			<label for="totalPrice">가격</label>
			<input id="totalPrice" name="totalPrice" value="${vo.totalPrice  }">원
			<button id="btn"type="submit"formaction="/cart/update.do?no=${vo.cartNo }"class="btn btn-default">수정</button>
		</div>
		</form>	
			</div>
		</div>
	</div>
</body>
</html>