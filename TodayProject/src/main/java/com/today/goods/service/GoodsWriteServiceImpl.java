package com.today.goods.service;

import com.today.goods.dao.GoodsDAO;
import com.today.goods.vo.GoodsVO;
import com.today.main.ServiceInterface;

public class GoodsWriteServiceImpl implements ServiceInterface{

	//dao 선언
	private GoodsDAO dao;
	@Override
	public void setDao(Object obj) {
		this.dao=(GoodsDAO)obj;
	}

	
	
	@Override
	public Object service(Object obj) throws Exception {
		System.out.println("GoodsWriteServiceImpl.service().vo: " + obj);
		return dao.write((GoodsVO) obj);
	}

	
}
