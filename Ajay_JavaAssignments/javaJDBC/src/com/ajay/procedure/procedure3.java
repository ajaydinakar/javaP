package com.ajay.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.ajay.jdbcutility.JdbcUtility;
/*
SQL>  create or replace procedure getpwd(nam varchar2,pass out varchar2)is
  2  begin
  3  select pwd into pass from admin where name=nam;
  4  end;
  5  /

Procedure created.
  
 * */
public class procedure3 {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		CallableStatement cst = null;
	try
	{
		con=JdbcUtility.getConnection();
	   cst =con.prepareCall( "{ call getpwd( ?,?) } " ) ;  
	   cst.setString(1,"admin");
	  cst.registerOutParameter(2,Types.VARCHAR);
	  cst.execute();
	  String password=cst.getString(2);
	  System.out.println(password);
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
