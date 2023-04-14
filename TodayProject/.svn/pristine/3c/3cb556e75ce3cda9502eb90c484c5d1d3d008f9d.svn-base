package com.today.event.service;

import com.today.main.ServiceInterface;
import com.today.event.dao.EventDAO;
import com.today.event.vo.EventVO;

public class EventApplyWriteServiceImpl implements ServiceInterface{

	
	//dao 선언
	private  EventDAO dao;
	//setter
	public void setDao(Object obj) {
		this.dao = (EventDAO)obj;
	}
	
	
	
	
	@Override
	//obj = Object[0] - no, object[1] - inc
	public Object service(Object obj) throws Exception {
		System.out.println("EventApplyWriteSerivceImpl.service().vo: " + obj);
		
		return dao.applyWrite((EventVO)obj);
		
		//null point exception 발생시 dao 에 저장된게 없다.
		//Init클래스에 조립이 잘되어있는지 다시 확인한다!
	}
	
	

}
