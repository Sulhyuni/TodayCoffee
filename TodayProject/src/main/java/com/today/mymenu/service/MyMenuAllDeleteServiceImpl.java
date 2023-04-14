package com.today.mymenu.service;

import com.today.mymenu.dao.MyMenuDAO;
import com.today.mymenu.vo.MyMenuVO;
import com.today.main.ServiceInterface;

public class MyMenuAllDeleteServiceImpl implements ServiceInterface {

	private MyMenuDAO dao;
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (MyMenuDAO)obj;
		
	}

	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("MyMenuAllDeleteServiceImpl.service()");
		// TODO Auto-generated method stub
		return dao.Alldelete((MyMenuVO)obj);
	}

}