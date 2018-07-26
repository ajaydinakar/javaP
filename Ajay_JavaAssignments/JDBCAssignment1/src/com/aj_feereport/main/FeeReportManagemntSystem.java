package com.aj_feereport.main;

import java.util.Scanner;

import com.aj_feereport.authenticate.Authentication;

public class FeeReportManagemntSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Authentication user =new Authentication();
		int choice;
		while (true) {
			System.out.println("----------------------------");
			System.out.println(" STUDENT Fee Report MANAGEMENT SYSTEM  ");
			System.out.println("----------------------------");
			System.out.println("|  1. ADMIN                |");
			System.out.println("|  2. ACCOUNTANT           |");
			System.out.println("|  3. EXIT                 |");
			System.out.println("----------------------------");
			System.out.println("Enter Your choice ?");
		    choice = sc.nextInt();
			switch (choice) {
			case 1:
			    user.authenticateAdmin();;
				break;
			case 2:
				user.authenticateAccountant();
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
