package com.aj_feereport.main;

import java.util.Scanner;

import com.aj_feereport.Accountant.Dao.AccountantDaoImpl;

public class AdminMenu {
	public static void adminMenu(){
		AccountantDaoImpl accountant= new AccountantDaoImpl();
		 /*CourseDaoImpl courseDao=new CourseDaoImpl();
		 FeesDaoImpl feeDao=new FeesDaoImpl();*/

		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println(" STUDENT Fee Report MANAGEMENT SYSTEM  ");
		System.out.println("----------------------------");
		System.out.println("|  1. Add Accountant              |");
		System.out.println("|  2. View Accountant             |");
		System.out.println("|  3. Logout                 |");
		System.out.println("----------------------------");
		System.out.println("Enter Your choice ?");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1: accountant.addAccountant();
		        break;
		case 2:System.out.println("Under Development");
			accountant.viewAccountants();
			System.out.println("Under Development");
		       break;
		       
		case 3:FeeReportManagemntSystem.main(null);    
		       break;
		default:System.out.println("Please select choice range 1-4 only");       
		}

	}

}
