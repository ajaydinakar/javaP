package com.aj_bank.customer.bean;

public class CustomerBean {
	private int id;
	
	private int balance;
	private int accountno;
	private int transferAmt;
	private int depositAmt;
	private int withdrawAmt;
	private String name;
	private String passwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public int getTransferAmt() {
		return transferAmt;
	}
	public void setTransferAmt(int transferAmt) {
		this.transferAmt = transferAmt;
	}
	public int getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(int depositAmt) {
		this.depositAmt = depositAmt;
	}
	public int getWithdrawAmt() {
		return withdrawAmt;
	}
	public void setWithdrawAmt(int withdrawAmt) {
		this.withdrawAmt = withdrawAmt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public CustomerBean(int balance, int accountno, int transferAmt,
			int depositAmt, int withdrawAmt, String name, String passwd) {
		super();
		this.balance = balance;
		this.accountno = accountno;
		this.transferAmt = transferAmt;
		this.depositAmt = depositAmt;
		this.withdrawAmt = withdrawAmt;
		this.name = name;
		this.passwd = passwd;
	}
	public CustomerBean() {
		
		// TODO Auto-generated constructor stub
	}
	

}
