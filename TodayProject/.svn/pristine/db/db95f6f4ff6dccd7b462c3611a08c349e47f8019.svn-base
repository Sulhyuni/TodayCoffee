<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.modal-header{
	background:#c7bbad;
}
.modal-title{
	color:white;
}
.modal-content{
	width:500px;
	heigth:300px;
}
.close{
	font-size:30px;
	color:white;
}
#div{
	width:800px;
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
#btn{
	position:absolute;
	left:550px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="col-md-12">
	<a href = "list.do">
	<button style="float: right; margin-bottom: 10px;">나만의메뉴</button></a>
	<h2>나만의 메뉴 수정</h2>
	<p style="text-align:center;margin-bottom:15px;"> ※ 나만의 메뉴 수정은 이름만 수정 가능합니다. ※</p>
</div>
<div class="col-md-12">
	<hr>
</div>
<div class="row">
	<div class="col-md-4">
		<img src="${vo.fileName }"class="img-thubnail"style=" margin-top: -40px;"/>
	</div>
	<div class="col-md-8"style=" margin-top: -40px;">메뉴명:&nbsp; ${vo.mmName }
	<!-- 수정 버튼Modal -->
	<button type="button"id="btn"class="btn btn-default"data-toggle="modal"data-target="#upModal"style="float: right;">수정</button>
		<div style="margin-top:20px;">
			<hr>
			<div class="row">
				<div class="col-md-8"style=" margin-top: -40px;">상품명 :&nbsp;${vo.name_kr }</div>
				<div id="div"class="col-md-8"style="margin-bottom: 5px; margin-top: -20px;">
				상품 설명:&nbsp;${vo.goodsview }</div>
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
			<div class="col-md-10"id="heating"style="margin-bottom:-30px;">${vo.heating }</div>
			</c:if>
		</div>
		<!-- Modal -->
		<div id="upModal"class="modal fade"role="dialog">
			<div class="modal-dialog">
		<!-- Modal content -->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button"class="close"data-dismiss="modal"id="x">x</button>
				<h4 class="modal-title">나만의 메뉴 메뉴명 수정</h4>
			</div>
			<div class="modal-body"id="updateForm">
				<form action="update.do"method="post"id="updateForm">
					<input type="hidden"name="no"value="${vo.mmNo }">
					<div class="form-group">
						<label for="Name">메뉴명</label>
						<input name="Name"id="Name"class="form-control">
					</div>
					<div class="modal-footer"style="margin-top: 30px;">
						<button class="btn btn-default pull-right">수정</button>
					</div>
				</form>
			</div>
		</div>
		</div>
		
		</div>
	</div>
</div>
</div>
</body>
</html>