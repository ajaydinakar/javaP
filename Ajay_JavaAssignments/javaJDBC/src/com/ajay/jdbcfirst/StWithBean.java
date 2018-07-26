package com.ajay.jdbcfirst;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import com.ajay.StuBean.StuBean;
import com.ajay.jdbcutility.JdbcUtility;
import com.ajay.query.QueryConstants;

public class StWithBean {
	
	static void displayDetails(ArrayList<StuBean> sb)
	{
		for(StuBean s:sb)
	 	System.out.println(s.getSno()+"\t"+s.getSname()+"\t"+s.getSadd());
		
	}
	public static void main(String [] args)
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ResultSetMetaData rd=null;
		 ArrayList<StuBean> al=new ArrayList<StuBean>();
	try
	{
		con=JdbcUtility.getConnection();
	    st=con.createStatement();
	    rs =st.executeQuery(QueryConstants.SELECT_QUERY);
	    rd=rs.getMetaData();
	    System.out.println(rd.getColumnLabel(1)+"\t"+rd.getColumnLabel(2)+"\t"+rd.getColumnLabel(3));
	    while(rs.next())
	    {
	    StuBean sb=new StuBean();
	    sb.setSno(rs.getInt(1));
	    sb.setSname(rs.getString(2));
	    sb.setSadd(rs.getString(3));
	    al.add(sb);
	    //System.out.println(sb.getSno()+"\t"+sb.getSname()+"\t"+sb.getSadd());
	    	
	    }
	    displayDetails(al);
	    
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
