package com.aj_vendingmachine.maintainence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.aj_vendingmachine.dbutility.ConnectionManager;

public class MaterialMaintainence {
	public static void addMaterial()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter coffe to add ");
		int coffeeQ=sc.nextInt();
		System.out.println("Enter sugar to add");
		int sugarQ=sc.nextInt();
		System.out.println("Enter cemer to add");
		int cremerQ=sc.nextInt();
		
	
		
		Connection con=null;
		CallableStatement cst = null;
	try
	{
		con=ConnectionManager.getConnection();
	   cst =con.prepareCall( "{ call updtwht( ?,?,?) } " ) ;  
	   cst.setInt(1,coffeeQ);
	   cst.setInt(3,sugarQ);
	   cst.setInt(2,cremerQ);
	  cst.execute();
	}
	catch(SQLException e)
	{
	e.printStackTrace();	
	}
		finally
		{
			ConnectionManager.release(con);
		}
		
	}

}
