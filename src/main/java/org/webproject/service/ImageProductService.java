package org.webproject.service;

import org.webproject.model.Product;

public interface ImageProductService {
	public void addImageForStudent(String nameIM, byte[] image, Product product);
}
