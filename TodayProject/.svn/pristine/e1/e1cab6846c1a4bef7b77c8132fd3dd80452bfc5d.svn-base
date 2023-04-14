<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 수정</title>

<!--라이브러리 등록-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <script type="text/javascript">
$(function(){
	// 수량 변경 처리
	$("updateForm").submit(function(){
	if(!checkDate(reg_quantity,$("#quantity"),reg_quantity_error_msg,1))return false;
	});
	
	if("#cancelBtn").click(function(){
		history.back();
	});
});
 </script>
</head>
<body>
<div class="container">
	<div class="col-md-12">
		<h2>장바구니 수량 수정</h2>
			
	</div>
	<div class="col-md-12">
	</div>
	<form action="update.do"method="post"id="updateForm">
		<input type="hidden" name="no"value="${vo.cartNo }">
		<div class="form-group">
			<label for="name_kr">상품명</label>
			<input name="name_kr"id="name_kr" class="form-control"value="${vo.name_kr }"readonly="readonly">
			<label for="goodsDiv">분류</label>
			<input name="goodsDiv"id="goodsDiv" class="form-control"value="${vo.goodsDiv }"readonly="readonly">
			<label for="cup_size">사이즈</label>
			<input name="cup_size"id="cup_size" class="form-control"value="${vo.cup_size }"readonly="readonly">
			<label for="cup">컵</label>
			<input name="cup"id="cup" class="form-control"value="${vo.cup }"readonly="readonly">
			<label for="syrup">시럽</label>
			<input name="syrup"id="name_kr" class="form-control"value="${vo.syrup }"readonly="readonly">
		</div>
		<div class="form-group">
			<label for="quantity">수량</label>
			<input name="quantity"id="quantity" class="form-control"value="${vo.quantity }">
		</div>
		<div>
		<button type="button"id="cancelBtn"class="btn btn-default pull-right">X</button>
			<button >수정</button>
		</div>
	</form>
</div>
</body>
</html>