package com.aj_vendingmachine.Reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aj_vendingmachine.dat.GetCurrent;
import com.aj_vendingmachine.dbutility.ConnectionManager;

public class MaterialStatus {
public static void matirialStatus() 
{


	System.out.println("--------------------------------");
	System.out.println("        E -Coffee Vendor        ");
	System.out.println("         Material Status        ");
	System.out.println("--------------------------------");
	System.out.println("| Available Coffee Powder : "+GetCurrent.CoffeQuant()+"          |");
	System.out.println("| Avaialable Creamer      : "+GetCurrent.creamerQuant()+"          |");
	System.out.println("| Availabe Milk           :  "+GetCurrent.sugarQuant()+"         |");
	System.out.println("|                                    |");
	System.out.println("|              Press any key to continue  |");
	System.out.println("----------------------------------");
	}
}
;