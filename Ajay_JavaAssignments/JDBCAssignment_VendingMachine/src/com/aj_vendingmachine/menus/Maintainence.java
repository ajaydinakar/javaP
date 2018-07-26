package com.aj_vendingmachine.menus;

import java.util.Scanner;

import com.aj_vendingmachine.Reports.Reports;
import com.aj_vendingmachine.main.ECoffeVendorMenu;
import com.aj_vendingmachine.maintainence.MaterialMaintainence;
import com.aj_vendingmachine.maintainence.PasswordChange;

public class Maintainence {
	public static void maintainence()
	{
		System.out.println("coffe Maintainance");

		Scanner sc = new Scanner(System.in);
		boolean logout=false;
		while (!logout) {
			System.out.println("--------------------------------");
			System.out.println("      E -Coffee Vendor          ");
			System.out.println("       Maintainence             ");
			System.out.println("--------------------------------");
			System.out.println("|  1. Add Material              |");
			System.out.println("|  2. Change Password           |");
			System.out.println("|  3. Reports                   |");
			System.out.println("|  4. EXIT                      |");
			System.out.println("----------------------------------");
		System.out.println("Enter Your choice ?");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1: 
			MaterialMaintainence.addMaterial();
		        break;
		case 2:
		      PasswordChange.changePwd();
		       break;
		       
		case 3:
			Reports.reportMenu();
		       break;
	
		case 4:logout=true;
		ECoffeVendorMenu.main(null);    
		       break;
		default:System.out.println("Please select choice range 1-4 only");       
		}
		
		}

		
	}

}
