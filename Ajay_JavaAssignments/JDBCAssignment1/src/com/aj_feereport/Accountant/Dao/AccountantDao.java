package com.aj_feereport.Accountant.Dao;

import java.util.List;

import com.aj_feereport.Accountant.bean.AccountantBean;


public interface AccountantDao {
	int addAccountant();
	List<AccountantBean> viewAccountants();

}
