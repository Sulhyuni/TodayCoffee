<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today:비밀번호 찾기 성공</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<script type="text/javascript">
	$(function() {
		$("#loginBtn").click(function() {
			location = "/member/login.do";
		});

		// 	$("#findPw").click(function(){
		// 		location="/member/findPw.do";
		// 	});

	});
	$(function() {
		$("#changePwBtn").click(function() {
			$("#updateDiv").slideDown(); // 보이게
			return false; // 페이지 전송 a 취소
		});
		$("#cancelUpdateBtn").click(function() {
			$("#updateDiv").slideUp(); // 사라지게
		});
	});
</script>
<style type="text/css">
	#updateDiv{
	display: none;
}
</style>
</head>
<body>
	<div class="container">
		<h1 style="font-size: xx-large;">찾은 비밀번호 확인</h1>
		<table class="table" style="box-sizing: border-box;">
			<tr>
				<th style="font-size: x-large;">비밀번호:</th>
				<td style="font-size: x-large;">${pw }</td>
				<td><span hidden="">${vo.id }</span></td>
			</tr>
		</table>

		<button id="loginBtn">로그인 페이지</button>
		<button id="changePwBtn">바로 비밀번호 변경하기</button>
		<div id="updateDiv" class="well">
			<form action="changePwNow.do" method="post">
				<%-- 			<input type="hidden" name="perPageNum" value="${param.perPageNum }"> --%>
				<input type="hidden" name="id" value="${vo.id }">
				<div class="form-group">
					<table class="table">
						<tbody>
							<tr>
								<th>변경하실 비밀번호</th>
								<td><input name="pw" id="pw1" type="password"
									placeholder="비밀번호 입력" required="required" title="4자~20자 사이.">
								</td>
							</tr>
							<tr>
								<th>변경하실 비밀번호 확인</th>
								<td><input name="pw" id="pw2" type="password"
									placeholder="비밀번호 입력확인" required="required" title="4자~20자 사이.">
								</td>
							</tr>
						</tbody>

					</table>
				</div>
				<button>변경하기</button>
				<button type="button" id="cancelUpdateBtn">취소</button>
			</form>
		</div>

	</div>
</body>
</html>