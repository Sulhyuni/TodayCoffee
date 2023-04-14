package com.today.mymenu.service;

import com.today.main.ServiceInterface;
import com.today.mymenu.dao.MyMenuDAO;

public class MyMenuListServiceImpl implements ServiceInterface {

	private MyMenuDAO dao;
	@Override
	public void setDao(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (MyMenuDAO)dao;
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MymenuListServiceImpl.service()");
		return dao.list((String)obj);
	}

}
