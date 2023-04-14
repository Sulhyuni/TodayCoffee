<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today:아이디 찾기</title>
<!-- 라이브러리 등록 : CDN방식 -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<script type="text/javascript" src="/js/regEx.js"></script>

<style type="text/css">
	th{
		width: 200px;
	}
	
</style>

<script type="text/javascript">
	// 정규표현식 적용
	$(function(){
		$("#findIdForm").submit(function(){
			//아이디
			if(!checkData(reg_id, $("#id"), reg_id_error_msg, 1)) return false;
			
			//비밀번호
			if(!checkData(reg_pw, $("#pw"), reg_pw_error_msg, 1)) {
				$("#pw").val("");
				return false;
			}
			//비밀번호확인
			if(!checkData(reg_pw, $("#pw2"), reg_pw_error_msg, 1)) {
				$("#pw2").val("");
				return false;
			}
			//이름
			if(!checkData(reg_name, $("#name"), reg_name_error_msg, 1)) return false;
			//성별
			if(!checkData(reg_gender, $("#gender1"), reg_gender_error_msg, 0)) return false;
			if(!checkData(reg_gender, $("#gender2"), reg_gender_error_msg, 0)) return false;
			//생년월일
			if(!checkData(reg_birth, $("#birth"), reg_birth_error_msg, 1)) return false;
			//연락처
			if(!checkData(reg_tel, $("#tel2"), reg_tel_error_msg, 0)) return false;
			if(!checkData(reg_tel, $("#tel3"), reg_tel_error_msg, 0)) return false;
			//이메일
			if(!checkData(reg_email, $("#email"), reg_email_error_msg, 1)) return false;
			//비밀번호확인체크
			if($("#pw").val() != $("#pw2").val()){
				alert("비밀번호와 비밀번호확인이 다릅니다. 다시 입력해주세요");
				$("#pw","#pw2").val("");
				$("#pw").focus();
				return false;
			}else alert("회원가입 되셨습니다.")
		});
	});
</script>
	
</head>
<body>
<div class = "container" style="text-align: center;width: 30%">
	<h1>아이디 찾기</h1>
	<div class="row">
	<form action="findId.do" method="post" id="findIdForm" name="findIdForm">
	<!-- table -> caption,thead,tbody,tfooter -> tr -> th,td -> data -->
	<table class="table" >
		<tbody>
			<tr>
				<th >이름</th>
				<td>
					<input name="name" id="name" type="text"
					placeholder="이름 입력" 
					required="required" title="2자~10자 사이. 한글만 가능.">
				</td>
			</tr>
			<tr>
				<th >생년월일</th>
				<td>
					<input name="birth" id="birth" type="date"
					placeholder="yyyy-mm-dd"
					required="required" 
					title="생년월일은 yyyymmdd 연속된 숫자 8자를 사용하셔야 합니다.">
				</td>
			</tr>
			<tr>
				<th >연락처</th>
				<td>
<!-- 				name="tel"이 3개가있다. 배열로 받는다. -->
<!-- 				request.getParameterValues("tel") -->
					<select name="tel1" id="tel1" style="height: 2.1em">
						<option>010</option>
						<option>02</option>
						<option>031</option>
						<option>032</option>
						<option>033</option>
						<option>041</option>
						<option>042</option>
						<option>043</option>
					</select> -
					<input name="tel2" id="tel2"
					style="width:50px"> -
					<input name="tel3" id="tel3"
					style="width:50px">
				</td>
			</tr>
			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<button >찾기</button>
					<button type="reset" >새로입력</button>
					<button  type="button" onclick="location='/'">취소</button>
<!-- 					<button type="button" onclick="history.go(-2)">취소</button> -->
				</td>
			</tr>
		</tfoot>
	</table>
	</form>
	</div>
</div>
</body>
</html>