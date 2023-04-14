package com.today.member.service;

import com.today.main.ServiceInterface;
import com.today.member.dao.MemberDAO;

public class MemberCheckIdServiceImpl implements ServiceInterface{

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
		String id = (String) obj;
		System.out.println("MemberCheckIdServiceImpl.service().id : " + id );
		return dao.checkId(id);
	}


}
