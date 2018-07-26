package com.aj_vendingmachine.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.aj_vendingmachine.dbutility.ConnectionManager;


public class Validity {
	public static boolean creditCard(String sno){
	Scanner sc=new Scanner(System.in);
	Connection con=null;
	PreparedStatement pst=null;
	int count=0;
	boolean suffbal=false;
try
{
	con=ConnectionManager.getConnection();
    pst=con.prepareStatement("select opbal  from credit where dbcno=? and opbal>10");	    


   pst.setString(1,sno);
  
   count=pst.executeUpdate();
    if(count!=0){
    
    	System.out.println("Query is effected");
    suffbal=true;}
    else
    	System.out.println("Query is aaa not effected");

}
catch(SQLException e)
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
	return suffbal;}
	
	
	
	
	
	
	
	public static boolean debitCard(String sno)
	{
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement pst=null;
		int count=0;
		boolean suffbal=false;
	try
	{
		con=ConnectionManager.getConnection();
	    pst=con.prepareStatement("select opbal  from debit where cdno=? and opbal>10");	    
	

	   pst.setString(1,sno);
	  
	   count=pst.executeUpdate();
	    if(count!=0){
	    	System.out.println("Query is effected");
	    suffbal=true;}
	    else
	    	System.out.println("Query is not effected");
	
	}
	catch(SQLException e)
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
		return suffbal;}
}

