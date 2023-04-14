package com.today.order.service;

import com.today.main.ServiceInterface;
import com.today.order.dao.OrderDAO;
import com.webjjang.util.PageObject;

public class OrderPerListServiceImpl implements ServiceInterface {

	private OrderDAO dao;
	@Override
	public void setDao(Object obj) {
		this.dao = (OrderDAO)obj;

	}

	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("OrderPerListServiceImpl.service()");
		Object[] args = (Object[]) obj;
		String id = (String) args[0];
		PageObject pageObject = (PageObject) args[1];
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		return dao.perList(pageObject, id);
	}
}
