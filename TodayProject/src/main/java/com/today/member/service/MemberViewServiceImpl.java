package com.today.member.service;

import com.today.main.ServiceInterface;
import com.today.member.dao.MemberDAO;

public class MemberViewServiceImpl implements ServiceInterface{

	// dao 선언
	private MemberDAO dao;
	// setter
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (MemberDAO)obj;
	}
	
	@Override
	// obj = Object[0] - no, Object[1] - inc
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Object[] objs = (Object[])obj;
		String id = (String)objs[0];
		System.out.println
		("MemberViewServiceImpl.service().id : " + id );
		return dao.view(id);
	}


}
