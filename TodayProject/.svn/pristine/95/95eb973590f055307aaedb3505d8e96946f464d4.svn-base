package com.today.member.service;

import com.today.main.ServiceInterface;
import com.today.member.dao.MemberDAO;
import com.webjjang.util.PageObject;

public class MemberListServiceImpl implements ServiceInterface{

	// dao 선언
	private MemberDAO dao;
	// setter
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (MemberDAO)obj;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberListServiceImpl.service()");
		
		PageObject pageObject = (PageObject) obj;
		
		// JSP를 위한 페이지 계산을 진행해야 한다. -> 전체 데이터를 가져와서 setTotalRow() 호출
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		
		return dao.list(pageObject);
	}


}
