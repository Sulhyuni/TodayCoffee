package com.today.member.service;

import com.today.main.ServiceInterface;
import com.today.member.dao.MemberDAO;
import com.today.member.vo.MemberVO;

public class MemberCheckPwServiceImpl implements ServiceInterface {

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
		("MemberCheckPwServiceImpl.service().vo : " + obj);
		return dao.checkPw((MemberVO) obj);
	}

	
	
}
