package org.webproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webproject.dao.OrdersDAO;
import org.webproject.model.Orders;

@Service("OrdersService")
@Transactional
public class OrdersDAOImpl implements OrdersService{
	@Autowired
	private OrdersDAO dao;

	@Override
	public void saveOrders(Orders order) {
	dao.saveOrders(order);
		
	}

}
