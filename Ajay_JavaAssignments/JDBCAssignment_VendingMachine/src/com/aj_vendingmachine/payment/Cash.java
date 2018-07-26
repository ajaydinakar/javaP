package com.aj_vendingmachine.payment;

import java.util.Scanner;

public class Cash {
	public static int cash()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter number of $1 bills");
		int one=sc.nextInt();
		System.out.println("Enter number of $2 bills");
		int two=sc.nextInt();
		System.out.println("Enter number of $5 bills");
		int five=sc.nextInt();
		int amount=one+two+five;
		return amount;
	}

}
