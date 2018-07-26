package com.aj_vendingmachine.payment;

import java.util.Scanner;

import com.aj_vendingmachine.deductions.Deductions;

public class Debit {
	public static void debit(int price)
	{
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Card number :");
		String cardnumber=sc.next();
		System.out.println("Enter Pin number ");
		int pin=sc.nextInt();
		System.out.println("Enter Amount :"+price);
		if(Validity.creditCard(cardnumber))
		{
			if(price==6)
			{
			Deductions.forBlackCoffee();
			Deductions.forDebitBalance(cardnumber, price);
			}
			else
			{
				Deductions.forWhiteCoffee();
				Deductions.forDebitBalance(cardnumber, price);
			}
		}
		
	}
}
