package com.today.cart.service;

import com.today.cart.dao.CartDAO;
import com.today.cart.vo.CartVO;
import com.today.main.ServiceInterface;

public class CartOptionAddServiceImpl implements ServiceInterface {

	private CartDAO dao;
	
	@Override
	public void setDao(Object dao) {
		this.dao = (CartDAO)dao;

	}

	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("OrderOptionAddServiceImpl.service().vo : " + obj);
		return dao.optionAdd((CartVO)obj);
	}

}
