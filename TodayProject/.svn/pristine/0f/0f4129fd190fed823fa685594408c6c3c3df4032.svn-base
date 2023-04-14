package com.today.cart.service;

import java.util.List;

import com.today.cart.dao.CartDAO;
import com.today.main.ServiceInterface;

public class CartNoListServiceImpl implements ServiceInterface {

	private CartDAO dao;
	@Override
	public void setDao(Object dao) {
		this.dao = (CartDAO)dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("CartViewServiceImpl.service()");
		return dao.cartList((List<Long>) obj);
	}

}
