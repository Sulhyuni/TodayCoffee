<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
<!-- 라이브러리 등록  : CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function() {
	//이미지 변경 확인 창
	$("#changeBtn").click(function() {
		if(!confirm("변경하시겠습니까?")) return false;
	});
	
	//상품 삭제 확인 창
	$("#deleteBtn").click(function() {
		if(!confirm("정말 삭제하시겠습니까?")) return false;
	});
	//이미지 변경 이벤트
	$("#changeImageBtn").click(function(){
		$("#changeImageDiv").slideDown();
	});
	
	$("#cancelBtn").click(function(){
		$("#changeImageDiv").slideUp();
	});
	
	$("#updateImageForm").submit(function(){
		if(!$("#imageFile").val()){
			alert("이미지 파일을 선택하셔야 합니다.");
			return false;
		}
	});
	
	$("#orderBtn").click(function() {
		if(${login !=null}){
			location.href = "/order/opAdd.do?no=${vo.goodsNo }";
		}else
			alert("로그인 후 이용 가능합니다.");
		return false;
	})
	
 
});

</script>
<style type="text/css">
#name_kr{
	font-size :30px;
	font-weight:900;
	height: 
}
#changeImageDiv{
	display: none;
}

</style>

</head>
<body>
<!-- 개발 후반부에 관리자 접근 주석 풀기 -->
	<div class="container">
		<div class="col-md-12">
		<!-- 로그인시 이벤트 실행. 비로그인시 '회원가입 후 이용가능' 알람창 띄우기 // 개발중 02.23 -->
			<a href="/order/opAdd.do?no=${vo.goodsNo }">
				<button id ="orderBtn" style="float: right; margin-bottom: 10px;" >주문하기</button>
			</a> 
			<a href="list.do">
				<button style="float: right; margin-bottom: 10px;">리스트</button>
			</a> 
			<!-- 관리자 접근 -->
			<c:if test="${login !=null && login.gradeNo == 9 }">
				<a href="update.do?no=${vo.goodsNo}">
					<button style="float: right; margin-bottom: 10px;">상품수정</button>
				</a> 
				<a href="delete.do?no=${vo.goodsNo}&deleteFile=${vo.fileName}">
					<button style="float: right; margin-bottom: 10px;" id = "deleteBtn">상품삭제</button>
				</a>
			</c:if>
			<h2>상세보기</h2>
		</div>
		<div class="col-md-12">
			<hr>
		</div>
<!-- 이미지  -->
		<div class="row">
			<div class="col-md-4">
				<img src="${vo.fileName }" class="img-thubnail" />
			<div>
			<c:if test="${login !=null && login.gradeNo==9 }">
				<button class="btn btn-primary btn-xs" id="changeImageBtn">이미지 변경</button>
				<div id="changeImageDiv">
					<form action="updateImg.do" method="post" id ="updateimageForm" enctype="multipart/form-data">
						<input type="hidden" name="no" value="${vo.goodsNo}">
						<input type="hidden" name="deleteFile" value="${vo.fileName}">
						<div class="form-group">
						<label for="imageFile">변경 이미지 선택</label>
						<input class="form-control" name="imageFile" id="imageFile" type="file">
						</div>
						<button>변경하기</button>
						<button type="button" id=cancelBtn>취소</button>
					</form>
				</div>
				</c:if>
			</div>
			</div>
			<div class="col-md-8">
			<span id="name_kr">${vo.name_kr}</span>
				<br> 
			<span>  ${vo.name_en }</span>
			<hr style="border: solid 8px;">
						<div class="row"  >
<!-- 							<label class="col-md-3" >상세</label> -->
							<div class="col-md-9">${vo.goodsView }</div>
							
						</div>
							<hr style="border: solid 1px; ">
						<div class="row">
							<label class="col-md-3">분류</label>
							<div class="col-md-9">${vo.goodsDiv }</div>
						</div>
						<div class="row">
							<label class="col-md-3">상품가격</label>
							<div class="col-md-9"><b>${vo.price }원</b></div>
						</div>
						<c:if test="${login.gradeNo==9 && vo.goodsDiv eq 'food'}">
						<div class="row">
							<label class="col-md-3" >재고(관리자용)</label>
							<div class="col-md-9">${vo.stock }개</div>
						</div>
						</c:if>
			</div>
		</div>
		
	</div>

</body>
</html>