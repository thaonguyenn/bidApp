package org.webproject.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webproject.model.ImageProduct;
import org.webproject.model.Product;
import org.webproject.model.SessionItems;

@Repository("imageDao")
public class ImageDaoImpl implements ImageDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addImageForStudent(String nameIM, byte[] image, Product product) {
		Session session = sessionFactory.openSession();
		long id = getTotalImg() + 1;
		Query query = session.createSQLQuery("Insert into imageProduct VALUES("+id+" , '"+nameIM+"',CAST('"+image+"' as varBinary(MAX)),'"+product.getIdProduct()+"')");
		query.executeUpdate();
	}

	private long getTotalImg() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		long result = 0;
		try {
			tx = session.beginTransaction();
			List accounts = session.createQuery("select count (*) FROM ImageProduct").list();
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
}
