package org.webproject.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webproject.model.Account;
import org.webproject.model.Customer;

@Repository("AccountDAO")
public class AcountDAOImpl implements AccountDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Account findById(String idCus) {
		return null;
	}

	@Override
	public String saveAccount(Account account) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		String id="";
		try {
			tx = session.beginTransaction();
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String day = dateFormat.format(date).replace("-", "");
			long totalRecord = getTotalAccount();
			long nextID = totalRecord + 1;
			String full = fullString(nextID, 5);
			 id = day + "AC" + full;
			System.out.println(id);
			account.setIdCus(id);
			session.save(account);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		
		return id ;
		
	}

	private String fullString(long number, int len) {
		String num = number + "";
		while (num.length() < len) {
			num = "0" + num;
		}
		return num;
	}

	public ArrayList<String> getAllIdPN(String ngay) {
		Session session = sessionFactory.openSession();
		ArrayList<String> ids = new ArrayList<String>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List acounts = session.createQuery("select idCus from Account where idCus like N'%" + ngay + "%'").list();
			for (Iterator iterator = acounts.iterator(); iterator.hasNext();) {
				String strings = (String) iterator.next();
				ids.add(strings);
			}
			tx.commit();
		} catch (HibernateException e) {

		}
		return ids;
	}

	@Override
	public List<Account> findAllAccount() {
		Session session = sessionFactory.openSession();
		List<Account> list = new ArrayList<Account>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List acounts = session.createQuery("FROM Account").list();
			for (Iterator iterator = acounts.iterator(); iterator.hasNext();) {
				Account acount = (Account) iterator.next();
				list.add(acount);
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
	public Account findAccountById(String idCus) {
		return null;
	}

	@Override
	public long getTotalAccount() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		long result = 0;
		try {
			tx = session.beginTransaction();
			List accounts = session.createQuery("select count (*) FROM Account").list();
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

	@Override
	public boolean isValidAccount(String email, String password) {
		Session session = sessionFactory.openSession();
		long i = 0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Query q = session.createQuery(
					"select count(*) from Account where email = '" + email + "' and password = '" + password + "'");
			@SuppressWarnings("rawtypes")
			List qu = q.list();
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = qu.iterator(); iterator.hasNext();) {
				i = (long) iterator.next();
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (i > 0)
			return true;
		else
			return false;
	}
	
	@Override
	public Customer getCustomerByIdCus(String idCus) {
		Session session = sessionFactory.openSession();
		Customer customer = new Customer();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	        
			Query q = session.createQuery(" from Customer where idCus = '"+idCus+"'");
	         @SuppressWarnings("rawtypes")
	         List qu = q.list();
	         for (@SuppressWarnings("rawtypes")
			Iterator iterator = qu.iterator(); iterator.hasNext();){
	        	 customer = (Customer) iterator.next();
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return customer;
	}
	
	@Override
	public boolean checkEmailExist(String email) {
		System.out.println("asdfgh");
		Session session = sessionFactory.openSession();
		List<String> list = new ArrayList<String>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List lists = session.createQuery("select email from Account").list();
			for (Iterator iterator = lists.iterator(); iterator.hasNext();) {
				String strings = (String) iterator.next();
				list.add(strings);

			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(email)) {
					return true;
				}
			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public Account setIdByEmailAndPass(Account ac) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List acounts = session.createQuery("select idCus FROM Account where email = '"+ac.getEmail()+"' and password = '"+ac.getPassword()+"'").list();
			for (Iterator iterator = acounts.iterator(); iterator.hasNext();) {
				ac.setIdCus((String)iterator.next());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ac;
	}
	
}

