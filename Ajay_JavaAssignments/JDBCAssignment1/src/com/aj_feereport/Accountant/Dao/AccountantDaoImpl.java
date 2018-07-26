package com.aj_feereport.Accountant.Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aj_feereport.Accountant.bean.AccountantBean;
import com.aj_feereport.student.bean.StudentBean;
import com.aj_feereport.utility.ConnectionManager;

public class AccountantDaoImpl implements AccountantDao {

	//@Override2
	public int addAccountant() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Connection con=null;
				PreparedStatement pst=null;
				int count=0;
				AccountantBean accountant=new AccountantBean();
				Scanner sc=new Scanner(System.in);
			try
			{
				con=ConnectionManager.getConnection();
			    pst=con.prepareStatement("insert into actnt  values(?,?,?,?,? )");	    
			   System.out.println("Enter Accountant Id Number");
			   int id=sc.nextInt();
			accountant.setId(id);
			   System.out.println("Enter Accountant Name");
			   String name=sc.next();
			accountant.setName(name);
			 System.out.println("Enter Accountant Password");
			 String pwd=sc.next();
				accountant.setPassword(pwd);
			   System.out.println("Enter Accountant email");
			   String email=sc.next();
			  accountant.setEmail(email);
			   System.out.println("contact number");
			   String ph=sc.next();
			  accountant.setPhone(ph); 
			 // System.out.println(accountant.getId()+accountant.getName()+accountant.getPassword()+accountant.getPassword()+accountant.getPhone());
			   
			   pst.setInt(1, accountant.getId());
			   pst.setString(2, accountant.getName());
			   pst.setString(3, accountant.getPassword());
			   pst.setString(4, accountant.getEmail());
			   pst.setString(5, accountant.getPhone());
			  
			   
			   count=pst.executeUpdate();
			   
			    if(count!=0)
			    	System.out.println("Accountated details added successfully");
			    else
			    	System.out.println("Query failed");
			}
			catch(SQLException e)
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
		
				return 0;
	}

	@Override
	public List<AccountantBean> viewAccountants() {
		// TODO Auto-generated method stub
		
		ArrayList<AccountantBean> accountants=new ArrayList<AccountantBean>();
		Connection con=null;
		int count=0;
		Statement pst=null;
		
		ResultSet rs=null;
		ResultSetMetaData rd=null;
		
		try{
			con=ConnectionManager.getConnection();
			pst=con.createStatement();
			rs=pst.executeQuery("select * from actnt");
			rd=rs.getMetaData();
		    System.out.println(rd.getColumnLabel(1)+"\t"+rd.getColumnLabel(2)+"\t"+rd.getColumnLabel(3)+"\t"+rd.getColumnLabel(4)+"\t"+rd.getColumnLabel(5));
					while(rs.next())
					{
			    AccountantBean a=new AccountantBean();
				a.setId(rs.getInt(1));
			    a.setName(rs.getString(2));
				a.setEmail(rs.getString(3));
				a.setPassword(rs.getString(4));
			    a.setPhone(rs.getString(5));
					System.out.println(a.getId()+"\t"+a.getName()+"\t"+a.getPassword()+"\t"+a.getEmail()+"\t"+a.getPhone());	
					accountants.add(a);
					}
					//System.out.println(accountants);
				//	displayDetails(accountants);
		}		
		catch(SQLException e)
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
		
		return accountants;
	}
	static void displayDetails(ArrayList<AccountantBean> sb)
	{
	
		for(AccountantBean s:sb){
	 	System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getPassword()+"\t"+s.getEmail()+"\t"+s.getPhone());
		//System.out.println(s.toString());
		}
	}

}
