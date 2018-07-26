package com.ajay.procedure;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.ajay.jdbcutility.JdbcUtility;
import com.ajay.query.QueryConstants;



/*

SQL>  create or replace procedure findsum(x in number,y in number,z out number)as
  2  begin
  3  z:=x*y;
  4  end;
  5  /

Function created.
 
 */
public class Procedure1 {
	public static void main(String[] args) throws SQLException {
	Connection con=null;
	CallableStatement cst = null;
try
{
	con=JdbcUtility.getConnection();
   cst =con.prepareCall( "{  call findsum( ?, ?,?) } " ) ;  
   cst.setInt(1,40);
   cst.setInt(2, 60);
   cst.registerOutParameter(3, Types.INTEGER);
   cst.execute();
   int result=cst.getInt(3);
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
}}

	


