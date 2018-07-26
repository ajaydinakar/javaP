package com.aj_vendingmachine.payment;

import java.util.Scanner;

import com.aj_vendingmachine.deductions.Deductions;
import com.aj_vendingmachine.main.ECoffeVendorMenu;

public class Credit {
	public static void credit(int price)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Card number :");
		String cardnumber=sc.next();
		System.out.println("Enter Amount :"+price);
		System.out.println("Enter Pin");
		int pin=sc.nextInt();
		
		if(Validity.creditCard(cardnumber))
		{
			if(price==6)
			{
			Deductions.forBlackCoffee();
			Deductions.forCreditBalance(cardnumber, price);
			}
			else
			{
				Deductions.forWhiteCoffee();
				Deductions.forCreditBalance(cardnumber, price);
			}
		}
		else{
			System.out.println("Card invalid or balance below purchase");
		ECoffeVendorMenu.main(null);}
	
	}

}
