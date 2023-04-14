/**
 * 정규표현식 자리
 */
 
 console.log("regEx.js Loading");
 
 // const - 상수 변수 선언
 const reg_digit = /^\d+$/;
 const reg_digit_error_msg = "숫자만 입력 하셔야 합니다.";
 
 // 년도 패턴 - 앞에 19xx 또는 20xx, 월은 01~12, 일은 01~31만 입력 가능.
 const reg_date = /^(19|20)\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;
 const reg_date_error_msg = "날짜형식은 YYYY-MM-DD로 입력 하셔야 합니다. 숫자와 '-'만 입력 가능 합니다.";
 
 // 아이디 패턴 - 첫글자는 영문자, 뒤에는 영숫자, 4자~20자 사이
 const reg_id = /^[a-z][a-z0-9]{3,19}$/;
 const reg_id_error_msg = "아이디 첫 글자는 영문자, 4~20자까지 영문자와 숫자만 입력 해 주세요.";
 
 // 연락처 패턴 - 
 const reg_tel = /^\d{2,3}-\d{3,4}-\d{4}$/;
 const reg_tel_error_msg = "연락처 형식은 xxx-xxxx-xxxx로 숫자와 '-'만 입력 가능합니다.";
 
 // 이메일 패턴 -
 const reg_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
 const reg_email_error_msg = "이메일 형식은 aaa@bbb.ccc 형식으로 입력 해 주세요.";
 
 // 이름 패턴 - 
 const reg_name = /^[가-힣]{2,10}$/;
 const reg_name_error_msg = "한글 2~10자리로 입력 해 주세요.";
 
 // 제목 패턴
 const reg_title = /^.{1,100}$/;
 const reg_title_error_msg = "제목은 한 글자 이상 20자 이하로 입력 해 주세요."
 
 // 내용 패턴
 const reg_content = /^(.|\n){1,300}$/;
 const reg_content_error_msg = "내용은 한 글자 이상 300자 이하로 입력 해 주세요."
 
 const reg_writer = /^.{1,10}$/;
 const reg_writer_error_msg = "작성자는 한 글자 이상 10자 이하로 입력 해 주세요."
 
 // 비밀번호 - 글자이면서 4자이상 2자 이내
 const reg_pw = /^[a-zA-Z0-9]{4,10}$/;
 const reg_pw_error_msg = "비밀번호는 4자 이상 10자 이하로 입력 해 주세요."
 
 // 정규 표현식을 검사하는 함수.
 // text(위에 정규표현식 변수, 검사할 문자열, 에러메세지)
 function test(reg, str, err_msg) {
	// 패턴에 맞지 않는 경우의 처리
	if(!reg.test(str)) {
		// 에러 경고창 띄우기
		alert(err_msg);
		// 호출한 쪽에 오류라고 false를 return한다.
		return false;
	}
	// 오류가 없는 경우 true를 return 해 준다. 안해주면 false와 같이 동작한다.
	return true;
}

	// 데이터 유효성 검사 함수
	// isTrim - 1이면 trim() 처리 한다. 0이면 trim() 처리를 하지 않는다.
function checkData(reg, obj, reg_err, isTrim) {
	if(isTrim) {
		obj.val(obj.val().trim());
	}
	// 잘못 입력된 데이터 처리
	if(!test(reg, obj.val(), reg_err)) {
		obj.focus();
		return false;
	}
	// 맞게 입력된 데이터 처리
	return true;
}