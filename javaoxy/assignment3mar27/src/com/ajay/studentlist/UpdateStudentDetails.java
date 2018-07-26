package com.ajay.studentlist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.ajay.dbconnect.ConnectionManager;

/**
 * Servlet implementation class UpdateStudentDetails
 */
@WebServlet("/UpdateStudentDetails")
public class UpdateStudentDetails extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public UpdateStudentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con=null;
    PreparedStatement ps=null;
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
		PrintWriter pw=response.getWriter();
		
		
		   String sname;
		   String spwd;
		   String email;
		   String sex;
		   String country;
		   int count=0;
		   sname =request.getParameter("name");
		   try {
			   con=ConnectionManager.getConnection();
			ps=con.prepareStatement("update stulist set password=?,email=?,sex=?,country=? where name=?");
			 
			 spwd=request.getParameter("pwd");
			 email=request.getParameter("email");
			 sex=request.getParameter("sex");
			 country=request.getParameter("country");
			 ps.setString(5, sname);
			 ps.setString(1, spwd);
			 ps.setString(2, email);
			 ps.setString(3, sex);
			 ps.setString(4, country);
			 count=ps.executeUpdate();
			 if(count!=0)
			 {
				 pw.println("<h2>Records successfully saved</h2>");
			 }
			 else
				 System.out.println("something wrong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		   pw.println("<a href=\"home.html\">Go to home</a>");
		   pw.println("<a href=\"./ViewRecords\">View All Records</a>");
	}

}
