package com.aj_vendingmachine.deductions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.aj_vendingmachine.dat.GetCurrent;
import com.aj_vendingmachine.dbutility.ConnectionManager;
import com.aj_vendingmachine.main.ECoffeVendorMenu;


public class Deductions {
	public  static void forBlackCoffee()
	{
		int coffe=GetCurrent.CoffeQuant();
		
	
		if(coffe < 5)
		{
			System.out.println("not enough coffe! add material");
			ECoffeVendorMenu.main(null); 
		}
		coffe-=5;
		/*SQL> create or replace procedure updtblk(coff number)is
		  2  begin
		  3  update material set coffee=coff;
		  4  end;
		  5  /

		Procedure created.*/
		Connection con=null;
		CallableStatement cst = null;
	try
	{
		con=ConnectionManager.getConnection();
	   cst =con.prepareCall( "{ call updtblk( ?) } " ) ;  
	   cst.setInt(1,coffe);
;
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
	public  static void forWhiteCoffee()
	{
		int cremer=GetCurrent.creamerQuant();
		int coffe=GetCurrent.CoffeQuant();
		int sugar=GetCurrent.sugarQuant();
		if((coffe < 5)||(cremer < 20)||(sugar<10))
		{
			System.out.println("not enough material for making coffe! add material");
			ECoffeVendorMenu.main(null); 
		}
		coffe-=5;
		cremer-=20;
		sugar-=10;
	/*SQL> create or replace procedure updtwht(coff number,cr number,sug number)is
  2  begin
  3  update material set coffee=coff;
  4  update material set creamer=cr;
  5  update material set sugar=sug;
  6  end;
  7  /

Procedure created.*/
		Connection con=null;
		CallableStatement cst = null;
	try
	{
		con=ConnectionManager.getConnection();
	   cst =con.prepareCall( "{ call updtwht( ?,?,?) } " ) ;  
	   cst.setInt(1,coffe);
	   cst.setInt(2,cremer);
	   cst.setInt(3,sugar);
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
		
	
	public  static void forCreditBalance(String cdno,int price)
	{
		int bal=GetCurrent.Creditbalance(cdno);
		
		/*SQL> create or replace procedure updtcredit(cdn varchar2,bal number)is
		  2  begin
		  3  update debit set opbal=bal where cdno=cdn;
		  4  end;
		  5  /

		Procedure created.*/
		Connection con=null;
		CallableStatement cst = null;
		
	try
	{
		con=ConnectionManager.getConnection();
	   cst =con.prepareCall( "{ call updtcredit( ?,?) } " ) ;  
	   cst.setString(1,cdno);
	   cst.setInt(2,bal);
	
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
	public  static void forDebitBalance(String dbno,int price)
	{
		int bal=GetCurrent.debitbalance(dbno);
		/*SQL> create or replace procedure updtcredit(cd varchar,bal number)is
  2  begin
  3  update credit set opbal=bal where dbcno=cd;
  4  end;
  5  /

Procedure created.*/
		bal-=price;
		Connection con=null;
		CallableStatement cst = null;
	try
	{
		con=ConnectionManager.getConnection();
	   cst =con.prepareCall( "{ call updtdebit( ?,?) } " ) ;  
	   cst.setString(1,dbno);
	   cst.setInt(2,bal);
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
