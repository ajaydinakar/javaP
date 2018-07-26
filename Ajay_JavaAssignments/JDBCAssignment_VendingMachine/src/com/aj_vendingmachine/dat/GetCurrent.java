package com.aj_vendingmachine.dat;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import com.aj_vendingmachine.dbutility.ConnectionManager;



public class GetCurrent {
public static int Creditbalance(String cdno){
	/*SQL>
SQL> create or replace procedure getcdbal(cd varchar2,Quat out number)is
  2  begin
  3  select opbal into Quat from credit where dbcno=cd;
  4  end;
  5  /

Procedure created.*/
	Connection con=null;
	CallableStatement cst = null;
    int cdbal=0;
try
{
	con=ConnectionManager.getConnection();
   cst =con.prepareCall( "{ call getcdbal(?,?) } " ) ;  
cst.setString(1,cdno);
  cst.registerOutParameter(2,Types.INTEGER);
  cst.execute();
   cdbal=cst.getInt(2);
  System.out.println(cdbal);
}
catch(SQLException e)
{
e.printStackTrace();	
}
	finally
	{
		ConnectionManager.release(con);
	}
return cdbal;
}

;
public static int debitbalance(String dbno){

	/*SQL> create or replace procedure getdbbal(db varchar2,Quat out number)is
  2  begin
  3  select opbal into Quat from debit where cdno=db;
  4  end;
  5  /

Procedure created.
*/
	Connection con=null;
	CallableStatement cst = null;
    int dbbal=0;
try
{
	con=ConnectionManager.getConnection();
   cst =con.prepareCall( "{ call getdbbal(?,?) } " ) ;  
cst.setString(1,dbno);
  cst.registerOutParameter(2,Types.INTEGER);
  cst.execute();
   dbbal=cst.getInt(2);
  System.out.println(dbbal);
}
catch(SQLException e)
{
e.printStackTrace();	
}
	finally
	{
		ConnectionManager.release(con);
	}
return dbbal;
};
public static int sugarQuant(){
	/*
	SQL> create or replace procedure getSug(Quat out number)is
	  2  begin
	  3  select sugar into Quat from material;
	  4  end;
	  5  /

	Procedure created.
	*/
			Connection con=null;
			CallableStatement cst = null;
			 int sugar=0;
		try
		{
			con=ConnectionManager.getConnection();
		   cst =con.prepareCall( "{ call getSug(?) } " ) ;  
		
		  cst.registerOutParameter(1,Types.INTEGER);
		  cst.execute();
		   sugar=cst.getInt(1);
		  System.out.println(sugar);
		}
		catch(SQLException e)
		{
		e.printStackTrace();	
		}
			finally
			{
				ConnectionManager.release(con);
			}
		return sugar;
		}
public static int CoffeQuant(){
	/*
SQL> create or replace procedure getCof(Quat out number)is
  2  begin
  3  select coffee into Quat from material;
  4  end;
  5  /

Procedure created.
*/	Connection con=null;
CallableStatement cst = null;
int coffe=0;
try
{
con=ConnectionManager.getConnection();
cst =con.prepareCall( "{ call getCof(?) } " ) ;  

cst.registerOutParameter(1,Types.INTEGER);
cst.execute();
coffe=cst.getInt(1);
}
catch(SQLException e)
{
e.printStackTrace();	
}
finally
{
	ConnectionManager.release(con);
}
return coffe;}
public static int creamerQuant(){
	/*
SQL> create or replace procedure getCrem(Quat out number)is
  2  begin
  3  select creamer into Quat from material;
  4  end;
  5  /

Procedure created.*/
	Connection con=null;
	CallableStatement cst = null;
	int creamer=0;
	try
	{
	con=ConnectionManager.getConnection();
	cst =con.prepareCall( "{ call getCrem(?) } " ) ;  

	cst.registerOutParameter(1,Types.INTEGER);
	cst.execute();
	creamer=cst.getInt(1);
	}
	catch(SQLException e)
	{
	e.printStackTrace();	
	}
	finally
	{
		ConnectionManager.release(con);
	}
	return creamer;}


}
