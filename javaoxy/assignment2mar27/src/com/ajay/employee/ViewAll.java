package com.ajay.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.ajay.dbconnect.ConnectionManager;

/**
 * Servlet implementation class ViewAll
 */
@WebServlet("/ViewAll")
public class ViewAll extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ViewAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	ResultSetMetaData rd=null;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try
		{
			con=ConnectionManager.getConnection();
		    st=con.createStatement();
		   String eno=null;
		   String ename=null;
		   String eadd=null;
		    rs =st.executeQuery("select * from mar27ass2");
		    rd=rs.getMetaData();
		    out.println("<table>");
		    out.println("<tr>");		   
		    out.println("<th>");
		    out.println(rd.getColumnLabel(1));
		    out.println("</th>");
		    out.println("<th>");
		    out.println(rd.getColumnLabel(2));
		    out.println("</th>");
		    out.println("<th>");
		    out.println(rd.getColumnLabel(3));
		    out.println("</th>");
		  
		    out.println("</tr>");
	
		    while(rs.next())
		    {
		    	  eno=rs.getString(1);
				    ename=rs.getString(2);
				    eadd=rs.getString(3);
		    	out.println("<tr>");
			    out.println("<td>");
			    out.println(eno);
			    out.println("</td>");
			    out.println("<td>");
			    out.println(ename);
			    out.println("</td>");
			    out.println("<td>");
			    out.println(eadd);
			    out.println("</td>");
			    out.println("</tr>");    
			    
		    }
		    out.println("</table>");
		    
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
		out.println("<a href=\"add.html\">Go to home</a>");
	}

}
