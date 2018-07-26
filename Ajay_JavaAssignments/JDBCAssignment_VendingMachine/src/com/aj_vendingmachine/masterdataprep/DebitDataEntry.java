package com.aj_vendingmachine.masterdataprep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.aj_vendingmachine.dbutility.ConnectionManager;

public class DebitDataEntry {
	public static void debitData(){
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter Credit Card  number ");
	String cdno=sc.next();
	System.out.println("Enter Name of card holder");
	String name=sc.next();
	System.out.println("Enter Date of birth");
	String dob=sc.next();
	System.out.println("Enter Address");
	String add=sc.next();
	System.out.println("Enter Phone number ");
	String phno=sc.next();
	System.out.println("Enter opening balance 	");
	int cdlt=sc.nextInt();
	System.out.println("Enter pin");
	int pin=sc.nextInt();
	Connection con=null;
	PreparedStatement pst=null;
	int count=0;
	try
	{
		con=ConnectionManager.getConnection();
		pst=con.prepareStatement("insert into credit values(?,?,?,?,?,?,?) ");
		System.out.println("Enter your current password");
		  
		   pst.setString(1,cdno);
		   pst.setString(2,name);
		   pst.setString(3,dob);
		   pst.setString(4,add);
		   pst.setString(5,phno);
		   pst.setInt(6,cdlt);
		   pst.setInt(7,pin);
		   count=pst.executeUpdate();
		    if(count!=0)
		    	System.out.println("Query is effected");
		    else
		    	System.out.println("Query is not effected");
	}
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		try {
			ConnectionManager.release(con,pst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
}
