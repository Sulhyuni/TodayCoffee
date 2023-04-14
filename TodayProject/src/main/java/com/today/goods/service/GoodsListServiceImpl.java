package com.today.goods.service;

import com.today.goods.dao.GoodsDAO;
import com.today.main.ServiceInterface;
import com.webjjang.util.PageObject;

public class GoodsListServiceImpl implements ServiceInterface	{

	//dao선언
	private GoodsDAO dao;
	//setter. 리턴타입void	
	public void setDao(Object dao) {
		this.dao = (GoodsDAO) dao;
	}

	@Override
	//serviceInterface 클래스와 동일
	public Object service(Object obj) throws Exception {
		System.out.println("GoodsListServiceImpl.service()......");
		PageObject pageObject = (PageObject) obj;
		
		//jsp를 위한 페이지 계산을 진행해야 함. -> 전체 데이터를 가져와서 setTotalRow()을 호출한다.
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		
		return dao.list(pageObject);
	}

}
