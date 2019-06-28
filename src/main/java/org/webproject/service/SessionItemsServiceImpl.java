package org.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webproject.dao.SessionItemsDao;
import org.webproject.model.BidSessions;
import org.webproject.model.Customer;
import org.webproject.model.SessionItems;

@Service("itemsService")
@Transactional
public class SessionItemsServiceImpl implements SessionItemsService{

	@Autowired
	private SessionItemsDao itemDao;
	@Override
	public List<SessionItems> getItemsByIdSession(String idSession) {
		return itemDao.getItemsByIdSession(idSession);
	}
	@Override
	public void addItem(BidSessions session, Customer customer, double money) {
		itemDao.addItem(session, customer, money);
	}
	@Override
	public List<SessionItems> getSessionItem() {
		return itemDao.getSessionItem();
	}

}
