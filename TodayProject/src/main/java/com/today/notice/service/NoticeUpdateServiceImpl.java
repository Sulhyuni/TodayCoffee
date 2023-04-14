package com.today.notice.service;

import com.today.main.ServiceInterface;
import com.today.notice.dao.NoticeDAO;
import com.today.notice.vo.NoticeVO;

public class NoticeUpdateServiceImpl implements ServiceInterface{

	
	//dao 선언
	private  NoticeDAO dao;
	//setter
	public void setDao(Object obj) {
		this.dao = (NoticeDAO)obj;
	}
	
	
	
	
	@Override
	//obj = Object[0] - no, object[1] - inc
	public Object service(Object obj) throws Exception {
		System.out.println("NoticeUpdateSerivceImpl.service().vo: " + obj);
		
		return dao.update((NoticeVO)obj);
		
		//null point exception 발생시 dao 에 저장된게 없다.
		//Init클래스에 조립이 잘되어있는지 다시 확인한다!
	}
	
	

}
