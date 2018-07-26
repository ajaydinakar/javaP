package com.aj_vendingmachine.Reports;
import java.util.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat; 

import com.aj_vendingmachine.dbutility.ConnectionManager;
public class Reciept {
	public static void reciept(String type,int amount)
	{
		Connection con=null;
		CallableStatement cst = null;
	try
	{
		con=ConnectionManager.getConnection();
		if(type=="White"){
	   cst =con.prepareCall( "{ call whinc( ?,?) } " ) ;  
	   cst.setInt(1,1);
	   cst.setInt(2,amount);
		}
		else
		{
			cst =con.prepareCall( "{ call bkinc( ?,?) } " ) ;  
			   cst.setInt(1,1);
			   cst.setInt(2,amount);
		}
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
		Date d=new Date();
		 String date = DateFormat.getInstance().format(d);  
		System.out.println("       E-Coffee Reciept     ");
		System.out.println("                                        Date:"+date);
		System.out.println("Coffee Type: $"+type);
		System.out.println("Amount     : $"+amount);
		System.out.println("                             Thanks -visit again");
		
	}

}
/*SQL> create or replace procedure bkinc(qn number,amt number)is
  2  begin
  3  update vendor set quant=quant+qn where type='black';
  4  update vendor set price=amt+price where type='black';
  5  end;
  6  /

Procedure created.

SQL> create or replace procedure whinc(qn number,amt number)is
  2  begin
  3  update vendor set quant=quant+qn where type='white';
  4  update vendor set price=amt+price where type='white';
  5  end;
  6  /

Procedure created.*/