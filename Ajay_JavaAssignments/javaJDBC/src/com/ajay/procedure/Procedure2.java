package com.ajay.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.ajay.jdbcutility.JdbcUtility;
/*
 * SQL> create or replace procedure newadmin(name varchar2,password varchar2)is
  2  begin
  3  insert into admin values(name,password);
  4  end;
  5  /

Procedure created.


//beforre execution
SQL> select * from admin;

NAME                 PWD
-------------------- --------------------
admin                password

*/
public class Procedure2 
{public static void main(String[] args) throws SQLException {
	Connection con=null;
	CallableStatement cst = null;
try
{
	con=JdbcUtility.getConnection();
   cst =con.prepareCall( "{  call newadmin( ?, ?) } " ) ;  
   cst.setString(1,"vender");
   cst.setString(2,"ecoffe");
   cst.execute();
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
//after exection
/*SQL> select * from admin;

NAME                 PWD
-------------------- --------------------
admin                password
ajay                 pass*/
