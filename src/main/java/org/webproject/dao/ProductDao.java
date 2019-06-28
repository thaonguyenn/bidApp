package org.webproject.dao;

import java.util.List;

import org.webproject.model.Product;

public interface ProductDao {
	public List<Product> getListProductByListID(List<String> ids);
	public Product getDetailProduct(String id);
	public void addProduct(Product product);
	long getTotalProduct();
	List<Product> getOwnerProduct(String idUser);
	List<Product> getBuyerProduct(String idUser);
	List<Product> getListByStatus(int status);
	List<Product> getAllProduct();
	public void updateProduct(int status,String idProduct);
	List<Product> listTopProductWithStatus(int status, int top);
}
