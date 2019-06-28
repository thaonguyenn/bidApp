package org.webproject.service;

import java.util.List;

import org.webproject.model.BidSessions;
import org.webproject.model.Customer;
import org.webproject.model.SessionItems;

public interface SessionItemsService {
	public List<SessionItems> getItemsByIdSession(String idSession);
	public void addItem(BidSessions session, Customer customer, double money);
	List<SessionItems> getSessionItem();
}
