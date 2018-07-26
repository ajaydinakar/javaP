package com.ajayfirst.comtroller;

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
 * Servlet implementation class FirstServelet
 */
@WebServlet("/Login")
public class Login extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("constructor executing");
    }

	/**  
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con=null;
    PreparedStatement ps=null;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		   System.out.println("init executing");
		   try {
			con=ConnectionManager.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		   System.out.println("destroy executing");
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   System.out.println("service executing");
	
		   PrintWriter pw=response.getWriter();
		 
		   String sname;
		   String spwd;
		 
		   int count=0;
		   try {
			ps=con.prepareStatement("select * from login where name=? and password=?");
			 sname =request.getParameter("name");
			 spwd=request.getParameter("pwd");
			
			 ps.setString(1, sname);
			 ps.setString(2, spwd);
		;
			 count=ps.executeUpdate();
			 if(count!=0)
				 pw.println("you are logged in");
			 else
				 pw.println("something wrong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  pw.println("<a href='first.html'>logout</a>");
		 //  pw.println("<a href='retrive.html'>link to retrive form</a>");
		  
	}

}
