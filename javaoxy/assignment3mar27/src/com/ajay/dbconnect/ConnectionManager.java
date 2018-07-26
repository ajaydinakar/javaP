package com.ajay.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	static Connection con=null;
	public static Connection getConnection() throws SQLException
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());	
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "pasivedala");
		if(con!=null)
		{}
		else
		{
			System.out.println("Connection not Established");
		}
		return con;
		}	
	public static void release(Connection con)
	{
		if (con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void release(Connection con, Statement st) throws SQLException{
		// TODO Auto-generated method stub
		if(st!=null)
	
				st.close();
			
		if(con!=null)
	System.out.println("connection closed");
				con.close();
		
			}

}

