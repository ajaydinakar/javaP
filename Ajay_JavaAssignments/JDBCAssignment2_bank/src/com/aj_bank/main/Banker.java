package com.aj_bank.main;

import java.util.Scanner;

import com.aj_bank.banker.dao.BankerDaoImpl;
import com.aj_bank.customer.dao.CustomerDaoImpl;



public class Banker {
	public static void bankerMenu(){
	    BankerDaoImpl bank = new BankerDaoImpl();
		Scanner sc = new Scanner(System.in);
		boolean logout=false;
		while (!logout) {
		System.out.println("----------------------------");
		System.out.println("Bank MANAGEMENT SYSTEM-Banker options  ");
		System.out.println("----------------------------");
		System.out.println("|  1. Add account          |");
		System.out.println("|  2. View accounts        |");
		System.out.println("|  3. Edit an account      |");
		System.out.println("|  4. minimum balance Accounts|");
		System.out.println("|  5. Logout               |");
		System.out.println("----------------------------");
		System.out.println("Enter Your choice ?");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:bank.addCustomer();
		        break;
		case 2:
			bank.viewCustomers();
			//System.out.println("Under Development");
		       break;
		       
		case 3:
			bank.editCustomer();
			//System.out.println("Under Development");
		       break;
		case 4:
			bank.minimumBalance();
			//System.out.println("Under Development");
		       break;
		case 5:logout=true;
		 BankManagementSystem.main(null);    
		       break;
		default:System.out.println("Please select choice range 1-5 only");       
		}
		
		}
	}
}
