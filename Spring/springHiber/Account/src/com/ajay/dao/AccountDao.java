package com.ajay.dao;

import java.util.List;

import com.ajay.Bean.Account;


public interface AccountDao {
	public void saveAccount(Account e);
	public void updateAccount(Account e);  
	public void deleteAccount(Account e);
	public Account getById(int eid);
	public List<Account> getAllAccounts();
}
