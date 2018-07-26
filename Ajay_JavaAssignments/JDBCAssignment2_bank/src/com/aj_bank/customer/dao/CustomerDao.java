package com.aj_bank.customer.dao;


import java.io.Serializable;





public interface CustomerDao extends Serializable {
	int addDeposit(String nm,String pw);
	int transferAmount(String nm,String pw);
	int withdrawAmount(String nm,String pw);
	void enqiry(String nm,String pw);

}

