package com.today.event.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.today.event.vo.EventVO;
import com.today.main.Execute;
import com.today.main.ServiceInterface;
import com.today.member.vo.MemberVO;
import com.webjjang.util.PageObject;



public class EventController {

//null point 뜨면 Init 클래스를 다시 확인하자
	
	//private 변수로 EventListService, view , update...선언
	private ServiceInterface eventListService;
	private ServiceInterface eventReservedListService;
	private ServiceInterface eventLastListService;
	private ServiceInterface eventCurrentListService;
	private ServiceInterface eventViewService;
	private ServiceInterface eventWriteService;
	private ServiceInterface eventUpdateService;
	private ServiceInterface eventDeleteService;
	private ServiceInterface eventApplyListService;
	private ServiceInterface eventApplyWriteService;
	private ServiceInterface eventApplyUpdateService;
	private ServiceInterface eventUserApplyListService;
	
	
	//setter를 만들어서 생성된 service 를 받는다.
	public void setEventListService(ServiceInterface eventListService) {
		this.eventListService = eventListService;
	}
	public void setEventViewService(ServiceInterface eventViewService) {
		this.eventViewService = eventViewService;
	}
	public void setEventWriteService(ServiceInterface eventWriteService) {
		this.eventWriteService = eventWriteService;
	}
	public void setEventUpdateService(ServiceInterface eventUpdateService) {
		this.eventUpdateService = eventUpdateService;
	}
	public void setEventDeleteService(ServiceInterface eventDeleteService) {
		this.eventDeleteService = eventDeleteService;
	}
	public void setEventReservedListService(ServiceInterface eventReservedListService) {
		this.eventReservedListService = eventReservedListService;
	}
	public void setEventLastListService(ServiceInterface eventLastListService) {
		this.eventLastListService = eventLastListService;
	}
	public void setEventCurrentListService(ServiceInterface eventCurrentListService) {
		this.eventCurrentListService = eventCurrentListService;
	}
	
	public void setEventApplyWriteService(ServiceInterface eventApplyWriteService) {
		this.eventApplyWriteService = eventApplyWriteService;
	}
	public void setEventApplyListService(ServiceInterface eventApplyListService) {
		this.eventApplyListService = eventApplyListService;
	}
	public void setEventApplyUpdateService(ServiceInterface eventApplyUpdateService) {
		this.eventApplyUpdateService = eventApplyUpdateService;
	}
	public void setEventUserApplyListService(ServiceInterface eventUserApplyListService) {
		this.eventUserApplyListService = eventUserApplyListService;
	}
	//실행메서드- return 되는 String데이터는 jsp 또는 url 정보.
	public String execute(HttpServletRequest request) throws Exception{
		System.out.println("EventController.execute().request : " + request);
		//어떤 요청
		String uri = request.getRequestURI();
		String method = request.getMethod();
		System.out.println("EventController.method()"+method);
		String jsp = null;
		// 세션 받아오기
		HttpSession session = request.getSession();
				
		switch (uri) {
		case "/event/list.do":	
			//id는 session에 담겨져 있다.
			//관리자는 모든 글을, 그 외에 이용자들은 현재 이벤트만
			PageObject pageObject = PageObject.getInstance(request);
			MemberVO loginVO =((MemberVO)session.getAttribute("login"));
			if(session.getAttribute("login") == null || loginVO.getGradeNo() == 1) {
				request.setAttribute("list", Execute.run(eventCurrentListService, pageObject));		
			} else if (loginVO.getGradeNo() == 9) {
				request.setAttribute("list", Execute.run(eventListService, pageObject));		
			}
			//jsp - list 데이터 아래의 페이지 네비게이션을 위한 데이터 저장
			request.setAttribute("pageObject", pageObject);
			jsp = "event/list";
			break;
		
		case "/event/applyList.do":	
			//회원 - 이벤트 응모 현황list 보기
			//관리자 - 모든 회원의 응모 현황 list 보기
			//id는 session에 담겨져 있다.
			pageObject = PageObject.getInstance(request);
			loginVO =((MemberVO)session.getAttribute("login"));
			String loginId= loginVO.getId();
			if(session.getAttribute("login") != null && loginVO.getGradeNo() == 1) {
				request.setAttribute("list", Execute.run(eventUserApplyListService, loginId));		
			} else if (loginVO.getGradeNo() == 9) {
				request.setAttribute("list", Execute.run(eventApplyListService, null));		
			}
			request.setAttribute("pageObject", pageObject);
			jsp = "event/applyList";
			break;
			
		case "/event/applyWrite.do":	
			//회원 - 이벤트 응모하기
			if(request.getMethod().equals("GET")) {
				jsp = "event/applyWrite";
			}else {
				// post방식
				//데이터 수집 
				EventVO applyWriteVO = new EventVO();
				long eventNo = Long.parseLong(request.getParameter("eventNo"));
				applyWriteVO.setEventNo(eventNo);
				applyWriteVO.setId(request.getParameter("id"));
				applyWriteVO.setWin(request.getParameter("win"));
				
				Execute.run(eventApplyWriteService, applyWriteVO);
				jsp = "redirect:applyList.do";
			}
			break;


		case "/event/view.do":		
			//no 는 request에서 넘어온다.
			//데이터 수집 
			long no = Long.parseLong( request.getParameter("no"));
			int inc = Integer.parseInt(request.getParameter("inc"));
			//데이터 처리 -> request에 담는다. -> jsp에서 꺼내쓴다.
			EventVO viewVO = (EventVO)Execute.run(eventViewService, new Object[] {no,inc});
			
			//내용 줄바꿈 처리
			viewVO.setContent(viewVO.getContent().replace("\r\n","<br/>"));
			
			//응모
			MemberVO idVO = (MemberVO) session.getAttribute("login");
			request.setAttribute("idvo", idVO);
			request.setAttribute("vo",viewVO);
			jsp = "event/view";
			break;
			
		case "/event/write.do":	
			//writeForm으로 // get방식
			if(request.getMethod().equals("GET")) {
				jsp = "event/write";
			}else {
				// post방식
				//페이지 데이터 수집--perPageNumStr 을 url 뒤에 바로 붙여서 사용하자.
				//String perPageNumStr = request.getParameter("perPageNum");
				//데이터 수집 
				EventVO writeVO = new EventVO();
				writeVO.setTitle(request.getParameter("title"));
				writeVO.setContent(request.getParameter("content"));
				writeVO.setStartDate(request.getParameter("startDate"));
				writeVO.setEndDate(request.getParameter("endDate"));
				writeVO.setUpdateDate(request.getParameter("updateDate"));
				
				Execute.run(eventWriteService, writeVO);
				jsp = "redirect:list.do?perPageNum="+request.getParameter("perPageNum");
			}
			break;
			
		case "/event/update.do":	
			//관리자-이벤트게시판 글수정
			long updateNo = Long.parseLong(request.getParameter("no"));
			//updateVO 변수 생성 후 뷰서비스에서 번호를 가져온다.
			if(request.getMethod().equals("GET")) {
				//데이터처리 -> request에 담는다.
				request.setAttribute("vo", Execute.run(eventViewService,  new Object[] {updateNo, 0}));
				jsp = "event/update";
			}else {// post방식
				EventVO updateVO = new EventVO();
				//데이터 수집 - > 후에 조립 해야햄 Init
				updateVO.setEventNo(updateNo);
				updateVO.setTitle(request.getParameter("title"));
				updateVO.setContent(request.getParameter("content"));
				updateVO.setStartDate(request.getParameter("startDate"));
				updateVO.setEndDate(request.getParameter("endDate"));
				//updateVO.setUpdateDate(request.getParameter("updateDate"));
			
				//DB처리
				Execute.run(eventUpdateService, updateVO);
				jsp = "redirect:view.do?no=" +updateNo +"&inc=0" 
				+ "&page=" + request.getParameter("page") 
				+ "&perPageNum=" + request.getParameter("perPageNum")
				+ "&key=" + request.getParameter("key")
				+ "&word=" + URLEncoder.encode(request.getParameter("word"),"utf-8");
			}
			
			
			break;
			
		case "/event/applyUpdate.do":
			//관리자- 회원 응모 리스트 당첨여부 변경하기
			EventVO upVO = new EventVO();
			upVO.setWinNo(Long.parseLong(request.getParameter("winNo")));
			System.out.println("upVO.setWinNo : " +upVO.getWinNo());
			upVO.setWin(request.getParameter("winStatus"));
			System.out.println("upVO.setWin : " +upVO.getWin());
			Execute.run(eventApplyUpdateService, upVO);
			jsp = "redirect:applyList.do";
			
			break;
		case "/event/delete.do":			
			//데이터 수집 - 글번호, 비밀번호 수집
			long deleteNo = Long.parseLong(request.getParameter("no"));
			
			EventVO deleteVO = new EventVO();
			deleteVO.setEventNo(deleteNo);
			
			//DB삭제 처리
			Execute.run(eventDeleteService, deleteVO);
			jsp = "redirect:list.do?perPageNum=" + request.getParameter("perPageNum");
			break;
		

		default:
			throw new Exception("잘못된 페이지를 요청하였습니다.");
			
		}		
		return jsp;
	}
}
