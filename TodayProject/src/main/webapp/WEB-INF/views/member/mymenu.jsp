<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My menu</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#cancelUpdateBtn").click(function(){
		$("#updateDiv").slideUp(); // 사라지게
	});
	$("#formPwModifyBtn").click(function(){
		$("#pwModifyForm").submit();
	})
});
</script>
<style type="text/css">
button{
height: 200px;
width: 200px;
margin: 1.3em;
} */
.id{
	font-size: xx-large;
}
</style>
</head>
<body>
<div class="container">
<h1 id="id" class="id" >${login.id }님 환영합니다.</h1>
<input type="hidden" name="id" value="${login.id }">
<%-- <button onclick="location='view.do?id=${login.id }'" id="updateBtn">내정보보기</button> --%>
<button class="pwModalBtn" data-toggle="modal" data-target="#pwModal">개인정보 관리</button>
<button onclick="location='/mymenu/list.do'">나만의 메뉴</button>
<button onclick="location='statusWakeUp.do'">휴면해제하기</button>
<button onclick="location='/cart/list.do'">장바구니</button>
<button onclick="location='/order/list.do'">주문 내역</button>
<c:if test="${ login != null && login.gradeNo == 9 }">
<button onclick="location='list.do'">회원 리스트</button>
</c:if>
</div>
	<div id="pwModal" class="modal fade in" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 700px; height: 300px;">
				<div class="momdal-header">
					<h1 class="modal-title" align="center" style="font-size: xx-large;">비밀번호 입력
					<button type="button" class="close" data-dismiss="modal" style="width: 20px;height: 20px;">×</button>
					</h1>
					
				</div>
				<div></div>
				<div class="modal-body">
					<form action="checkPw.do?id=${login.id }" method="post" id="pwModifyForm">
						<div class="form-group">
							<label >개인정보 관리를 위한 비밀번호 입력</label>
							<input name="pw" id="pw" type="password" class="form-control"
							placeholder="비밀번호 입력" required="required" style="width: 45em; "
							title="4자~20자 사이." >
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="formPwModifyBtn" class="btn btn-default" style="width: 170px;height: 50px; float: left; " >확인</button>
					<button data-dismiss="modal" class="btn btn-default" style="width: 170px;height: 50px;">닫기</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>