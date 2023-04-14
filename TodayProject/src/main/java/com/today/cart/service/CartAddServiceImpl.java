package com.today.cart.service;

import com.today.cart.dao.CartDAO;
import com.today.cart.vo.CartVO;
import com.today.main.ServiceInterface;

public class CartAddServiceImpl implements ServiceInterface{

	private CartDAO dao;
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (CartDAO)obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CartAddServiceImpl.service()");
		return dao.cartAdd((CartVO)obj);
	}
	

}
