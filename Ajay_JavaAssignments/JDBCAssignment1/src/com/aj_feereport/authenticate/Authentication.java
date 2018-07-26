package com.aj_feereport.authenticate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.aj_feereport.main.AccountantMenu;
import com.aj_feereport.main.AdminMenu;
import com.aj_feereport.main.FeeReportManagemntSystem;
import com.aj_feereport.utility.ConnectionManager;

public class Authentication {
	public  void authenticateAdmin()
	{
		Scanner in=new Scanner(System.in);
		String uname="",pword="";
		System.out.print("Enter the Username: ");
	    uname=in.next();
		System.out.print("Enter the Password: ");
	    pword=in.next();
		int count = 0;
		Connection con=null;
		PreparedStatement pst=null;	
		try
		{
			con = ConnectionManager.getConnection();
			pst=con.prepareStatement("select * from admin where name=? and pwd =?");
			       pst.setString(1,uname);
			       pst.setString(2,pword);
			       count = pst.executeUpdate();	
			    
			if(count!=0)
			{
				System.out.println("Successfully Logged in....");
				AdminMenu.adminMenu();
				
			}else{
		        System.out.println("login unsucessful");
		        FeeReportManagemntSystem.main(null);
			}
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				ConnectionManager.release(con,pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	in.close();
	}
	public  void authenticateAccountant()
	{
	
		Scanner in=new Scanner(System.in);
		String uname="",pword="";
		System.out.print("Enter the Username: ");
	    uname=in.next();
		System.out.print("Enter the Password: ");
	    pword=in.next();
		int count = 0;
		Connection con=null;
		PreparedStatement pst=null;	
		try
		{
			con = ConnectionManager.getConnection();
			pst=con.prepareStatement("select * from actnt where name=? and pwd =?");
			       pst.setString(1,uname);
			       pst.setString(2, pword);
			       count = pst.executeUpdate();	
			    
			if(count!=0)
			{
				System.out.println("Successfully Logged in....");
				AccountantMenu.acountntMenu();
				
			}else{
		        System.out.println("login unsucessful");
		        FeeReportManagemntSystem.main(null);
			}
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				ConnectionManager.release(con,pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	in.close();
	}
}
