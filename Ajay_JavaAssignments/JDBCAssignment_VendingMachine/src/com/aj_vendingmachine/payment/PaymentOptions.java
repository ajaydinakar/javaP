package com.aj_vendingmachine.payment;

import java.util.Scanner;




import com.aj_vendingmachine.Reports.Reciept;
import com.aj_vendingmachine.Reports.Reports;
import com.aj_vendingmachine.menus.CoffeTypes;

public class PaymentOptions 
{
	public static void paymentOptions(String type,int price)
	{
	Scanner sc = new Scanner(System.in);
	boolean logout=false;
	while (!logout) {
		System.out.println("--------------------------------");
		System.out.println("        E -Coffee Vendor        ");
		System.out.println("         Payment Options              ");
		System.out.println("--------------------------------");
		System.out.println("|  1. Cash                       |");
		System.out.println("|  2. Credit Card                |");
		System.out.println("|  3. Debit Card                 |");
		System.out.println("|  4. Back                       |");
		System.out.println("----------------------------------");
	System.out.println("Enter Your choice ?");
	int choice = sc.nextInt();
	switch(choice)
	{
	case 1:
		int paid=Cash.cash();
		
		if (paid<price)
		{System.out.println("payment is not full");}
		else
			Reciept.reciept(type,paid);
	        break;
	case 2:
	   Credit.credit(price);
	   Reciept.reciept(type, price);
	       break;
	       

	case 3:
		Debit.debit(price);
		 Reciept.reciept(type, price);
	       break;
	  
	case 4:
	         CoffeTypes.coffevending();    
	       break;
	default:System.out.println("Please select choice range 1-4 only");       
	}
	
	}

}
}
