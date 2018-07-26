package com.aj_bank.banker.dao;
import com.aj_bank.utility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aj_bank.customer.bean.CustomerBean;




public class BankerDaoImpl implements BankerDao {

	@Override
	public int addCustomer() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int count=0;
		CustomerBean c=new CustomerBean();
		Scanner sc=new Scanner(System.in);
	try
	{
		con=ConnectionManager.getConnection();
	    pst=con.prepareStatement("insert into customer values(?,?,?,?,?)");	    
	   System.out.println("Enter customer Id Number");
	c.setId(sc.nextInt());
	  System.out.println("Enter customer accno");
     c.setAccountno(sc.nextInt());
	   System.out.println("Enter customer Name");
	c.setName(sc.next());
	   System.out.println("Enter customer password");
	 c.setPasswd(sc.next());
	   System.out.println("Enter customer balance");
	 c.setBalance(sc.nextInt());
	 

	   
	   pst.setInt(1, c.getId());
	   pst.setInt(2, c.getAccountno());
	   pst.setString(3, c.getName());
	   pst.setString(4, c.getPasswd());
	   pst.setInt(5, c.getBalance());
	   
	  
	   
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
			ConnectionManager.release(con,pst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return 0;
	}

	@Override
	public void editCustomer() {
		// TODO Auto-generated method stub
		int count = 0;
		Connection con=null;
		PreparedStatement pst=null;
		Scanner sc=new Scanner(System.in);
		try
		{
			con =  ConnectionManager.getConnection();
			System.out.println("Enter Which Student Id you want to Update");
			int Id=sc.nextInt();
			System.out.println("Select Which Field your want Update \n 1.customer Id 2..customer account no 3.Customer Name 4. Customer Password "
					+" 5.customer balance ");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:pst = con.prepareStatement("update customer set id=? where name=?" );
			System.out.println("Enter Which Student Id you want to Update");
			String nam=sc.next();
			       System.out.println("Enter Updated roll no ?");
			       pst.setInt (1,sc.nextInt());
			       pst.setString(2,nam);
			       count = pst.executeUpdate();
			       break;
			case 2: pst = con.prepareStatement("update customer set accno=? where id=?" );
		       System.out.println("Enter Updated Student Name ?");
		       pst.setInt (1,sc.nextInt());
		       pst.setInt(2,Id);
		       count = pst.executeUpdate();
		       break;
			case 3:pst = con.prepareStatement("update customer set name=? where id=?" );
		       System.out.println("Enter Updated Student email ?");
		       pst.setString (1,sc.next());
		       pst.setInt(2,Id);
		       count = pst.executeUpdate();
		       break;
			case 4:pst = con.prepareStatement("update customer set pwd=? where id=?" );
		       System.out.println("Enter Updated customer password ?");
		       pst.setString (1,sc.next());
		       pst.setInt(2,Id);
		       count = pst.executeUpdate();
		       break;
			case 5:pst = con.prepareStatement("update customer set balance=? where id=?" );
		       System.out.println("Enter Updated customer Balance ?");
		       pst.setInt (1,sc.nextInt());
		       pst.setInt(2,Id);
		       count = pst.executeUpdate();
		       break;
			
			default:
	           System.out.println("wrong choice ");
	          
			      
			}
			if(count!=0)
			{
				System.out.println("Successfully Updated Record....");
			}else{
		        System.out.println("Please try again some thing goes wrong Opps!...");
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
		
		
		
	}

	@Override
	public List<CustomerBean> viewCustomers() {
		
		// TODO Auto-generated method stub
		
		
		ArrayList<CustomerBean> customers =new ArrayList<CustomerBean>();
		Connection con=null;
		int count=0;
		Statement pst=null;
		
	
		ResultSet rs=null;
		ResultSetMetaData rd=null;
		try{
			con=ConnectionManager.getConnection();
			pst=con.createStatement();
			rs=pst.executeQuery("select * from customer order by id");
			rd=rs.getMetaData();
		    System.out.println(rd.getColumnLabel(1)+"\t"+rd.getColumnLabel(2)+"\t"+rd.getColumnLabel(3)+"\t"+rd.getColumnLabel(4)+"\t"
			+rd.getColumnLabel(5)	);
		
					while(rs.next())
					{
						CustomerBean s=new CustomerBean();
						s.setId(rs.getInt(1));
						s.setAccountno(rs.getInt(2));
						s.setName(rs.getString(3));
						s.setPasswd(rs.getString(4));
						s.setBalance(rs.getInt(5));
					
					customers.add(s);
					System.out.println(s.getId()+"\t"+s.getAccountno()+"\t"+s.getName()+"\t"+s.getPasswd()+"\t"+s.getBalance());
					}
					//displayDetails(students);
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
		
		
		return null;
		
	}

	@Override
	public void minimumBalance() {
		// TODO Auto-generated method stub
		ArrayList<CustomerBean> customers =new ArrayList<CustomerBean>();
		Connection con=null;
		int count=0;
		Statement pst=null;
		
	
		ResultSet rs=null;
		ResultSetMetaData rd=null;
		try{
			con=ConnectionManager.getConnection();
			pst=con.createStatement();
			rs=pst.executeQuery("select * from customer where balance < 500");
			rd=rs.getMetaData();
		    System.out.println(rd.getColumnLabel(1)+"\t"+rd.getColumnLabel(2)+"\t"+rd.getColumnLabel(3)+"\t"+rd.getColumnLabel(4)+"\t"
			+rd.getColumnLabel(5)	);
		
					while(rs.next())
					{
						CustomerBean s=new CustomerBean();
						s.setId(rs.getInt(1));
						s.setAccountno(rs.getInt(2));
						s.setName(rs.getString(3));
						s.setPasswd(rs.getString(4));
						s.setBalance(rs.getInt(5));
					
					customers.add(s);
					System.out.println(s.getId()+"\t"+s.getAccountno()+"\t"+s.getName()+"\t"+s.getPasswd()+"\t"+s.getBalance());
					}
					//displayDetails(students);
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

}
