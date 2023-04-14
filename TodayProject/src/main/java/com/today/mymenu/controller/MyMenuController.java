package com.today.mymenu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.today.main.Execute;
import com.today.main.ServiceInterface;
import com.today.member.vo.MemberVO;
import com.today.mymenu.vo.MyMenuVO;

public class MyMenuController {

	// private 변수로 MyMenuService
	private ServiceInterface mymenuListService;
	private ServiceInterface mymenuViewService;
	private ServiceInterface mymenuAddService;
	private ServiceInterface mymenuUpdateService;
	private ServiceInterface mymenuDeleteService;
	private ServiceInterface mymenuAllDeleteService;
	private ServiceInterface mymenuOptionAddService;
	private ServiceInterface mymenuOptionViewService;
	private ServiceInterface mymenuNoListService;

	// setter를 만들어 service를 받는다.
	public void setMyMenuListService(ServiceInterface mymenuListService) {
		this.mymenuListService = mymenuListService;
	}

	public void setMyMenuViewService(ServiceInterface mymenuViewService) {
		this.mymenuViewService = mymenuViewService;
	}

	public void setMyMenuAddService(ServiceInterface mymenuAddService) {
		this.mymenuAddService = mymenuAddService;
	}

	public void setMyMenuUpdateService(ServiceInterface mymenuUpdateService) {
		this.mymenuUpdateService = mymenuUpdateService;
	}

	public void setMyMenuDeleteService(ServiceInterface mymenuDeleteService) {
		this.mymenuDeleteService = mymenuDeleteService;
	}

	public void setMyMenuAllDeleteService(ServiceInterface mymenuAllDeleteService) {
		this.mymenuAllDeleteService = mymenuAllDeleteService;
	}

	public void setMyMenuOptionAddService(ServiceInterface mymenuOptionAddService) {
		this.mymenuOptionAddService = mymenuOptionAddService;
	}

	public void setMyMenuOptionViewService(ServiceInterface mymenuOptionViewService) {
		this.mymenuOptionViewService = mymenuOptionViewService;
	}
	public void setMyMenuNoListService(ServiceInterface mymenuNoListService) {
		this.mymenuNoListService = mymenuNoListService;
	}

	// 실행 메서드 -> 리턴 String 데이터를 jsp 또는 url 정보가 된다.
	public String execute(HttpServletRequest request) throws Exception {
		System.out.println("MyMenuController.execute().request : " + request);
		// 어떤 요청
		String uri = request.getRequestURI();
		String method = request.getMethod();
		System.out.println("MyMenuController.execute().method : " + method);
		// 세션 받아오기
		HttpSession session = request.getSession();
		String jsp = null;

		// 처리
		switch (uri) {
		case "/mymenu/list.do":// 리스트
			String lid = (((MemberVO) session.getAttribute("login")).getId());
			request.setAttribute("list", Execute.run(mymenuListService, lid));
			jsp = "mymenu/list";
			break;
		case "/mymenu/view.do":
			// 데이터 수집
			String noStr = request.getParameter("no");
			long no = Long.parseLong(noStr);
			System.out.println("no");
			// 데이터 처리
			MyMenuVO viewVO = (MyMenuVO) Execute.run(mymenuViewService, no);
			// 내용 줄바꿈 처리
			viewVO.setGoodsview(viewVO.getGoodsview().replace("\n", "<br/>"));
			request.setAttribute("vo", viewVO);
			jsp = "mymenu/view";
			break;
		case "/mymenu/add.do":
			MyMenuVO vo = new MyMenuVO();
			vo.setGoodsNo(Long.parseLong(request.getParameter("goodsNo")));
			String heating = request.getParameter("heating");
			if (heating != null) {// heating이 null이 아닌경우
				vo.setHeating(heating);
			} else {// heating이 null인 경우
				vo.setCup_size(request.getParameter("cup_size"));
				vo.setCup(request.getParameter("cup"));
				vo.setSyrup(request.getParameter("syrup"));
			} // end of else
			Execute.run(mymenuOptionAddService, vo);
			MyMenuVO opNo = new MyMenuVO();
			opNo = (MyMenuVO) Execute.run(mymenuOptionViewService, vo);
			vo.setOptionNo(opNo.getOptionNo());
			vo.setId(((MemberVO) session.getAttribute("login")).getId());
			vo.setMmName(request.getParameter("mmName"));
			long quantity = Long.parseLong(request.getParameter("quantity"));
			long orderPrice = Long.parseLong(request.getParameter("orderPrice"));
			vo.setTotalPrice(orderPrice/quantity);
			vo.setMmName("나만의 " + request.getParameter("name_kr"));
			Execute.run(mymenuAddService, vo);
			// 담기 서비스 실행
			request.setAttribute("vo", vo);
			// 나만의 메뉴 이동
			jsp = "redirect:list.do";
			break;
		case "/mymenu/update.do":
			// 데이터 수집
			long upNo = Long.parseLong(request.getParameter("no"));
			String mmName = request.getParameter("Name");
			// 수정 데이터 가져오기
			if (request.getMethod().equals("GET")) {
				request.setAttribute("vo", Execute.run(mymenuViewService, upNo));
				jsp = "mymenu/view";
			} else {
				MyMenuVO upVO = new MyMenuVO();
				// 데이터 수집 vo 넣기
				upVO.setMmNo(upNo);
				upVO.setMmName(mmName);
				upVO.setId(((MemberVO) session.getAttribute("login")).getId());
				Execute.run(mymenuUpdateService, upVO);
				jsp = "redirect:list.do";
			}
			break;
		case "/mymenu/delete.do":
		    // 데이터 수집
		    long deleteNo = Long.parseLong(request.getParameter("no"));
		    MyMenuVO deleteVO = new MyMenuVO();
		    deleteVO.setMmNo(deleteNo);
		    // DB처리
		    Execute.run(mymenuDeleteService, deleteVO);
		    jsp = "redirect:list.do";
		    break;
		case "/mymenu/alldelete.do":
			String id = request.getParameter("id");
			MyMenuVO delallVO = new MyMenuVO();
			delallVO.setId(((MemberVO) session.getAttribute("login")).getId());
			// DB 처리
			Execute.run(mymenuAllDeleteService, delallVO);
			jsp = "redirect:list.do";
			break;
		default:
			jsp = "redirect:/error/404.do";
			request.getSession().setAttribute("uri", uri);
		}// end of switch
		return jsp;
	}

}
