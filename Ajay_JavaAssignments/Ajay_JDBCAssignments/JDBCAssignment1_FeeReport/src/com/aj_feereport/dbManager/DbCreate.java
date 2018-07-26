package com.aj_feereport.dbManager;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.aj_feereport.utility.ConnectionManager;



public class DbCreate {
	public static void main(String [] args)
	{
		Connection con=null;

        Statement st=null;
		int count=0;
	try
	{
		con=ConnectionManager.getConnection();
	    st=(Statement) con.createStatement();	    
	   count=st.executeUpdate(QueryConst.CREATE_Student);
	    System.out.println(count);
	    if(count!=0)
	    	System.out.println("Query is effected");
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
				ConnectionManager.release(con,st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
