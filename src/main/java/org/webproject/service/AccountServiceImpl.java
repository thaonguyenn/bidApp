package org.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webproject.dao.AccountDAO;
import org.webproject.model.Account;
import org.webproject.model.Customer;

@Service("AccountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO dao;

	@Override
	public Account findById(String idCus) {
		return dao.findById(idCus);
	}

	@Override
	public String saveAccount(Account account) {
		return dao.saveAccount(account);

	}

	@Override
	public List<Account> findAllAccount() {
		return dao.findAllAccount();
	}

	@Override
	public Account findAccountById(String idCus) {
		return dao.findAccountById(idCus);
	}

	@Override
	public long getTotalAccount() {
		return dao.getTotalAccount();
	}

	@Override
	public boolean isValidAccount(String email, String password) {
		return dao.isValidAccount(email, password);
	}

	@Override
	public Customer getCustomerByIdCus(String idCus) {
		return dao.getCustomerByIdCus(idCus);
	}

	@Override
	public boolean checkEmailExist(String email) {
		return dao.checkEmailExist(email);
	}

	@Override
	public Account setIdByEmailAndPass(Account ac) {
		return dao.setIdByEmailAndPass(ac);
	}

}
