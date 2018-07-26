package com.aj_bank.authenticate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.aj_bank.main.BankManagementSystem;
import com.aj_bank.main.Banker;
import com.aj_bank.main.Customer;
import com.aj_bank.utility.ConnectionManager;


public class Authenticate {
	public  void authenticateBanker()
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
			       pst.setString(2, pword);
			       count = pst.executeUpdate();	
			    
			if(count!=0)
			{
				System.out.println("Successfully Logged in....");
				Banker.bankerMenu();;
				
			}else{
		        System.out.println("login unsucessful");
		        BankManagementSystem.main(null);
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
	public  void authenticateCustomer()
	{
		Customer c= new Customer();
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
			pst=con.prepareStatement("select * from customer where name=? and pwd =?");
			       pst.setString(1,uname);
			       pst.setString(2, pword);
			       count = pst.executeUpdate();	
			    
			if(count!=0)
			{
				System.out.println("Successfully Logged in....");
				c.customerMenu(uname,pword);
				
			}else{
		        System.out.println("login unsucessful");
		        BankManagementSystem.main(null);
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
