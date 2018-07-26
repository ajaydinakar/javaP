package com.ajay.jdbcfirst;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.ajay.jdbcutility.JdbcUtility;
import com.ajay.query.QueryConstants;
public class StConnect {
	
	public static void main(String [] args)
	{
		Connection con=null;
		Statement st=null;
		int count=0;
	try
	{
		con=JdbcUtility.getConnection();
	    st=con.createStatement();	    
	   count=st.executeUpdate(QueryConstants.SELECT_QUERY);
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
				JdbcUtility.release(con,st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
