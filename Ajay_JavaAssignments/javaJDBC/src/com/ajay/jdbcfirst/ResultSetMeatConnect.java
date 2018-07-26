package com.ajay.jdbcfirst;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import com.ajay.jdbcutility.JdbcUtility;
import com.ajay.query.QueryConstants;
public class ResultSetMeatConnect {
	public static void main(String [] args)
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ResultSetMetaData rd=null;
	try
	{
		con=JdbcUtility.getConnection();
	    st=con.createStatement();
	   int sno=0;
	   String sname=null;
	   String sadd=null;
	    rs =st.executeQuery(QueryConstants.SELECT_QUERY);
	    rd=rs.getMetaData();
	    System.out.println(rd.getColumnLabel(1)+"\t"+rd.getColumnLabel(2)+"\t"+rd.getColumnLabel(3));
	    while(rs.next())
	    {
	    sno=rs.getInt(1);
	    sname=rs.getString(2);
	    sadd=rs.getString(3);
	    System.out.println(sno+"\t"+sname+"\t"+sadd);
	    	
	    }
	    
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
