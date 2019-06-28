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
import org.webproject.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getListProductByListID(List<String> ids) {
		Session session = sessionFactory.openSession();
		List<Product> list = new ArrayList<Product>();
		 Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	        for (String id : ids) {
	        	Query q = session.createQuery(" from Product where idProduct = '" + id +"'");
		         @SuppressWarnings("rawtypes")
		         List qu = q.list();
		         for (@SuppressWarnings("rawtypes")
				Iterator iterator = qu.iterator(); iterator.hasNext();){
		        	 Product product = (Product) iterator.next();
		            list.add(product);
		         }
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
	public Product getDetailProduct(String id) {
		Session session = sessionFactory.openSession();
		Product product = new Product();
		Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	        	Query q = session.createQuery("from Product where idProduct = '" + id +"'");
		         @SuppressWarnings("rawtypes")
		         List qu = q.list();
		         for (@SuppressWarnings("rawtypes")
				Iterator iterator = qu.iterator(); iterator.hasNext();){
		        	 product = (Product) iterator.next();
		         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return product;
	}
	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String day = dateFormat.format(date).replace("-", "");
			long totalRecord = getTotalProduct();
			long nextID = totalRecord + 1;
			String full = fullString(nextID, 5);
			String id = day + "PR" + full;
			product.setIdProduct(id);
			product.setPresentStatus(1);
			product.setCreateDay(date);
			
			session.save(product);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private String fullString(long number, int len) {
		String num = number + "";
		while (num.length() < len) {
			num = "0" + num;
		}
		return num;
	}

	public long getTotalProduct() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		long result = 0;
		try {
			tx = session.beginTransaction();
			List products = session.createQuery("select count (*) FROM Product").list();
			for (Iterator iterator = products.iterator(); iterator.hasNext();) {
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
	public List<Product> getOwnerProduct(String idUser) {
		Session session = sessionFactory.openSession();
		List<Product> list = new ArrayList<Product>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List products = session.createQuery("FROM Product where owner.idCus = '" + idUser + "'").list();
			for (Iterator iterator = products.iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				list.add(product);
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
	public List<Product> getBuyerProduct(String idUser) {
		Session session = sessionFactory.openSession();
		List<Product> list = new ArrayList<Product>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List products = session.createQuery("FROM Product where customer.idCus = '" + idUser + "'").list();
			for (Iterator iterator = products.iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				list.add(product);
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
	public List<Product> getListByStatus(int status) {
		Session session = sessionFactory.openSession();
		List<Product> list = new ArrayList<Product>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List products = session.createQuery("FROM Product where presentStatus = " + status).list();
			for (Iterator iterator = products.iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				list.add(product);
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
	public List<Product> getAllProduct() {
		Session session = sessionFactory.openSession();
		List<Product> list = new ArrayList<Product>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List products = session.createQuery("FROM Product where presentStatus = 1").list();
			for (Iterator iterator = products.iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				list.add(product);
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
	public void updateProduct(int status, String idProduct) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("UPDATE Product SET presentStatus =" + status + " WHERE idProduct = '" + idProduct + "'");
		query.executeUpdate();
	}

	@Override
	public List<Product> listTopProductWithStatus(int status, int top) {
		Session session = sessionFactory.openSession();
		List<Product> list = new ArrayList<Product>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("FROM Product where presentStatus = " + status);
			q.setMaxResults(top);
			List products = q.list();
			for (Iterator iterator = products.iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				list.add(product);
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
