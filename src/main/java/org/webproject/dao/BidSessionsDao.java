package org.webproject.dao;

import java.util.List;

import org.webproject.model.BidSessions;

public interface BidSessionsDao {
	public List<BidSessions> getListNotReadySession();
	public void updateStatus(String idBidSession, int newStatus);
	public List<BidSessions> getListReadySession();
	public List<BidSessions> getListOpeningSession();
	public BidSessions getDetailBidSession(String idSession);
	public BidSessions getBidSessionByIdSessionIdProduct(String idSession,String idProduct);
	public void updateCountdown(int number, String idSession);
	public void establishCountdown(String idSession);
	public void createSession(BidSessions session);
}
