package com.today.member.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.today.main.Execute;
import com.today.main.ServiceInterface;
import com.today.member.vo.MemberVO;
import com.webjjang.util.PageObject;

public class MemberController {

	// private으로 서비스 생성
	private ServiceInterface memberLoginService;
	private ServiceInterface memberWriteService;
	private ServiceInterface memberListService;
	private ServiceInterface memberViewService;
	private ServiceInterface memberCheckIdService;
	private ServiceInterface memberFindIdService;
	private ServiceInterface memberFindPwService;
	private ServiceInterface memberChangePwService;
	private ServiceInterface memberChangePwNowService;
	private ServiceInterface memberCheckPwService;
	private ServiceInterface memberUpdateService;
	private ServiceInterface memberChangeGradeNoService;
	private ServiceInterface memberChangeStatusService;
	private ServiceInterface memberDeleteService;
	private ServiceInterface memberWakeUpService;

	// setter
	public void setMemberLoginService(ServiceInterface memberLoginService) {
		this.memberLoginService = memberLoginService;
	}

	public void setMemberWriteService(ServiceInterface memberWriteService) {
		this.memberWriteService = memberWriteService;
	}

	public void setMemberListService(ServiceInterface memberListService) {
		this.memberListService = memberListService;
	}

	public void setMemberViewService(ServiceInterface memberViewService) {
		this.memberViewService = memberViewService;
	}

	public void setMemberCheckIdService(ServiceInterface memberCheckIdService) {
		this.memberCheckIdService = memberCheckIdService;
	}

	public void setMemberFindIdService(ServiceInterface memberFindIdService) {
		this.memberFindIdService = memberFindIdService;
	}

	public void setMemberFindPwService(ServiceInterface memberFindPwService) {
		this.memberFindPwService = memberFindPwService;
	}

	public void setMemberChangePwService(ServiceInterface memberChangePwService) {
		this.memberChangePwService = memberChangePwService;
	}

	public void setMemberChangePwNowService(ServiceInterface memberChangePwNowService) {
		this.memberChangePwNowService = memberChangePwNowService;
	}

	public void setMemberCheckPwService(ServiceInterface memberCheckPwService) {
		this.memberCheckPwService = memberCheckPwService;
	}

	public void setMemberUpdateService(ServiceInterface memberUpdateService) {
		this.memberUpdateService = memberUpdateService;
	}

	public void setMemberChangeStatusService(ServiceInterface memberChangeStatusService) {
		this.memberChangeStatusService = memberChangeStatusService;
	}

	public void setMemberChangeGradeNoService(ServiceInterface memberChangeGradeNoService) {
		this.memberChangeGradeNoService = memberChangeGradeNoService;
	}

	public void setMemberDeleteService(ServiceInterface memberDeleteService) {
		this.memberDeleteService = memberDeleteService;
	}

	public void setMemberWakeUpService(ServiceInterface memberWakeUpService) {
		this.memberWakeUpService = memberWakeUpService;
	}

	// 실행 메서드 - return되는 String 데이터는 jsp또는 url정보가 된다.
	public String execute(HttpServletRequest request) throws Exception {

		System.out.println("MemberController.execute().request : " + request);
		// 어떤 요청
		String uri = request.getRequestURI();
		String method = request.getMethod();
		System.out.println("MemberController.execute().method : " + method);
		String jsp = null;
		// 처리
		switch (uri) {
		// 로그인 -------------------------------------------------
		case "/member/login.do":
//			System.out.println("controller");
			HttpSession session = request.getSession();
			if (request.getMethod().equals("GET")) {
				jsp = "member/login";
			} else {
				MemberVO loginVO = new MemberVO();
				// 입력받은 id, pw 세팅
				loginVO.setId(request.getParameter("id"));
				loginVO.setPw(request.getParameter("pw"));
				session.setAttribute("login", Execute.run(memberLoginService, loginVO));
				if (session.getAttribute("login") == null)
					throw new Exception("아이디와 비밀번호를 확인해주세요");
				// 회원상태 세션에 저장.
				String status = ((MemberVO) session.getAttribute("login")).getStatus();
				if (status.equals("휴면")) {
					jsp = "member/statusSleep";
				} else

					jsp = "redirect:/"; // main으로 자동이동
			}
			break;
		// 휴면해제하기 -------------------------------------------------
		case "/member/statusWakeUp.do":
			session = request.getSession();
			if (request.getMethod().equals("GET")) {
				jsp = "member/statusWakeUp";
			} else {
				MemberVO wakeUpVO = new MemberVO();
				// 휴면해제를위한 데이터 세팅
				String id = ((MemberVO) session.getAttribute("login")).getId();
				wakeUpVO.setId(id);
				wakeUpVO.setPw(request.getParameter("pw"));
				wakeUpVO.setName(request.getParameter("name"));
				wakeUpVO.setTel1(request.getParameter("tel1"));
				wakeUpVO.setTel2(request.getParameter("tel2"));
				wakeUpVO.setTel3(request.getParameter("tel3"));
				session.setAttribute("wakeUpVO", Execute.run(memberWakeUpService, wakeUpVO));
				if (session.getAttribute("login") == null)
					throw new Exception("세션이 만료되었습니다. 다시 로그인해주세요");

				jsp = "/member/afterStatusWU";
			}
			break;
		// 로그아웃 -------------------------------------------------
		case "/member/logout.do":
			session = request.getSession();
			session.removeAttribute("login");
			session.invalidate();
			jsp = "redirect:/";

			break;
		// 약관동의 페이지 -------------------------------------------------
		case "/member/join.do":
			session = request.getSession();
			jsp = "member/join";
			break;
		// 회원가입 페이지 -------------------------------------------------
		case "/member/write.do":
			if (request.getMethod().equals("GET")) {
				jsp = "member/write";
			} else {
				// 데이터 수집
				MemberVO writeVO = new MemberVO();
				System.out.println(request.getParameter("id"));
				writeVO.setId(request.getParameter("id"));
				writeVO.setPw(request.getParameter("pw"));
				writeVO.setName(request.getParameter("name"));
				writeVO.setGender(request.getParameter("gender"));
				writeVO.setBirth(request.getParameter("birth"));
				writeVO.setTel1(request.getParameter("tel1"));
				writeVO.setTel2(request.getParameter("tel2"));
				writeVO.setTel3(request.getParameter("tel3"));
				writeVO.setEmail(request.getParameter("email"));

				Execute.run(memberWriteService, writeVO);

				jsp = "member/afterWrite";
			}
			break;
		// 회원 리스트(관리자) -------------------------------------------------
		case "/member/list.do":
			// 페이지 정보 받기
			PageObject pageObject = PageObject.getInstance(request);
			request.setAttribute("list", Execute.run(memberListService, pageObject));
			// jsp - 리스트 데이터 아래의 페이지 네비게이션을 위한 데이터 저장
			request.setAttribute("pageObject", pageObject);
			jsp = "member/list";
			break;
		// 회원상세보기 -------------------------------------------------
		case "/member/view.do":
			// 세션 가져오기
			session = request.getSession();
			// 아이디를 세션에서 가져온다.
			String id = ((MemberVO) session.getAttribute("login")).getId();
			// 세션에서 등급이름도 가져온다.
			String gradeName = ((MemberVO) session.getAttribute("login")).getGradeName();
			// 로그인된 세션의 등급이름이 관리자인 아이디이면 요청되는id로 view서비스 실행 (세션X)
			if (gradeName.equals("관리자"))
				id = request.getParameter("id");
			MemberVO viewVO = (MemberVO) Execute.run(memberViewService, new Object[] { id });

			request.setAttribute("vo", viewVO);
			jsp = "member/view";
			break;
		// 아이디 중복체크 -------------------------------------------------
		case "/member/checkId.do":
			// 입력받은 아이디가져옴
			id = request.getParameter("id");
			request.setAttribute("result", Execute.run(memberCheckIdService, id));
			jsp = "member/checkId";
			break;
		// MYMENU 페이지 -------------------------------------------------
		case "/member/mymenu.do":
			// 세션 가져오기
			session = request.getSession();
			jsp = "member/mymenu";
			break;
		// 아이디 찾기 -------------------------------------------------
		case "/member/findId.do":
			// 세션 가져오기
//			session = request.getSession();
			if (request.getMethod().equals("GET")) {
				jsp = "member/findId";
			} else { // post
				// 데이터 수집 - name,birth,tel1,2,3 받아야 한다.
				MemberVO findIdVO = new MemberVO();
				findIdVO.setName(request.getParameter("name"));
				findIdVO.setBirth(request.getParameter("birth"));
				findIdVO.setTel1(request.getParameter("tel1"));
				findIdVO.setTel2(request.getParameter("tel2"));
				findIdVO.setTel3(request.getParameter("tel3"));

				request.setAttribute("id", Execute.run(memberFindIdService, findIdVO));

				jsp = "member/afterFI";
			}
			break;
			// 비밀번호 찾기 -------------------------------------------------
		case "/member/findPw.do":
			session = request.getSession();
			if (request.getMethod().equals("GET")) {
				jsp = "member/findPw";
			} else { // post
				// 데이터 수집 
				MemberVO findPwVO = new MemberVO();
				findPwVO.setId(request.getParameter("id"));
				findPwVO.setName(request.getParameter("name"));
				findPwVO.setTel1(request.getParameter("tel1"));
				findPwVO.setTel2(request.getParameter("tel2"));
				findPwVO.setTel3(request.getParameter("tel3"));

				String pw = (String) Execute.run(memberFindPwService, findPwVO);
				// pw 끝 두자리 암호화
				String secretPw = pw.substring(0, pw.length() - 2) + "**";
				// 암호화된 pw를 세팅
				request.setAttribute("pw", secretPw);

				request.setAttribute("vo", findPwVO);
				jsp = "member/afterFP";
			}
			break;
			// 비밀번호 체크 -------------------------------------------------
		case "/member/checkPw.do":
			// 세션 가져오기
			session = request.getSession();
			// 세션에서 가져온id
			id = ((MemberVO) session.getAttribute("login")).getId();
			MemberVO checkPwVO = (MemberVO) session.getAttribute("login");
			checkPwVO.setId(id);
			// 입력받은 비밀번호 세팅
			checkPwVO.setPw(request.getParameter("pw"));
			// 데이터 처리 -> request에 담는다. -> jsp에서 꺼내 쓴다. EL 객체 사용
			checkPwVO = (MemberVO) Execute.run(memberCheckPwService, checkPwVO);
			// 세션에서 가져온 pw 선언
			String pw = ((MemberVO) session.getAttribute("login")).getPw();
			// db에서 가져온 비밀번호와 입력받은 비밀번호가 같을은지 확인
			if (checkPwVO.getPw().equals(pw)) {
				request.setAttribute("vo", checkPwVO);
			} else {
				throw new Exception("비밀번호가 다릅니다. 다시 입력해주세요");
			}
			jsp = "member/view";
			break;
			// 정보 수정 -------------------------------------------------
		case "/member/update.do":
			// 세션가져오기
			session = request.getSession();
			
			// 로그인 된 세션의 아이디 가져옴
			id = ((MemberVO) session.getAttribute("login")).getId();
			
			// 등급이름도 세션에서 가져옴
			gradeName = ((MemberVO) session.getAttribute("login")).getGradeName();
			
			// 로그인 된 세션의 등급이름이 관리자인 아이디이면 요청되는id로 view서비스 실행
			if (gradeName.equals("관리자"))
				id = request.getParameter("id");
			if (request.getMethod().equals("GET")) {
				// 관리자이면 요청받은 id로 실행
				gradeName = ((MemberVO) session.getAttribute("login")).getGradeName();
				if (gradeName.equals("관리자"))
					id = request.getParameter("id");
				request.setAttribute("vo", Execute.run(memberViewService, new Object[] { id }));

				jsp = "member/update";
			} else {//post
				MemberVO updateVO = new MemberVO();
				// 데이터 수집 vo 넣기
				updateVO.setId(id);
				updateVO.setName(request.getParameter("name"));
				updateVO.setBirth(request.getParameter("birth"));
				updateVO.setTel1(request.getParameter("tel1"));
				updateVO.setTel2(request.getParameter("tel2"));
				updateVO.setTel3(request.getParameter("tel3"));
				updateVO.setEmail(request.getParameter("email"));

				// DB 처리
				Execute.run(memberUpdateService, updateVO);

				// 보기로 자동이동
				jsp = "redirect:view.do?id=" + id + "&page=" + request.getParameter("page") + "&perPageNum="
						+ request.getParameter("perPageNum") + "&key=" + request.getParameter("key") + "&word="
						+ URLEncoder.encode(request.getParameter("word"), "utf-8");
			}
			break;
			// 회원탈퇴 -------------------------------------------------
		case "/member/delete.do":
			// 데이터 수집 - 글번호, 비밀번호
			session = request.getSession();
			id = ((MemberVO) session.getAttribute("login")).getId();
			gradeName = ((MemberVO) session.getAttribute("login")).getGradeName();
			// 로그인된 세션의 등급이름이 관리자인 아이디이면 요청되는id로 view서비스 실행
			if (gradeName.equals("관리자"))
				id = request.getParameter("id");
			MemberVO deleteVO = new MemberVO();
			// 아이디,비번세팅
			deleteVO.setId(id);
			deleteVO.setPw(request.getParameter("pw"));
			// DB 삭제 처리.
			int result = (int) Execute.run(memberDeleteService, deleteVO);
			if (result != 1)
				throw new Exception("회원탈퇴 실패 - 비밀번호가 틀렸습니다. 다시 입력해주세요");
			else // 세션 제거
				session.removeAttribute("login");
			jsp = "member/afterDelete";
			break;
			// 비밀번호바꾸기 
		case "/member/changePw.do":
			// DB에서 데이터 가져오기
			if (request.getMethod().equals("GET")) {
				session = request.getSession();
				id = ((MemberVO) session.getAttribute("login")).getId();
				jsp = "member/changePw";
			} else {// post
				// VO 생성
				MemberVO changePwVO = new MemberVO();
				// 세션 가져온다
				session = request.getSession();
				// 아이디는 세션의 아이디로 세팅한다.
				id = ((MemberVO) session.getAttribute("login")).getId();
				// 세션의 등급번호 체크를 위한 선언
				int gradeNo = ((MemberVO) session.getAttribute("login")).getGradeNo();
				// changePwVO에 세션의 아이디 세팅
				changePwVO.setId(id);
				// 세션의 등급번호가 9(관리자)이면 아이디를 요청받은id로 세팅
				if (gradeNo == 9)
					changePwVO.setId(request.getParameter("id"));
				// 기존 pw 세팅
				changePwVO.setPw(request.getParameter("prePw"));
				// PW 같은지 체크
				checkPwVO = (MemberVO) Execute.run(memberCheckPwService, changePwVO);

				if (checkPwVO.getName() != null) {
					// 체크되면 바꿀 비밀번호 저장
					changePwVO.setPw(request.getParameter("pw"));
					// changePwVO속성값 저장
					request.setAttribute("vo", changePwVO);
					session.setAttribute("changePw", Execute.run(memberChangePwService, changePwVO));
				} else
					throw new Exception("기존 비밀번호가 다릅니다.");
				// 로그인된 세션의 등급이 관리자인 아이디이면 요청되는id로 view서비스 실행
				if (gradeNo == 9)
					id = request.getParameter("id");
				viewVO = (MemberVO) Execute.run(memberViewService, new Object[] { id });

				request.setAttribute("vo", viewVO);
				// 보기로 자동이동
				jsp = "redirect:view.do?id=" + id + "&page=" + request.getParameter("page") + "&perPageNum="
						+ request.getParameter("perPageNum") + "&key=" + request.getParameter("key") + "&word="
						+ URLEncoder.encode(request.getParameter("word"), "utf-8");
			}
			break;
		// 즉시 비밀번호 변경하기 (기존비밀번호안받음)-------------------------------------------------
		case "/member/changePwNow.do":
			// 데이터 수집 - 아이디,비밀번호
			// vo 생성
			MemberVO changePwNowVO = new MemberVO();
			// id,pw 세팅
			changePwNowVO.setId(request.getParameter("id"));
			changePwNowVO.setPw(request.getParameter("pw"));
			Execute.run(memberChangePwNowService, changePwNowVO);
			jsp = "member/afterChangePN";
			break;
			// 상태변경 서비스 -------------------------------------------------
		case "/member/changeStatus.do":
			// 세션 가져오기
			session = request.getSession();
			// VO에 id와 status, 세팅
			MemberVO changeStatusVO = new MemberVO();
			changeStatusVO.setId(request.getParameter("id"));
			changeStatusVO.setStatus(request.getParameter("status"));
			// 처리
			request.setAttribute("vo", changeStatusVO);
			session.setAttribute("changeStatus", Execute.run(memberChangeStatusService, changeStatusVO));
			// 관리자만 실행할 서비스이므로 세션에서 관리자의 아이디를 가져온다.
			id = ((MemberVO) session.getAttribute("login")).getId();
			pageObject = PageObject.getInstance(request);
			// 페이지처리 저장
			request.setAttribute("pageObject", pageObject);
			// 리스트로 자동이동
			jsp = "redirect:list.do?id=" + id + "&page=" + request.getParameter("page") + "&perPageNum="
					+ request.getParameter("perPageNum") + "&key=" + request.getParameter("key") + "&word="
					+ URLEncoder.encode(request.getParameter("word"), "utf-8");
			break;
			// 등급변경 서비스 -------------------------------------------------
		case "/member/changeGradeNo.do":
			// 세션가져오기
			session = request.getSession();
			MemberVO changeGradeNoVO = new MemberVO();
			// 등급번호 변환
			String gradeNoStr = request.getParameter("gradeNo");
			Integer gradeNo = Integer.parseInt(gradeNoStr);
			// 아이디,등급번호 세팅
			changeGradeNoVO.setId(request.getParameter("id"));
			changeGradeNoVO.setGradeNo(gradeNo);
			// vo에 저장
			request.setAttribute("vo", changeGradeNoVO);
			// 처리
			session.setAttribute("changeGradeNo", Execute.run(memberChangeGradeNoService, changeGradeNoVO));
			//관리자만 가능한 서비스 이므로 관리자 아이디 가져옴
			id = ((MemberVO) session.getAttribute("login")).getId();
			// 페이지 처리
			pageObject = PageObject.getInstance(request);
			request.setAttribute("pageObject", pageObject);
			// 리스트로 자동이동
			jsp = "redirect:list.do?id=" + id + "&page=" + request.getParameter("page") + "&perPageNum="
					+ request.getParameter("perPageNum") + "&key=" + request.getParameter("key") + "&word="
					+ URLEncoder.encode(request.getParameter("word"), "utf-8");

			break;
		default:
			throw new Exception("잘못된 페이지를 요청하셨습니다.");
		}
		return jsp;

	}

}
