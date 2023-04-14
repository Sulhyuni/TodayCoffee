<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/regEx.js"></script>

<script type="text/javascript">
	$(function() {
		$("#changePwForm").submit(function() {
			//비밀번호
			if (!checkData(reg_pw, $("#pw1"), reg_pw_error_msg, 1)) {
				$("#pw").val("");
				return false;
			}
			//비밀번호확인
			if (!checkData(reg_pw, $("#pw2"), reg_pw_error_msg, 1)) {
				$("#pw2").val("");
				return false;
			}
			//비밀번호확인체크
			if ($("#pw1").val() != $("#pw2").val()) {
				alert("비밀번호와 비밀번호확인이 다릅니다. 다시 입력해주세요");
				$("#pw1", "#pw2").val("");
				$("#pw1").focus();
				return false;
			} else if ($("#prePw").val() == $("#pw1").val()) {
				alert("기존 비밀번호와 변경할 비밀번호가 같습니다. 다시 입력해주세요");
				$("#pw1", "#pw2", "#prePw").val("");
				$("#prePw").focus();
				return false;
			} else
				alert("비밀번호가 변경되셨습니다.")
		});
	});
</script>
<style type="text/css">
th {
	width: 200px;
}
</style>
</head>
<body>
	<div class="container" style="text-align: center;width: 30%">
		<h1 style="font-size: xx-large;">비밀번호 변경</h1>
		<form action="changePw.do" method="post" id="changePwForm"
			name="changePwForm">
			<input type="hidden" name="page" value="${param.page }"> <input
				type="hidden" name="perPageNum" value="${param.perPageNum }">
			<input type="hidden" name="key" value="${param.key }"> <input
				type="hidden" name="word" value="${param.word }"> <input
				type="hidden" name="id" value="${param.id }">
			<table class="table">
				<tbody>
					<tr class="dataRow">
						<th>기존 비밀번호</th>
						<td><input type="password" id="prePw" name="prePw"
							placeholder="기존 비밀번호 입력"></td>
					</tr>
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
			<button>변경하기</button>
			<!-- 	<button  id="mymenuBtn">마이 메뉴</button> -->
			<button type="reset">새로입력</button>
		</form>
	</div>
</body>
</html>