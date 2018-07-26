package com.aj_vendingmachine.menus;

import java.util.Scanner;

import com.aj_vendingmachine.main.ECoffeVendorMenu;
import com.aj_vendingmachine.masterdataprep.CreditDataEntry;
import com.aj_vendingmachine.masterdataprep.DebitDataEntry;

public class MasterDataPreparation {
	public static void masterdataplan()
	{
		System.out.println("Master Data Preparation");

		Scanner sc = new Scanner(System.in);
		boolean logout=false;
		while (!logout) {
			System.out.println("--------------------------------");
			System.out.println("        E -Coffee Vendor        ");
			System.out.println("     Master Data Preperation      ");
			System.out.println("--------------------------------");
			System.out.println("|  1. Credit Card Holders        |");
			System.out.println("|  2. Debit Card Holders         |");
			System.out.println("|  3. Back                       |");
		
			System.out.println("----------------------------------");
		System.out.println("Enter Your choice ?");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1: 
			CreditDataEntry.creditData();
		        break;
		case 2:
		DebitDataEntry.debitData();
		       break;
		case 3:
			ECoffeVendorMenu.main(null); 
			       break;
		       
		default:System.out.println("Please select choice range 1-4 only");       
		}
		
		}

	}

}
