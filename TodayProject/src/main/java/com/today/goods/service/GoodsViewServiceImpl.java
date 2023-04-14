package com.today.goods.service;

import com.today.goods.dao.GoodsDAO;
import com.today.main.ServiceInterface;

public class GoodsViewServiceImpl implements ServiceInterface {

	//dao 선언
	private GoodsDAO dao;
	
	//setter
	@Override
	public void setDao(Object obj) {
		this.dao = (GoodsDAO)obj;
		
	}

	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("GoodsViewSerivceImpl.service() no :" +obj);
		return dao.view((Long)obj);
	}

}
