package org.webproject.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webproject.model.Customer;

@Repository("CustomerDAO")
public class CustomerDAOimpl extends AbstractDao<Integer, Customer>  implements CustomerDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	@Override
	public long getTotalCustomer() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		long result = 0;
		try {
			tx = session.beginTransaction();
			List accounts = session.createQuery("select count (*) FROM Customer").list();
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

	@Override
	public void updateCustomer(String idCus, String fullName, String phoneNumber, String address) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("Update Customer SET fullName= '"+ fullName + "' ,phoneNumber='" + phoneNumber+ "',address='" + address + "' where idCus = '" + idCus + "'");
		query.executeUpdate();
	}

	@Override
	public Customer getCustomerById(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Customer customer = null;
		try {
			tx = session.beginTransaction();
			List accounts = session.createQuery("FROM Customer where idCus = '"+id+"'").list();
			for (Iterator iterator = accounts.iterator(); iterator.hasNext();) {
				customer = (Customer) iterator.next();
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customer;
	}

	@Override
	public List<Customer> findAllCus() {
		Session session = sessionFactory.openSession();
		List<Customer> list = new ArrayList<Customer>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List customers = session.createQuery("FROM Customer").list();
			for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
				Customer customer = (Customer) iterator.next();
				customer.getAccount().getEmail();
				list.add(customer);
			
				
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

	@Override
	public Customer findCustomerById(String idCus) {
			System.out.println("hooooooooo");
			Criteria criteria = createEntityCriteria();
			criteria.add(Restrictions.eq("idCus", idCus));
			return (Customer) criteria.uniqueResult();
		}

	
}
