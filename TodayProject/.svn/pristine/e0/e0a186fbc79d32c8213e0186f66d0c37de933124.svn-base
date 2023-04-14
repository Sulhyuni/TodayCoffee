package com.today.order.service;

import java.util.List;

import com.today.main.ServiceInterface;
import com.today.order.dao.OrderDAO;

public class OrderCartDeleteServiceImpl implements ServiceInterface {

	private OrderDAO dao;
	@Override
	public void setDao(Object dao) {
		this.dao = (OrderDAO)dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("OrderCartDeleteServiceImpl.service()");
		return dao.cartDelete((List<Long>) obj);
	}

}
