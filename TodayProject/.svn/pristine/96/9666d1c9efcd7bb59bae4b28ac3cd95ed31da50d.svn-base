package com.today.notice.service;


import com.today.main.ServiceInterface;
import com.today.notice.dao.NoticeDAO;

public class NoticeViewServiceImpl implements ServiceInterface{

	
	//dao 선언
	private  NoticeDAO dao;
	//setter
	public void setDao(Object obj) {
		this.dao = (NoticeDAO)obj;
	}
	
	
	
	
	@Override
	public Object service(Object obj) throws Exception {
		
		Object[] objs = (Object[])obj;
		long no = (Long)objs[0];
		int inc = (Integer)objs[1];
		System.out.println("NoticeViewSerivceImpl.service().no : " +no +"/"+inc);
		
		//조회수 증가
		if(inc==1)dao.increase(no);
		
		return dao.view(no);
		
		//null point exeception 발생시 dao 에 저장된게 없다.
		//Init클래스에 조립이 잘되어있는지 다시 확인한다!
	}
	
	

}
