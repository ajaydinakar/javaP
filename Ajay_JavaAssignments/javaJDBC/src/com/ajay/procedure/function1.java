package com.ajay.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.ajay.jdbcutility.JdbcUtility;
/*

SQL>  create or replace function findp(x in number,y in number)return number as z number;
  2  begin
  3  z:=x*y;
  4  return(z);
  5  end;
  6  /

Function created.
 
 */

public class function1 {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		CallableStatement cst = null;
	try
	{
		con=JdbcUtility.getConnection();
	   cst =con.prepareCall( "{ ?= call findp( ?, ?) }" ) ;  
	   cst.setInt(2,40);
	   cst.setInt(3, 60);
	   cst.registerOutParameter(1, Types.INTEGER);
	   cst.execute();
	   int result=cst.getInt(1);
	   System.out.println("the sum of the digits is"+result);
	}
	catch(SQLException e)
	{
	e.printStackTrace();	
	}
		finally
		{
			JdbcUtility.release(con);
		}
	}

}
