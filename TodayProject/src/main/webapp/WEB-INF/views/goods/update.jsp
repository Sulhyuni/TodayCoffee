<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<!--라이브러리 등록-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 

<script type="text/javascript">
$(function() {
	//updateForm submit 이벤트 처리하기
	$("#updateForm").submit(function() {
		
	});
	
	//취소(이전으로) 이벤트
	$("#cancelBtn").click(function() {
		history.back();
	});
	//수정시 한번 더 묻기	
	$("#updateBtn").click(function(){
		if(!confirm("정말 수정하시겠습니까?")) return false;
	});

	$(".soldOut").click(function() {
		alert("개발중입니다. 상품 삭제 메뉴를 이용해주세요.");
		return false;
	})
});
</script>
</head>
<body>
<div class = "container">
		<div class="col-md-12">
			<h2>상품 수정</h2>
		</div>
		<div class="col-md-12">
			<hr>
		</div>
	<form action="update.do" method="post" id="updateForm">
		<input type="hidden" name="no" value="${vo.goodsNo }">
		
		<!-- 분류 체크 readonly -->
		<!-- 작성해야할 목록 -> name _kr, name_en, goodsView, price, goodsDiv fileName -->
		
			<div class = "form-group row" >
				<div class="col-xs-2">
					<label for ="goodsDiv">분류</label>
					<input name="goodsDiv" id="goodsDiv" class="form-control" value="${vo.goodsDiv }" readonly="readonly">
				</div>	
				<div class="col-xs-2 " id="stockDiv">
					<label for="stock">재고</label>
					<input  name ="stock" class ="form-control"  type = "number" id="stock" value="${vo.stock }"  >
					<button class="btn btn-danger soldOut" style="float: right;">품절처리</button>
				</div>
			</div>
			
		<div class = "form-group" style="margin-top: 5px;">
			<label for ="name_kr">상품명_한글</label>
			<input name="name_kr" id="name_kr" class="form-control" value="${vo.name_kr }">
		</div>	
		<div class = "form-group">
			<label for ="name_en">상품명_영문</label>
			<input name="name_en" id="name_kr" class="form-control" value="${vo.name_en }">
		</div>	
		<div class = "form-group">
			<label for ="price">가격</label>
			<input type="number" name="price" id="price" class="form-control" value="${vo.price }">
		</div>	
		<div class = "form-group">
			<label for ="goodsView">상품 설명</label>
			<textarea name="goodsView" id="goodsView" class="form-control" rows="5" >${vo.goodsView }</textarea>
		</div>	
		
			<!-- 등록, 새로입력, 취소(이전으로) 버튼 생성 -->
			<div style ="float: right;">
				<button type="submit" id = "updateBtn">수정 등록</button>
				<button type="reset">새로입력</button>
				<button type="button" id="cancelBtn">취소</button>
			</div>
	</form>
</div>

</body>
</html>