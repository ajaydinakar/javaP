package com.ajay.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ajay.Bean.Account;
import com.ajay.dao.AccountDaoImpl;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("account.xml");

		AccountDaoImpl dao = ctx.getBean("acc", AccountDaoImpl.class);

		

		createAccount(dao);
		//getAllAccounts(dao);
		
		ctx.close();

	}



	public static void getAllAccounts(AccountDaoImpl ac) {

		List<Account> acclist = ac.getAllAccounts();

		for (Account acc : acclist) 
		{
			System.out.println(acc.getId()+"     " +acc.getName()+"     " +acc.getPassword());

		}

	}

	private static void createAccount(AccountDaoImpl ac) {

		Account a1=new Account();
	   a1.setName("ajay");
	   a1.setPassword("pwd@6");
	   ac.saveAccount(a1);

	}
	}


