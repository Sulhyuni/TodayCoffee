package com.today.order.service;

import com.today.main.ServiceInterface;
import com.today.order.dao.OrderDAO;
import com.today.order.vo.OrderVO;

public class OrderOptionViewServiceImpl implements ServiceInterface {

	private OrderDAO dao;
	@Override
	public void setDao(Object dao) {
		this.dao = (OrderDAO)dao;
	}

	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("OrderOptionViewServiceImpl.service()");
		return dao.optionView((OrderVO)obj);
	}

}
