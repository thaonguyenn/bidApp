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
import org.webproject.model.Customer;
import org.webproject.model.SessionItems;

@Repository("itemsDao")
public class SessionItemsDaoImpl implements SessionItemsDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<SessionItems> getItemsByIdSession(String idSession) {
		Session session = sessionFactory.openSession();
		List<SessionItems> list = new ArrayList<SessionItems>();
		 Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	        
			Query q = session.createQuery(" from SessionItems where SessionID = '" + idSession +"' order by price DESC");
	         @SuppressWarnings("rawtypes")
	         List qu = q.list();
	         for (@SuppressWarnings("rawtypes")
			Iterator iterator = qu.iterator(); iterator.hasNext();){
	        	 SessionItems bidSession = (SessionItems) iterator.next();
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
	public void addItem(BidSessions sessionn, Customer customer, double money) {
		SessionItems item = new SessionItems();
		String idAuto = generateIdAuto();
		item.setItemID(idAuto);
		item.setBidsessions(sessionn);
		item.setCustomer(customer);
		item.setItemTime(new Date());
		item.setPrice(money);
		Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         session.save(item); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	public long getTotalRecord () {
		Session session = sessionFactory.openSession();
		long total = 0;
		 Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	        
			Query q = session.createQuery("select count(*) from SessionItems");
	         @SuppressWarnings("rawtypes")
	         List qu = q.list();
	         for (@SuppressWarnings("rawtypes")
			Iterator iterator = qu.iterator(); iterator.hasNext();){
	        total = (long) iterator.next();   
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return total;
	}
	public String generateIdAuto () {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String day = dateFormat.format(date).replace("-", "");
		long totalRecord = getTotalRecord();//get dao
		long nextID = totalRecord+1;
		String full = fullString(nextID,5);
		String id = day + "SI" + full;
		return id;
	}
	
	public String fullString(long number, int len) {
		String num = number+"";
		while(num.length() < len) {
			num = "0"+num;
		}
		return num;
	}
	@Override
	public List<SessionItems> getSessionItem() {
		Session session = sessionFactory.openSession();
		List<SessionItems> list = new ArrayList<SessionItems>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Query q = session.createQuery(" from SessionItems");

			@SuppressWarnings("rawtypes")
			List qu = q.list();
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = qu.iterator(); iterator.hasNext();) {
				SessionItems sessionItems = (SessionItems) iterator.next();
				list.add(sessionItems);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
