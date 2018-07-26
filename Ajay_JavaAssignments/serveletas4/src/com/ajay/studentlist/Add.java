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

import com.aj_servelet.utility.ConnectionManager;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Add() {
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
		try {
			ConnectionManager.release(con,ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		   String sname;
		   String spwd;
		   String email;
		   String sex;
		   String country;
		   int count=0;
		   try {
			ps=con.prepareStatement("insert into stulist values(?,?,?,?,?);");
			 sname =request.getParameter("name");
			 spwd=request.getParameter("pwd");
			 email=request.getParameter("email");
			 sex=request.getParameter("sex");
			 country=request.getParameter("country");
			 ps.setString(1, sname);
			 ps.setString(2, spwd);
			 ps.setString(3, email);
			 ps.setString(4, sex);
			 ps.setString(5, country);
			 count=ps.executeUpdate();
			 if(count!=0)
			 {
				 pw.println("<h2>Records successfully saved</h2>");
				 pw.println("<a href='view.html'>View all Records</a>");
				 pw.println("<p>Add New User</p>");
				 pw.println("<html>");
				 pw.println("<head>");
								 pw.println("<title>Insert title here</title>");
				 pw.println("</head>");
						 pw.println("<body>");
								 pw.println("<fieldset>");

    pw.println("<legend>Login form</legend>");
	pw.println("<form action=\".Add\" method=\"post\">");
	pw.println("<label for=\"name\">User Name</label>");
		pw.println("	<input type=\"text\" name=\"name\"><br>");
	pw.println("<label for=\"pwd\">Password</label>");
		pw.println("	<input type=\"text\" name=\"pwd\"><br>");
		pw.println("	<label for=\"email\">Email</label>");
		pw.println("	<input type=\"text\" name=\"email\"><br>");
		pw.println("	<input type=\"checkbox\" name=\"sex\" value =\"male\">male<br>");
		pw.println("	<input type=\"checkbox\" name=\"sex\" value =\"female\">female<br>");
		pw.println("	<label for=\"country\">Country</label>");
		pw.println("	<input type=\"text\" name=\"country\"><br>");
		pw.println("<input type=\"submit\" name=\"button\" value=\"Submit\">	");	
	pw.println("	</form>");
	pw.println("	<a href=\"http://localhost:8081/ajay_studentlistAssign/\"><button>Main Menu</button></a>");
pw.println(" </fieldset>");
pw.println("</body>");
pw.println("</html>");
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
					con=ConnectionManager.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
		 
	}

}
