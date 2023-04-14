package com.today.cart.service;

import com.today.cart.dao.CartDAO;
import com.today.main.ServiceInterface;

public class CartListServiceImpl implements ServiceInterface {

	// dao 선언
	private CartDAO dao;
	
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (CartDAO)obj;
		
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CartListServiceImpl.service()");
		return dao.list((String)obj);
	}

}
