package org.webproject.service;

import java.util.List;

import org.webproject.model.Account;
import org.webproject.model.Customer;

public interface AccountService {
	Account findById(String idCus);

	String saveAccount(Account account);

	List<Account> findAllAccount();

	Account findAccountById(String idCus);

	long getTotalAccount();

	public boolean isValidAccount(String email, String password);

	Customer getCustomerByIdCus(String idCus);

	boolean checkEmailExist(String email);

	public Account setIdByEmailAndPass(Account ac);
}
