package com.aj_bank.customer.dao;
import com.aj_bank.customer.bean.CustomerBean;
import com.aj_bank.utility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



public class CustomerDaoImpl implements CustomerDao {
   static String nm,pw;
    static int balance;
	public int addDeposit(String nm,String pw) {
		// TODO Auto-generated method stub
		balance=getbalance(nm, pw);
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the amount to deposit : ");
		int deposit=in.nextInt();
		
		int newbalance=balance+deposit;
		int count = 0;
		Connection con=null;
		PreparedStatement pst=null,pst2=null;
		
		try
		{
			con = ConnectionManager.getConnection();
			pst=con.prepareStatement("update customer set balance=? where name=? and pwd =?");
			//pst2=con.prepareStatement("update customer set balance=? where name=? and pwd =?");
			       pst.setInt (1,newbalance);
			       pst.setString(2,nm);
			       pst.setString(3, pw);
			       count = pst.executeUpdate();
			 
			if(count!=0)
			{
				System.out.println("Successfully Depositied....");
			}else{
		        System.out.println("Please try again,if any thing wrong contact bank");
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
		return 0;
	}
	public int transferAmount(String nm,String pw) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the amount to transfer : ");
		int transferAmt=in.nextInt();
		System.out.print("Enter the  reciepient name : ");
		String reciepient=in.next();
		System.out.print("Enter the reciepient account number: ");
		int racc=in.nextInt();
		balance=getbalance(nm, pw);	
		int recepBalance=getRecepBalance(reciepient, racc);
		int newbalance=balance-transferAmt;
		int newrecepBal=recepBalance+transferAmt;
		int count = 0,count2=0;
		Connection con=null;
		PreparedStatement pst=null,pst2=null;
		
		try
		{
			con = ConnectionManager.getConnection();
			pst=con.prepareStatement("update customer set balance=? where name=? and pwd =?");
			pst2=con.prepareStatement("update customer set balance=? where name=? and accno =?");
			       pst.setInt (1,newbalance);
			       pst.setString(2,nm);
			       pst.setString(3, pw);
			       pst2.setInt (1,newrecepBal);
			       pst2.setString(2,reciepient);
			       pst2.setInt(3,racc);
			      // pst.setString(2,nam);
			       count = pst.executeUpdate();
			       count2=pst2.executeUpdate();
			 
			if(count!=0)
			{if(count2!=0){
				System.out.println("Tranction Successfull ");
			}else
			{System.out.println("reciepient didnt got money,please contact bank");}
			}else{
		        System.out.println("Please try again,if any thing wrong contact bank");
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
		return 0;
	}

	public int withdrawAmount(String nm,String pw) {
		// TODO Auto-generated method stub
		balance=getbalance(nm, pw);
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the amount to withdraw : ");
		int withdraw=in.nextInt();
		
		int newbalance=balance-withdraw;
		int count = 0;
		Connection con=null;
		PreparedStatement pst=null,pst2=null;
		
		try
		{
			con = ConnectionManager.getConnection();
			pst=con.prepareStatement("update customer set balance=? where name=? and pwd =?");
			pst2=con.prepareStatement("update customer set balance=? where name=? and accno=?");
			       pst.setInt (1,newbalance);
			       pst.setString(2,nm);
			       pst.setString(3, pw);
			      // pst.setString(2,nam);
			       count = pst.executeUpdate();
			 
			if(count!=0)
			{
				System.out.println("Successfully withdrawn....");
			}else{
		        System.out.println("Please try again,if any thing wrong contact bank");
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

		return 0;
	}

	public void enqiry(String nm,String pw) {
		// TODO Auto-generated method stub
		

		// TODO Auto-generated method stub
		
		Connection con=null;
		int count=0;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ResultSetMetaData rd=null;
		try{
			con=ConnectionManager.getConnection();
			pst=con.prepareStatement("select * from customer where name=? and pwd=?");
			pst.setString(1, nm);
			pst.setString(2, pw);
             rs=pst.executeQuery();
             rd=rs.getMetaData();
             System.out.println(rd.getColumnLabel(1)+"\t"+rd.getColumnLabel(2)+"\t"+rd.getColumnLabel(3)+"\t"+rd.getColumnLabel(5));
					while(rs.next())
					{
						CustomerBean s=new CustomerBean();
						s.setId(rs.getInt(1));
						s.setAccountno(rs.getInt(2));
						s.setName(rs.getString(3));
						s.setPasswd(rs.getString(4));
						s.setBalance(rs.getInt(5));
					System.out.println(s.getId()+"\t"+s.getAccountno()+"\t"+s.getName()+"\t"+s.getBalance());
					}
			
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
		
	

	}
	public int getbalance(String nm,String pw)
	{	
		Connection con=null;
		int count=0;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ResultSetMetaData rd=null;
		int bal=0;
		try{
			con=ConnectionManager.getConnection();
			pst=con.prepareStatement("select * from customer where name=? and pwd=?");
			pst.setString(1, nm);
			pst.setString(2, pw);
             rs=pst.executeQuery();	
		
			while(rs.next())
			{
				CustomerBean s=new CustomerBean();
				s.setId(rs.getInt(1));
				s.setAccountno(rs.getInt(2));
				s.setName(rs.getString(3));
				s.setPasswd(rs.getString(4));
				s.setBalance(rs.getInt(5));
	          bal=s.getBalance();
			}
			
		}		
		catch(SQLException e)
		{
		e.printStackTrace();	
		}
			finally
			{
				try 
				{
					ConnectionManager.release(con,pst);
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
return bal;
	}
	public int getRecepBalance(String nm,int ac)
	{	
		Connection con=null;
		int count=0;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ResultSetMetaData rd=null;
		int recepbal=0;
		try{
			con=ConnectionManager.getConnection();
			pst=con.prepareStatement("select * from customer where name=? and accno=?");
			pst.setString(1, nm);
			pst.setInt(2, ac);
             rs=pst.executeQuery();	
		
			while(rs.next())
			{
				CustomerBean s=new CustomerBean();
				s.setId(rs.getInt(1));
				s.setAccountno(rs.getInt(2));
				s.setName(rs.getString(3));
				s.setPasswd(rs.getString(4));
				s.setBalance(rs.getInt(5));
				recepbal=s.getBalance();
			}
			
		}		
		catch(SQLException e)
		{
		e.printStackTrace();	
		}
			finally
			{
				try 
				{
					ConnectionManager.release(con,pst);
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
return recepbal;
	}


	
	}


