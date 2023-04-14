<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/js/regEx.js"></script>

<script type="text/javascript">
$(function(){
	$("#updateForm").submit(function(){
		// 제목, 내용, 작성자, 비밀번호, 비밀번호, 비밀번호=비밀번호 확인 유효성 검사.
		//아이디
		if(!checkData(reg_id, $("#id"), reg_id_error_msg, 1)) return false;
		//이름
		if(!checkData(reg_name, $("#name"), reg_name_error_msg, 1)) return false;
		//생년월일
		if(!checkData(reg_birth, $("#birth"), reg_birth_error_msg, 1)) return false;
		//연락처
		if(!checkData(reg_tel, $("#tel2"), reg_tel_error_msg, 0)) return false;
		if(!checkData(reg_tel, $("#tel3"), reg_tel_error_msg, 0)) return false;
		//이메일
		if(!checkData(reg_email, $("#email"), reg_email_error_msg, 1)) return false;
		//비밀번호확인체크
		
	});
	
	// 취소 이벤트
	$("#cancelBtn").click(function(){
		history.back();
	});
});
</script>

</head>
<body>
<div class="container">
	<h1>개인 정보 관리</h1>
	<form action="update.do" method="post" id="updateForm">
		<input type="hidden" name="page" value="${param.page }">
		<input type="hidden" name="perPageNum" value="${param.perPageNum }">
		<input type="hidden" name="key" value="${param.key }">
		<input type="hidden" name="word" value="${param.word }">
		<div class="form-group">
			<label for="id">아이디</label>
			<input name="id" id="id" class="form-control" readonly value="${vo.id }">
		</div>
		<div class="form-group">
			<label for="name">이름</label>
			<input name="name" id="name" class="form-control" value="${vo.name }">
		</div>
		<div class="form-group">
			<label for="gender">성별</label>
			<input name="gender" id="gender" class="form-control" readonly value="${vo.gender }">
		</div>
		<div class="form-group">
			<label for="birth">생년월일</label>
			<input name="birth" id="birth" class="form-control" style="width: 250px;" type="date" value="${vo.birth }">
		</div>
		<div class="form-group">
			<label for="tel">전화번호</label>
			<div class="form-control">
			<select name="tel1" id="tel1"  style="height: 1.7em;" onchange="${vo.tel1 }">
						<option>010</option>
						<option>02</option>
						<option>031</option>
						<option>032</option>
						<option>033</option>
						<option>041</option>
						<option>042</option>
						<option>043</option>
					</select>  -  
					<input name="tel2" id="tel2" value="${vo.tel2 }"
					style="width:40px;border: 0; ">  -  
					<input name="tel3" id="tel3" value="${vo.tel3 }"
					style="width:40px;border: 0; ">
			</div>
		</div>
		<div class="form-group">
			<label for="email">이메일</label>
			<input name="email" id="email"  class="form-control" value="${vo.email }">
		</div>
		<div class="form-group">
			<label for="status">상태</label>
			<input name="status" id="status"  class="form-control" readonly value="${vo.status }">
		</div>
		<div class="form-group">
			<label for="regDate">가입일</label>
			<input name="regDate" id="regDate"  class="form-control" readonly value="${vo.regDate }">
		</div>
		<div class="form-group">
			<label for="conDate">최근접속일</label>
			<input name="conDate" id="conDate"  class="form-control" readonly value="${vo.conDate }">
		</div>
		<div class="form-group">
			<label for="point">포인트</label>
			<input name="point" id="point" class="form-control" readonly value="${vo.point }">
		</div>
		<div class="form-group">
			<label for="gradeName">등급이름</label>
			<input name="gradeName" id="gradeName" class="form-control" readonly value="${vo.gradeName }">
		</div>
		<button>수정</button>
		<button type="button" id="cancelBtn">취소</button>
	</form>
</div>
</body>
</html>