package com.today.mymenu.service;

import com.today.main.ServiceInterface;
import com.today.mymenu.dao.MyMenuDAO;

public class MyMenuViewServiceImpl implements ServiceInterface {

	private MyMenuDAO dao;
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (MyMenuDAO)obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("MyMenuViewServiceImpl.service().no:"+obj);
		// TODO Auto-generated method stub
		
		return dao.view((long)obj);
	}

}
