package com.today.member.service;

import com.today.main.ServiceInterface;
import com.today.member.dao.MemberDAO;
import com.today.member.vo.MemberVO;

public class MemberLoginServiceImpl implements ServiceInterface {

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
		System.out.println
		("MemberLoginServiceImpl.service().vo : " + obj);
		MemberVO login = (MemberVO) obj;
		if(dao.updateConDate(login.getId())==1) {
		return dao.login((MemberVO) obj);
		}return null;
	}

	
	
}
