package com.ajay.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class Retrive
 */
@WebServlet("/Retrive")
public class Retrive extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Retrive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con=null;
    PreparedStatement ps=null;
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
		String no=null;
		String ename=null;
		String eadd=null;
		try
		{
			con=ConnectionManager.getConnection();
			 no=request.getParameter("empno");
			 ename=request.getParameter("empname");
		
		   
		   ps=con.prepareStatement("select * from mar27ass2 where eno=? or name=?");
		   ps.setString(1,no);
		   ps.setString(2, ename);
		    rs =ps.executeQuery();
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
		    no=rs.getString(1);
		    ename=rs.getString(2);
		    eadd=rs.getString(3);
		    
		    	
		    out.println("<tr>");
		    out.println("<td>");
		    out.println(no);
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
					ConnectionManager.release(con,ps);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		out.println("<a href=\"add.html\">Go to home</a>");
	}

}
