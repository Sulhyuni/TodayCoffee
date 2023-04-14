package com.today.event.service;


import com.today.main.ServiceInterface;
import com.today.event.dao.EventDAO;
import com.webjjang.util.PageObject;

public class EventUserApplyListServiceImpl implements ServiceInterface{

	
	//dao 선언
	private  EventDAO dao;
	//setter
	public void setDao(Object obj) {
		this.dao = (EventDAO)obj;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("EventUserApplyListSerivceImpl.service()");
		
	
		
		
		return dao.userApplyList((String) obj);
		//null point exeception 발생시 dao 에 저장된게 없다.
		//Init클래스에 조립이 잘되어있는지 다시 확인한다!
	}
	
	

}
