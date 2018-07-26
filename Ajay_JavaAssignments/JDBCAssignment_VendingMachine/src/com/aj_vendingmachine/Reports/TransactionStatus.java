package com.aj_vendingmachine.Reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.aj_vendingmachine.dbutility.ConnectionManager;


public class TransactionStatus {
	public static void transactionStatus(){
		System.out.println("--------------------------------");
		System.out.println("        E -Coffee Vendor        ");
		System.out.println("         transaction status       ");
		System.out.println("--------------------------------");

		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ResultSetMetaData rd=null;
		 int tot=0;
	try
	{
		con=ConnectionManager.getConnection();
	    st=con.createStatement();
	   String type=null;
	   int quantity=0;
	  int price=0;

	    rs =st.executeQuery("select * from vendor");
	    rd=rs.getMetaData();
	    System.out.println(rd.getColumnLabel(1)+"\t\t"+rd.getColumnLabel(2)+"\t\t"+rd.getColumnLabel(3)+"\t ");
	    while(rs.next())
	    {
	    type=rs.getString(1);
	    quantity=rs.getInt(2);
	    price=rs.getInt(3);
	    System.out.println(type+"coffee \t"+quantity+"\t"+price);
	    tot=tot+price;	
	    }
	    
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
	
	
		System.out.println("|-------------------------------------------------- |");
		System.out.println("                                        total  |"+tot);
		System.out.println("|---------------------------------------------------|");
		System.out.println("              Press any key to continue  ");
	
	}
}
