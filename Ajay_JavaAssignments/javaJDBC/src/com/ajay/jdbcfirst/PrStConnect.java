package com.ajay.jdbcfirst;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.ajay.jdbcutility.JdbcUtility;
import com.ajay.query.QueryConstants;
public class PrStConnect {
	
	
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pst=null;
		int count=0;
		Scanner sc=new Scanner(System.in);
	try
	{
		con=JdbcUtility.getConnection();
	    pst=con.prepareStatement(QueryConstants.PINSERT_QUERY);	    
	   System.out.println("Enter student Number");
	   int sno=sc.nextInt();
	   pst.setInt(1,sno);
	   System.out.println("Enter student Name");
	   String sname=sc.next();
	   pst.setString(2,sname);
	   System.out.println("Enter student name");
	   String  sadd=sc.next();
	   pst.setString(3,sadd);
	   count=pst.executeUpdate();
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
				JdbcUtility.release(con,pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
