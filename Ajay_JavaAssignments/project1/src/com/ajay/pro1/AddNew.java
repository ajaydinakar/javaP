package com.ajay.pro1;

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
 * Servlet implementation class AddNew
 */
@WebServlet(description = "adds new person to database", urlPatterns = { "/AddNew" })
public class AddNew extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public AddNew() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("name:");
		/*String name=request.getParameter("name");
		String father=request.getParameter("father");
		String course[]=request.getParameterValues("course");
		String sex=request.getParameter("sex");
		String add=request.getParameter("address");
		
		out.println("name:"+name);
		out.println("father name:"+father);
		
		for(String s:course)
		{
			out.println("course:"+s);	
		}
		
		out.println("sex:"+sex);
		out.println("address:"+add);
		*/
		 /*  String sname;
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
	}
		   catch (SQLException e) {
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
			   }*/
}
	}
