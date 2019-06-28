package org.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webproject.dao.ProductDao;
import org.webproject.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> getListProductByListID(List<String> ids) {
		return productDao.getListProductByListID(ids);
	}
	@Override
	public Product getDetailProduct(String id) {
		return productDao.getDetailProduct(id);
	}
	@Transactional
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public long getTotalProduct() {
		
		return productDao.getTotalProduct();
	}

	@Override
	public List<Product> getOwnerProduct(String idUser) {
		
		return productDao.getOwnerProduct(idUser);
	}

	@Override
	public List<Product> getBuyerProduct(String idUser) {
		
		return productDao.getBuyerProduct(idUser);
	}

	@Override
	public List<Product> getListByStatus(int status) {
	
		return productDao.getListByStatus(status);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productDao.getAllProduct();
	}

	@Override
	public void updateProduct(int status, String idProduct) {
		productDao.updateProduct(status, idProduct);
		
	}
	@Override
	public List<Product> listTopProductWithStatus(int status, int top) {
		return productDao.listTopProductWithStatus(status, top);
	}

}
