package org.webproject.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webproject.model.Orders;

@Repository("OrdersDAO")
public class OrdersDAOImpl implements OrdersDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveOrders(Orders order) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String day = dateFormat.format(date).replace("-", "");
			long totalRecord = getTotalOrders();
			long nextID = totalRecord + 1;
			String full = fullString(nextID, 5);
			String id = day + "OD" + full;
			System.out.println(id);
			
			order.setIdOrder(id);
			

			session.save(order);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private long getTotalOrders() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		long result = 0;
		try {
			tx = session.beginTransaction();
			List accounts = session.createQuery("select count (*) FROM Orders").list();
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
