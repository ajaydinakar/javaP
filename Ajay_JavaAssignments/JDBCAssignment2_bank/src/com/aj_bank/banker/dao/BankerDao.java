package com.aj_bank.banker.dao;

import java.io.Serializable;
import java.util.List;

import com.aj_bank.customer.bean.CustomerBean;

public interface BankerDao extends Serializable {
	int addCustomer();
	void editCustomer();
	List<CustomerBean> viewCustomers();
	void minimumBalance();


}