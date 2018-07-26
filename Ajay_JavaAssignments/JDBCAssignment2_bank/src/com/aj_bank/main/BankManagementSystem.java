package com.aj_bank.main;

import java.util.Scanner;

import com.aj_bank.authenticate.Authenticate;



public class BankManagementSystem {

static boolean exit=false;

   public static void main(String[] args) 
	 {
	   Authenticate user=new Authenticate();
		
	   Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("------------------------------------");
			System.out.println(" Online Banking MANAGEMENT SYSTEM  ");
			System.out.println("-------------------------------------");
			System.out.println("|     1. Banker Login               |");
			System.out.println("|     2. Customer Login             |");
			System.out.println("|     3. EXIT                       |");
			System.out.println("-------------------------------------");
			System.out.println("Enter Your choice ?");
			int choice = sc.nextInt();
		
			switch (choice) {
			case 1:
				user.authenticateBanker();
				break;
			case 2:
				user.authenticateCustomer();
				break;
			case 3:
				System.out.println("System Exiting");
				System.exit(0);
				break;
			default:
				System.out.println("Please select choice range 1-3 only");
			}
			
		}
	 }
}
	 
	 
	 
	 
	 
		
		
		


