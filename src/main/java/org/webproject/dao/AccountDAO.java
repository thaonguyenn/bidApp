package org.webproject.dao;

import java.util.List;

import org.webproject.model.Account;
import org.webproject.model.Customer;

public interface AccountDAO {
	Account findById(String idCus);

	String saveAccount(Account account);

	List<Account> findAllAccount();

	Account findAccountById(String idCus);

	long getTotalAccount();

	boolean isValidAccount(String email, String password);

	Customer getCustomerByIdCus(String idCus);
	
	boolean checkEmailExist(String email);
	
	Account setIdByEmailAndPass(Account ac);

}
