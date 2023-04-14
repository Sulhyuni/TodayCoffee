package com.today.member.service;

import java.sql.Date;

import com.today.main.ServiceInterface;
import com.today.member.dao.MemberDAO;

public class MemberSleepServiceImpl implements ServiceInterface {
	
	private MemberDAO dao;

	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (MemberDAO)obj;
		System.out.println(dao);
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println
		("MemberSleepServiceImpl.service().vo : " + obj);
		System.out.println(dao);
		return dao.sleep((Date) obj);
		
	}

}
