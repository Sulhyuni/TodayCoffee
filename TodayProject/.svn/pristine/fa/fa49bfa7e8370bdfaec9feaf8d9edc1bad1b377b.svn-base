package com.today.mymenu.service;

import java.util.List;

import com.today.main.ServiceInterface;
import com.today.mymenu.dao.MyMenuDAO;

public class MyMenuNoListServiceImpl implements ServiceInterface {

	private MyMenuDAO dao;
	@Override
	public void setDao(Object dao) {
		this.dao = (MyMenuDAO)dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("MyMenuViewServiceImpl.service()");
		return dao.myMenuList((List<Long>) obj);
	}

}
