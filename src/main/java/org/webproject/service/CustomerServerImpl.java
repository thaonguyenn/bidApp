package org.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webproject.dao.CustomerDAO;
import org.webproject.model.Customer;

@Service("CustomerService")
@Transactional
public class CustomerServerImpl implements CustomerService{
	@Autowired
	private CustomerDAO dao;

	@Override
	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
		
	}

	@Override
	public void updateCustomer(String idCus, String fullName, String phoneNumber, String address) {
		dao.updateCustomer(idCus, fullName, phoneNumber, address);
		
	}

	@Override
	public Customer getCustomerById(String id) {
		return dao.getCustomerById(id);
	}

	@Override
	public List<Customer> findAllCus() {
		return dao.findAllCus();
	}

	@Override
	public long getTotalCustomer() {
		return dao.getTotalCustomer();
	}

	@Override
	public Customer findCustomerById(String idCus) {
		return dao.findCustomerById(idCus);
	}
}
