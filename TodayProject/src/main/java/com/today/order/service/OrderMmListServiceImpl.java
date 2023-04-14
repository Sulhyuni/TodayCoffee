package com.today.order.service;

import java.util.List;

import com.today.main.ServiceInterface;
import com.today.order.dao.OrderDAO;

public class OrderMmListServiceImpl implements ServiceInterface {

	private OrderDAO dao;
	@Override
	public void setDao(Object dao) {
		this.dao = (OrderDAO)dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("OrderViewServiceImpl.service()");
		return dao.mmList((List<Long>) obj);
	}

}
