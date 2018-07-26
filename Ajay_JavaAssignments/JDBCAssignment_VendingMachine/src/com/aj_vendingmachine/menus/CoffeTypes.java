package com.aj_vendingmachine.menus;

import java.util.Scanner;

import com.aj_vendingmachine.main.ECoffeVendorMenu;
import com.aj_vendingmachine.payment.PaymentOptions;

public class CoffeTypes {
	public static void coffevending()
	{
		System.out.println("coffe vending");
	

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("--------------------------------");
			System.out.println("        E -Coffee Vendor        ");
			System.out.println("         Coffee Types              ");
			System.out.println("--------------------------------");
			System.out.println("|  1. White @ $10               |");
			System.out.println("|  2. Black @ $6                |");
			System.out.println("|  4. EXIT                      |");
			System.out.println("----------------------------------");
		System.out.println("Enter Your choice ?");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1: 
			PaymentOptions.paymentOptions("White",10);
		        break;
		case 2:
			PaymentOptions.paymentOptions("Black",6);
		       break;

		case 3:
		ECoffeVendorMenu.main(null);    
		       break;
		default:System.out.println("Please select choice range 1-4 only");       
		}
		
		}
	}

}
