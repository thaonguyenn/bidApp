package org.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webproject.dao.BidSessionsDao;
import org.webproject.model.BidSessions;

@Service("bidSessionsService")
@Transactional
public class BidSessionsServiceImpl implements BidSessionsService{
	
	@Autowired
	private BidSessionsDao bidSessions;
	@Override
	public List<BidSessions> getListNotReadySession() {
		return bidSessions.getListNotReadySession();
	}

	@Override
	public void updateStatus(String idBidSession, int newStatus) {
		bidSessions.updateStatus(idBidSession, newStatus);
	}

	@Override
	public List<BidSessions> getListReadySession() {
		return bidSessions.getListReadySession();
	}

	@Override
	public List<BidSessions> getListOpeningSession() {
		return bidSessions.getListOpeningSession();
	}

	@Override
	public BidSessions getDetailBidSession(String idSession) {
		return bidSessions.getDetailBidSession(idSession);
	}

	@Override
	public BidSessions getBidSessionByIdSessionIdProduct(String idSession, String idProduct) {
		return bidSessions.getBidSessionByIdSessionIdProduct(idSession, idProduct);
	}

	@Override
	public void updateCountdown(int number, String idSession) {
		bidSessions.updateCountdown(number, idSession);
	}

	@Override
	public void establishCountdown(String idSession) {
		bidSessions.establishCountdown(idSession);
	}

	@Override
	public void createSession(BidSessions sess) {
		bidSessions.createSession(sess);
	}

}
