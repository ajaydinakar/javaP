package com.aj_feereport.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.aj_feereport.student.bean.StudentBean;
import com.aj_feereport.utility.ConnectionManager;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int addStudent() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int count=0;
		StudentBean student=new StudentBean();
		Scanner sc=new Scanner(System.in);
	try
	{
		con=ConnectionManager.getConnection();
	    pst=con.prepareStatement("insert into stu values(?,?,?,?,?,?,?,?,?,?,?,?)");	    
	   System.out.println("Enter student Roll Number");
	student.setStuRoll(sc.nextInt());
	   System.out.println("Enter student Name");
	student.setName(sc.next());
	   System.out.println("Enter student email");
	  student.setEmail(sc.next());
	   System.out.println("Enter student course i:e; jaa/UI/Devops");
	  student.setCourse(sc.next());
	   System.out.println("Enter student Fee");
	 student.setFee(sc.nextInt());
	   System.out.println("Enter student paid");
	   student.setPaid(sc.nextInt());
	   student.setDue(student.getFee()-student.getPaid());
	   System.out.println("Enter student Address");
	   student.setAddress(sc.next());
	   System.out.println("Enter student city");
	   student.setCity(sc.next());
	   System.out.println("Enter student state");
	   student.setState(sc.next());
	   System.out.println("Enter student country");
	   student.setCountry(sc.next());
	   System.out.println("Enter student Phone Num");
	   student.setPhone(sc.next());
	   
	   pst.setInt(1, student.getStuRoll());
	   pst.setString(2, student.getName());
	   pst.setString(3, student.getEmail());
	   pst.setString(4, student.getCourse());
	   pst.setInt(5, student.getFee());
	   pst.setInt(6, student.getPaid());
	   pst.setInt(7, student.getDue());
	   pst.setString(8, student.getAddress());
	   pst.setString(9, student.getCity());
	   pst.setString(10, student.getState());
	   pst.setString(11, student.getCountry());
	   pst.setInt(12, student.getStuRoll());
	   
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
	public void viewStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StudentBean> viewStudents() {
		// TODO Auto-generated method stub
		ArrayList<StudentBean> students =new ArrayList<StudentBean>();
		Connection con=null;
		int count=0;
		Statement pst=null;
		
	
		ResultSet rs=null;
		ResultSetMetaData rd=null;
		try{
			con=ConnectionManager.getConnection();
			pst=con.createStatement();
			rs=pst.executeQuery("select * from stu");
			rd=rs.getMetaData();
		    System.out.println(rd.getColumnLabel(1)+"\t"+rd.getColumnLabel(2)+"\t"+rd.getColumnLabel(3)+"\t"+rd.getColumnLabel(4)+"\t"+rd.getColumnLabel(5)
		    		+"\t"+rd.getColumnLabel(6)+"\t"+rd.getColumnLabel(7)+"\t"+rd.getColumnLabel(8)+"\t"+rd.getColumnLabel(9)+"\t"+rd.getColumnLabel(10)
		    		+"\t"+rd.getColumnLabel(11)+"\t"+rd.getColumnLabel(12));
		
					while(rs.next())
					{
						StudentBean s=new StudentBean();
						s.setStuRoll(rs.getInt(1));
						s.setName(rs.getString(2));
						s.setEmail(rs.getString(3));
						s.setCourse(rs.getString(4));
						s.setFee(rs.getInt(5));
						s.setPaid(rs.getInt(6));
						s.setDue(rs.getInt(7));
						s.setAddress(rs.getString(8));
						s.setCity(rs.getString(9));
						s.setState(rs.getString(10));
						s.setCountry(rs.getString(11));
						s.setPhone(rs.getString(12));
					students.add(s);
					System.out.println(s.getStuRoll()+"\t"+s.getName()+"\t"+s.getEmail()+"\t"+s.getCourse()+"\t"+s.getFee()+"\t"+s.getPaid()+"\t"+s.getDue()+"\t"+s.getAddress()+"\t"+s.getCity()+
							"\t"+s.getState()+"\t"+s.getCountry()+"\t"+s.getPhone());
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
	public void editStudent() {
		// TODO Auto-generated method stub
		
		int count = 0;
		Connection con=null;
		PreparedStatement pst=null;
		Scanner sc=new Scanner(System.in);
		try
		{
			con =  ConnectionManager.getConnection();
			System.out.println("Enter Which Student Id you want to Update");
			int studId=sc.nextInt();
			System.out.println("Select Which Field your want Update \n 1.rollno 2.Name 3.email 4.course 5.fee 6.paid 7.due 8.address"
					+ "\t 9. city 10.state 11. country 12.phone");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:pst = con.prepareStatement("update stu set roll=? where name=?" );
			System.out.println("Enter Which Student Id you want to Update");
			String nam=sc.next();
			       System.out.println("Enter Updated roll no ?");
			       pst.setInt (1,sc.nextInt());
			       pst.setString(2,nam);
			       count = pst.executeUpdate();
			       break;
			case 2: pst = con.prepareStatement("update stu set name=? where roll=?" );
		       System.out.println("Enter Updated Student Name ?");
		       pst.setString (1,sc.next());
		       pst.setInt(2,studId);
		       count = pst.executeUpdate();
		       break;
			case 3:pst = con.prepareStatement("update stu set email=? where roll=?" );
		       System.out.println("Enter Updated Student email ?");
		       pst.setString (1,sc.next());
		       pst.setInt(2,studId);
		       count = pst.executeUpdate();
		       break;
			case 4:pst = con.prepareStatement("update stu set course=? where roll=?" );
		       System.out.println("Enter Updated Student course ?");
		       pst.setString (1,sc.next());
		       pst.setInt(2,studId);
		       count = pst.executeUpdate();
		       break;
			case 5:pst = con.prepareStatement("update stu fee=? where roll=?" );
		       System.out.println("Enter Updated Student fee ?");
		       pst.setInt (1,sc.nextInt());
		       pst.setInt(2,studId);
		       count = pst.executeUpdate();
		       break;
			case 6:pst = con.prepareStatement("update stu set paid=? where roll=?" );
		       System.out.println("Enter Updated Student paid amount ?");
		       pst.setInt (1,sc.nextInt());
		       pst.setInt(2,studId);
		       count = pst.executeUpdate();
		       break;
			case 7:pst = con.prepareStatement("update stu set due=? where roll=?" );
		       System.out.println("Enter Updated Student due ?");
		       pst.setInt (1,sc.nextInt());
		       pst.setInt(2,studId);
		       count = pst.executeUpdate();
		       break;
			case 8:pst = con.prepareStatement("update stu set address=? where roll=?" );
		       System.out.println("Enter Updated Student address ?");
		       pst.setString (1,sc.next());
		       pst.setInt(2,studId);
		       count = pst.executeUpdate();
		       break;
			case 9:pst = con.prepareStatement("update stu set city=? where roll=?" );
		       System.out.println("Enter Updated Student city ?");
		       pst.setString (1,sc.next());
		       pst.setInt(2,studId);
		       count = pst.executeUpdate();
		       break;
			case 10:pst = con.prepareStatement("update stu set state=? where roll=?" );
		       System.out.println("Enter Updated Student state ?");
		       pst.setString (1,sc.next());
		       pst.setInt(2,studId);
		       count = pst.executeUpdate();
		       break;
			case 11:pst = con.prepareStatement("update stu set country=? where roll=?" );
		       System.out.println("Enter Updated Student country ?");
		       pst.setString (1,sc.next());
		       pst.setInt(2,studId);
		       count = pst.executeUpdate();
		       break;
			case 12:pst = con.prepareStatement("update stu set phone=? where roll=?" );
		       System.out.println("Enter Updated  ?");
		       pst.setString (1,sc.next());
		       pst.setInt(2,studId);
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
		}finally{
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void duefee() {
		// TODO Auto-generated method stub
		ArrayList<StudentBean> students =new ArrayList<StudentBean>();
		Connection con=null;
		int count=0;
		Statement pst=null;
		
	
		ResultSet rs=null;
		ResultSetMetaData rd=null;
		try{
			con=ConnectionManager.getConnection();
			pst=con.createStatement();
			rs=pst.executeQuery("select * from stu where due > 0");
			rd=rs.getMetaData();
		    System.out.println(rd.getColumnLabel(1)+"\t"+rd.getColumnLabel(2)+"\t"+rd.getColumnLabel(3)+"\t"+rd.getColumnLabel(4)+"\t"+rd.getColumnLabel(5)
		    		+"\t"+rd.getColumnLabel(6)+"\t"+rd.getColumnLabel(7)+"\t"+rd.getColumnLabel(8)+"\t"+rd.getColumnLabel(9)+"\t"+rd.getColumnLabel(10)
		    		+"\t"+rd.getColumnLabel(11)+"\t"+rd.getColumnLabel(12));
		
					while(rs.next())
					{
						StudentBean s=new StudentBean();
						s.setStuRoll(rs.getInt(1));
						s.setName(rs.getString(2));
						s.setEmail(rs.getString(3));
						s.setCourse(rs.getString(4));
						s.setFee(rs.getInt(5));
						s.setPaid(rs.getInt(6));
						s.setDue(rs.getInt(7));
						s.setAddress(rs.getString(8));
						s.setCity(rs.getString(9));
						s.setState(rs.getString(10));
						s.setCountry(rs.getString(11));
						s.setPhone(rs.getString(12));
					students.add(s);
					System.out.println(s.getStuRoll()+"\t"+s.getName()+"\t"+s.getEmail()+"\t"+s.getCourse()+"\t"+s.getFee()+"\t"+s.getPaid()+"\t"+s.getDue()+"\t"+s.getAddress()+"\t"+s.getCity()+
							"\t"+s.getState()+"\t"+s.getCountry()+"\t"+s.getPhone());
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
		
		
		//return null;

	}
	static void displayDetails(ArrayList<StudentBean> sb)
	{
		for(StudentBean s:sb)
	 	System.out.println(s.toString());
		
	}

}
