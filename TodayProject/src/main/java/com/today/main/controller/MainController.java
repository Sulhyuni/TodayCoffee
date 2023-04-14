package com.today.main.controller;

import javax.servlet.http.HttpServletRequest;

import com.today.main.Execute;
import com.today.main.ServiceInterface;
import com.webjjang.util.PageObject;

public class MainController {

	// 리스트만 가져오는 서비스 변수 지정
	private ServiceInterface noticeListService;
	private ServiceInterface eventListService;
	private ServiceInterface goodsListService;
	
	// setter -> 조립은 init 클래스에서 한다. (안하면 NullPointException 발생)
	public void setNoticeListService(ServiceInterface noticeListService) {
		this.noticeListService = noticeListService;
	}
	
	public void setEventListService(ServiceInterface eventListService) {
		this.eventListService = eventListService;
	}
	
	public void setGoodsListService(ServiceInterface goodsListService) {
		this.goodsListService = goodsListService;
	}
	
	
	public String execute(HttpServletRequest request) throws Exception {
		String jsp ="main/main";
		
		// 메인에 표시할 공지사항과 게시판의 페이지(1)와 데이터 갯수(5)
		PageObject pageObject = new PageObject(1, 5); // 1페이지에 있는 데이터 5개만 가져온다.
		request.setAttribute("noticeList", Execute.run(noticeListService, pageObject));
		request.setAttribute("eventList", Execute.run(eventListService, pageObject));
		
		// 메인에 표시할 이미지의 데이터 갯수(4)
		pageObject.setPerPageNum(4);
		request.setAttribute("goodsList", Execute.run(goodsListService, pageObject));
		
		return jsp;
	}

}
