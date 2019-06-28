package org.webproject.dao;

import java.util.List;

import org.webproject.model.ImageProduct;
import org.webproject.model.Product;

public interface ImageDao {
	public void addImageForStudent(String nameIM, byte[] image, Product product);
	 
}
