package org.webproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webproject.dao.ImageDao;
import org.webproject.model.Product;

@Service("imageService")
@Transactional
public class ImageProductServiceImpl implements ImageProductService{
	
	@Autowired
	ImageDao dao;
	
	@Override
	public void addImageForStudent(String nameIM, byte[] image, Product product) {
		dao.addImageForStudent(nameIM, image, product);
	}
	
}
