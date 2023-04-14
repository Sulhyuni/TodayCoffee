package com.today.mymenu.service;


import com.today.main.ServiceInterface;
import com.today.mymenu.dao.MyMenuDAO;
import com.today.mymenu.vo.MyMenuVO;

public class MyMenuOptionAddServiceImpl implements ServiceInterface {
	private MyMenuDAO dao;
	
	@Override
	public void setDao(Object dao) {
		this.dao = (MyMenuDAO)dao;

	}

	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("OrderOptionAddServiceImpl.service().vo : " + obj);
		return dao.optionAdd((MyMenuVO)obj);
	}

}