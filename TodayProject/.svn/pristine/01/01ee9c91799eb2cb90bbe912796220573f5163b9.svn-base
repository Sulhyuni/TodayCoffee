<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Option</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	let price = ${vo.price};
	let cup_size = "S";
	let syrup = "시럽없음";

	$("input[type='radio'][name='cup_size']").on("change", function(){
		cup_size = $(this).val();
		switch (cup_size) {
			case "S":
				if(syrup === "시럽없음") price = ${vo.price};
				else price = ${vo.price} + 600;
				break;
			case "M":
				if(syrup === "시럽없음") price = ${vo.price}  + 500;
				else price = ${vo.price} + 500 + 600;
				break;
			case "L":
				if(syrup === "시럽없음") price = ${vo.price}  + 1000;
				else price = ${vo.price} + 1000 + 600;
				break;
		}
		calculateTotalPrice();
	});

	$("input[type='radio'][name='syrup']").on("change", function(){
		syrup = $(this).val();
		switch(syrup) {
        case "시럽추가":
            price += 600;
            break;
        case "시럽없음":
            price -= 600;
            break;
        default:
            break;
		}
		calculateTotalPrice();
	});

	let quantity = 1;
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
		let orderPrice = price * quantity;
		$("#orderPrice").val(orderPrice);
	}
});

</script>
<style type="text/css">
fieldset.opInfo {
  border: 5px solid #c7bbad !important;
  padding: 1.4em 1.4em 0em 1.4em !important;
  margin: 0 0 1.5em 0 !important;
  margin-top: 30px !important;
}

legend.opInfo {
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
label.title {
  font-size: 1.2em !important;
  font-weight: bold !important;
}
input:focus {
	outline:none;
}
input#orderPrice{
  font-size: 1.5em !important;
  font-weight: bold !important;
}
</style>
</head>
<body>
<div class="container">
	<!-- vo.으로 가져올 수 있는 것 : goodsNo, name_kr, goodDiv -->
	<h2 style="text-align: center;">${vo.name_kr}</h2>
	<form method="post" id="addOptionForm">
	<fieldset class="opInfo">
	<legend class="opInfo">옵션선택</legend>
	<input type="hidden" id="goodsNo" name="goodsNo" value="${vo.goodsNo }">
	<input type="hidden" id="name_kr" name="name_kr" value="${vo.name_kr }">
	<input type="hidden" id="goodsDiv" name="goodsDiv" value="${vo.goodsDiv }">
		<c:if test="${vo.goodsDiv ne 'food'}">
		<div class="form-group">
			<div class="form-group col-md-3">
				<label class="title" for="cup_size">사이즈</label><br>
				<input type="radio" id="cup_size_S" name="cup_size" value="S" checked>
				<label for="cup_size_S">S</label>
				<input type="radio" id="cup_size_M" name="cup_size" value="M">
				<label for="cup_size_M">M</label>
				<input type="radio" id="cup_size_L" name="cup_size" value="L">
				<label for="cup_size_L">L</label>
			</div>
			<div class="form-group col-md-3">
				<label class="title" for="cup">컵종류</label><br>
				<input type="radio" id="cup_store" name="cup" value="매장컵" checked>
				<label for="cup_store">매장컵</label>
				<input type="radio" id="cup_personal" name="cup" value="개인컵">
				<label for="cup_personal">개인컵</label>
				<input type="radio" id="cup_disposable" name="cup" value="일회용">
				<label for="cup_disposable">일회용</label>
			</div>
			<div class="form-group col-md-3" style="display: inline-block;">
				<label class="title" for="syrup">시럽</label><br>
				<input type="radio" id="syrup_none" name="syrup" value="시럽없음" checked>
				<label for="syrup_none">시럽없음</label>
				<input type="radio" id="syrup_add" name="syrup" value="시럽추가">
				<label for="syrup_add">시럽추가</label>
			</div>
		</div>
		</c:if>
		<c:if test="${vo.goodsDiv eq 'food'}">
			<div class="form-group col-md-12">
				<label class="title" for="heating">워밍 옵션</label><br>
				<input type="radio" id="heating_none" name="heating" value="데우지않음" checked>
				<label for="heating_none">데우지 않음</label>
				<input type="radio" id="heating_warm" name="heating" value="따듯하게데움">
				<label for="heating_warm">따듯하게 데움</label>
			</div>
		</c:if>
		<div class="form-group" style="width:100%;">
			<div class="form-group col-md-3">
				<label class="title" for="quantity">수량</label>
				<button type="button" id="increaseBtn"class="btn btn-default btn-sm">+</button>
				<input id="quantity" name="quantity" readonly="readonly" value="1" style="text-align: center; width:20px; border: none;"></input>
				<button type="button" id="decreaseBtn"class="btn btn-default btn-sm">-</button>
			</div>
			<div>
			</div>
			<div class="form-group col-md-5" style="float:right; ">
				<label class="title" for="orderPrice">주문금액</label>
				<input id="orderPrice" name="orderPrice" value="${vo.price }" style="border: none;"></input>
			</div>
		</div>
		</fieldset>
	
		<div style="float: right; display: inline-block;">
		<button type="submit" formaction="opAdd.do?no=${vo.goodsNo }">주문하기</button>
		<button type="submit" formaction="/cart/add.do?no=${vo.goodsNo }">장바구니</button>
		<button type="submit" formaction="/mymenu/add.do">나만의메뉴</button>
		</div>
	</form>
</div>
</body>
</html>