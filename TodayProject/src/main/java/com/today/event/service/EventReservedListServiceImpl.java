package com.today.event.service;


import com.today.main.ServiceInterface;
import com.today.event.dao.EventDAO;
import com.webjjang.util.PageObject;

public class EventReservedListServiceImpl implements ServiceInterface{

	
	//dao 선언
	private  EventDAO dao;
	//setter
	public void setDao(Object obj) {
		this.dao = (EventDAO)obj;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("EventReservedListSerivceImpl.service()");
		PageObject pageObject = (PageObject) obj;
		
		//jsp를 위한 페이지 계산을 진행해야 함. -> 전체 데이터를 가져와서 setTotalRow()을 호출한다.
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		
		return dao.reservedList(pageObject);
		//null point exeception 발생시 dao 에 저장된게 없다.
		//Init클래스에 조립이 잘되어있는지 다시 확인한다!
	}
	
	

}
