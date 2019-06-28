package org.webproject.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webproject.model.BidSessions;

@Repository("bidSessionsDao")
public class BidSessionDaoImpl implements BidSessionsDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<BidSessions> getListNotReadySession() {
		Session session = sessionFactory.openSession();
		List<BidSessions> list = new ArrayList<BidSessions>();
		 Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	        
			Query q = session.createQuery(" from BidSessions where PresentStatus = 1");
	         @SuppressWarnings("rawtypes")
	         List qu = q.list();
	         for (@SuppressWarnings("rawtypes")
			Iterator iterator = qu.iterator(); iterator.hasNext();){
	        	 BidSessions bidSession = (BidSessions) iterator.next();
	            list.add(bidSession);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return list;
	}
	
	@Override
	public List<BidSessions> getListReadySession() {
		Session session = sessionFactory.openSession();
		List<BidSessions> list = new ArrayList<BidSessions>();
		 Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	        
			Query q = session.createQuery(" from BidSessions where PresentStatus = 2");
	         @SuppressWarnings("rawtypes")
	         List qu = q.list();
	         for (@SuppressWarnings("rawtypes")
			Iterator iterator = qu.iterator(); iterator.hasNext();){
	        	 BidSessions bidSession = (BidSessions) iterator.next();
	            list.add(bidSession);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return list;
	}

	@Override
	public void updateStatus(String idBidSession, int newStatus) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("update BidSessions set PresentStatus = :newStatus where SessionID = :idBidSession");
		query.setString("idBidSession", idBidSession);
		query.setInteger("newStatus", newStatus);
		query.executeUpdate();
	}

	@Override
	public List<BidSessions> getListOpeningSession() {
		Session session = sessionFactory.openSession();
		List<BidSessions> list = new ArrayList<BidSessions>();
		 Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	        
			Query q = session.createQuery(" from BidSessions where PresentStatus = 3");
	         @SuppressWarnings("rawtypes")
	         List qu = q.list();
	         for (@SuppressWarnings("rawtypes")
			Iterator iterator = qu.iterator(); iterator.hasNext();){
	        	 BidSessions bidSession = (BidSessions) iterator.next();
	            list.add(bidSession);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return list;
	}

	@Override
	public BidSessions getDetailBidSession(String idSession) {
		Session session = sessionFactory.openSession();
		BidSessions bidSession = new BidSessions();
		 Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	        
			Query q = session.createQuery(" from BidSessions where SessionID = '" + idSession +"'");
	         @SuppressWarnings("rawtypes")
	         List qu = q.list();
	         for (@SuppressWarnings("rawtypes")
			Iterator iterator = qu.iterator(); iterator.hasNext();){
	        	 bidSession = (BidSessions) iterator.next();
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return bidSession;
	}

	@Override
	public BidSessions getBidSessionByIdSessionIdProduct(String idSession, String idProduct) {
		Session session = sessionFactory.openSession();
		BidSessions bidSession = new BidSessions();
		 Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	        
			Query q = session.createQuery(" from BidSessions where SessionID = '" + idSession +"' and product.idProduct = '" + idProduct +"'");
	         @SuppressWarnings("rawtypes")
	         List qu = q.list();
	         for (@SuppressWarnings("rawtypes")
			Iterator iterator = qu.iterator(); iterator.hasNext();){
	        	 bidSession = (BidSessions) iterator.next();
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return bidSession;
	}

	@Override
	public void updateCountdown(int number, String idSession) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("update BidSessions set countdown = :countdown where SessionID = :idSession");
		query.setInteger("countdown", number);
		query.setString("idSession", idSession);
		query.executeUpdate();
	}

	@Override
	public void establishCountdown(String idSession) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("update BidSessions set countdown = 10 where SessionID = '" + idSession + "'");
		query.executeUpdate();
	}

	@Override
	public void createSession(BidSessions sess) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String day = dateFormat.format(date).replace("-", "");
			long totalRecord = getTotalSessions();
			long nextID = totalRecord + 1;
			String full = fullString(nextID, 5);
			String id = day + "BS" + full;
			sess.setSessionID(id);
			sess.setPresentStatus(1);
			sess.setCountdown(10);
			session.save(sess);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	private long getTotalSessions() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		long result = 0;
		try {
			tx = session.beginTransaction();
			List accounts = session.createQuery("select count (*) FROM BidSessions").list();
			for (Iterator iterator = accounts.iterator(); iterator.hasNext();) {
				result = (long) iterator.next();
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	private String fullString(long number, int len) {
		String num = number + "";
		while (num.length() < len) {
			num = "0" + num;
		}
		return num;
	}

}
