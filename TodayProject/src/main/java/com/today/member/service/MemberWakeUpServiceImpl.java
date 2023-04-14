package com.today.member.service;

import com.today.main.ServiceInterface;
import com.today.member.dao.MemberDAO;
import com.today.member.vo.MemberVO;

public class MemberWakeUpServiceImpl implements ServiceInterface {
	
	private MemberDAO dao;

	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (MemberDAO)obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("MemberWakeUpServiceImpl.service().vo : " + obj);
		return dao.wakeUp((MemberVO) obj);
		
	}

}
