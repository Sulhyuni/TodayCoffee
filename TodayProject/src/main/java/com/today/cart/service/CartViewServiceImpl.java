package com.today.cart.service;

import com.today.cart.dao.CartDAO;
import com.today.main.ServiceInterface;

public class CartViewServiceImpl implements ServiceInterface{

	private CartDAO dao;
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (CartDAO)obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("CartViewServiceImpl.service().no:"+obj);
		// TODO Auto-generated method stub
		
		return dao.view((long)obj);
	}

}
