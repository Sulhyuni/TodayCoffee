<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today:회원상세보기</title>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
#deleteDiv{
	display: none;
}
</style>

<script type="text/javascript">
$(function(){
	// 삭제 버튼 이벤트 처리 - a tag
	$("#deleteBtn").click(function(){
		$("#deleteDiv").slideDown(); // 보이게
		return false; // 페이지 전송 a 취소
	});
	$("#cancelDeleteBtn").click(function(){
		$("#deleteDiv").slideUp(); // 사라지게
	});
});
</script>

</head>
<body>
<div class="container">
	<h1>회원 상세 정보</h1>
	<table class="table">
		<tbody>
			<tr>
				<th>아이디</th>
				<td>${vo.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${vo.name }</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${vo.gender }</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${vo.birth }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${vo.tel1 }-${vo.tel2 }-${vo.tel3 }</td>
				
			</tr>
			<tr>
				<th>이메일</th>
				<td>${vo.email }</td>
			</tr>
			<tr>
				<th>상태</th>
				<td>${vo.status }</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>${vo.regDate }</td>
			</tr>
			<tr>
				<th>최근접속일</th>
				<td>${vo.conDate }</td>
			</tr>
			<tr>
				<th>포인트</th>
				<td>${vo.point }</td>
			</tr>
			<tr>
				<th>등급이름</th>
				<td>${vo.gradeName }</td>
			</tr>
		</tbody>
	</table>
	<a href="update.do?id=${vo.id }&page=${param.page}&perPageNum=${param.perPageNum}&key=${param.key }&word=${param.word}">
	<button>수정</button></a>
	<c:if test="${ login != null && login.gradeNo == 9 }">
	<a href="list.do?page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key }&word=${param.word}"
	 ><button>리스트</button></a></c:if>
	<a href="changePw.do?id=${vo.id }&page=${param.page}&perPageNum=${param.perPageNum}&key=${param.key }&word=${param.word}" id="changePwBtn"><button>비밀번호 변경</button></a>
	<a href="delete.do" id="deleteBtn"><button>회원탈퇴</button></a>
<!-- 	<a><button onclick="history.back()" >이전메뉴</button></a> -->
	<div id="deleteDiv" class="well">
		<form action="delete.do?id=${vo.id }" method="post">
			<input type="hidden" name="perPageNum" value="${param.perPageNum }">
			<input type="hidden" name="no" value="${vo.id }">
			<div class="form-group">
				<label for="pw">정말 탈퇴 하시겠습니까? <br/>탈퇴하시려면 비밀번호(본인 확인용)를 입력해주세요</label>
				<input type="password" name="pw" class="form-control">
			</div>
			<button>확인</button>
			<button type="button" id="cancelDeleteBtn">취소</button>
		</form>
	</div>
</div>
</body>
</html>