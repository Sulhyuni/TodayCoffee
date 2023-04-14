package com.today.order.service;

import com.today.main.ServiceInterface;
import com.today.order.dao.OrderDAO;

public class OrderViewServiceImpl implements ServiceInterface {

	private OrderDAO dao;
	@Override
	public void setDao(Object dao) {
		this.dao = (OrderDAO)dao;
	}

	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("OrderViewServiceImpl.service()");
		return dao.view((long)obj);
	}

}
