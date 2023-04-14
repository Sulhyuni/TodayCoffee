package com.today.order.service;

import com.today.main.ServiceInterface;
import com.today.order.dao.OrderDAO;
import com.today.order.vo.OrderVO;

public class OrderWriteServiceImpl implements ServiceInterface {

	private OrderDAO dao;
	@Override
	public void setDao(Object dao) {
		this.dao = (OrderDAO)dao;
	}

	@Override
	public Object service(Object obj) throws Exception {
		OrderVO vo = (OrderVO) obj;
		dao.write((OrderVO)obj);
		long orderNo = dao.findOrderNo(vo.getId());
		for (OrderVO o : vo.getList()) {
			o.setOrderNo(orderNo);
			dao.writeDetail(o);
		}
		return 1;
	}
}
