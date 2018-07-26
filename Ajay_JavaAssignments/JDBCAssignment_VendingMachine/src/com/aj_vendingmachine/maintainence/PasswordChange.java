package com.aj_vendingmachine.maintainence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.aj_vendingmachine.dbutility.ConnectionManager;

public class PasswordChange {
	public static void changePwd()
	{
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement pst=null;
		int count=0;
		try
		{
			con=ConnectionManager.getConnection();
			pst=con.prepareStatement("update admin set pwd=? where pwd=? ");
			System.out.println("Enter your current password");
			   String  oldpwd=sc.next();
			   pst.setString(2,oldpwd);
			   System.out.println("Enter your new password");
			   String  newpwd=sc.next();
			   pst.setString(1,newpwd);
			   count=pst.executeUpdate();
			    if(count!=0)
			    	System.out.println("password changed");
			    else
			    	System.out.println("password not changed");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con,pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
