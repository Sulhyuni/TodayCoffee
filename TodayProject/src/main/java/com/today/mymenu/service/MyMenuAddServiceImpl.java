package com.today.mymenu.service;

import com.today.mymenu.dao.MyMenuDAO;
import com.today.mymenu.vo.MyMenuVO;
import com.today.main.ServiceInterface;

public class MyMenuAddServiceImpl implements ServiceInterface {

	private MyMenuDAO dao;
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (MyMenuDAO)obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyMenuAddServiceImpl.service()");
		return dao.mymenuAdd((MyMenuVO)obj);
	}
	

}
