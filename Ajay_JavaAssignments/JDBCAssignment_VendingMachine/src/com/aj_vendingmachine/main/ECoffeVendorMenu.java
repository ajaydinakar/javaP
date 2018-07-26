package com.aj_vendingmachine.main;

import java.util.Scanner;
import com.aj_vendingmachine.menus.*;
public class ECoffeVendorMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//Authentication user =new Authentication();
		int choice;
		while (true) {
			System.out.println("--------------------------------");
			System.out.println("        E -Coffee Vendor        ");
			System.out.println("         Main Menu              ");
			System.out.println("--------------------------------");
			System.out.println("|  1. Coffee Vending            |");
			System.out.println("|  2. Master Data Preparation   |");
			System.out.println("|  3. Maintainance              |");
			System.out.println("|  4. EXIT                      |");
			System.out.println("----------------------------------");
			System.out.println("Enter Your choice ?");
		    choice = sc.nextInt();
			switch (choice) {
			case 1:
				CoffeTypes.coffevending();
				break;
			case 2:
				MasterDataPreparation.masterdataplan();
				
				break;
             case 3:
            	 Maintainence.maintainence();
				break;
			case 4:
				System.out.println("System Exiting");
				System.exit(0);
				break;
			default:
				System.out.println("Please select choice range 1-4 only");
			}
		}

	}

}
