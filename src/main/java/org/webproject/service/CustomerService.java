package org.webproject.service;

import java.util.List;

import org.webproject.model.Customer;

public interface CustomerService {
	void saveCustomer(Customer customer);
	void updateCustomer(String idCus,String fullName,String phoneNumber,String address);
	Customer getCustomerById(String id);
	List<Customer>findAllCus();
	long getTotalCustomer();
	Customer findCustomerById(String idCus);
}
