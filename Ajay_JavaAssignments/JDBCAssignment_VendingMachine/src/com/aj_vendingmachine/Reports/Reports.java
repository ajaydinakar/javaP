package com.aj_vendingmachine.Reports;

import java.util.Scanner;

import com.aj_vendingmachine.main.ECoffeVendorMenu;
import com.aj_vendingmachine.menus.Maintainence;

public class Reports {
	 
	public static void reportMenu()
	{
		Scanner sc = new Scanner(System.in);
	while (true) {
		System.out.println("--------------------------------");
		System.out.println("        E -Coffee Vendor        ");
		System.out.println("         Coffee Types              ");
		System.out.println("--------------------------------");
		System.out.println("|  1. Material Status              |");
		System.out.println("|  2. Transaction Status                |");
		System.out.println("|  4. EXIT                      |");
		System.out.println("----------------------------------");
	System.out.println("Enter Your choice ?");
	int choice = sc.nextInt();
	switch(choice)
	{
	case 1: 
		MaterialStatus.matirialStatus();
	        break;
	case 2:
	     TransactionStatus.transactionStatus();
	       break;

	case 3:
    Maintainence.maintainence(); 
	       break;
	default:System.out.println("Please select choice range 1-4 only");       
	}
	
	}

}
}