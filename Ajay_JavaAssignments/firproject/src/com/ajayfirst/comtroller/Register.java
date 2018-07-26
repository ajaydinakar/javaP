package com.ajayfirst.comtroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.aj_servelet.utility.ConnectionManager;

/**
 * Servlet implementation class RetriveServelet
 */
@WebServlet("/Register")
public class Register extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con=null;
    PreparedStatement ps=null;  
    ResultSet rs=null;
    int sno=0;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 try {
				con=ConnectionManager.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		   System.out.println("destroy executing");
		
	}
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter pw=response.getWriter();
		 
		   String sname;
		   String spwd;
		   String email;
		   int count=0;
		   try {
			ps=con.prepareStatement("insert into login values(?,?,?)");
			 sname =request.getParameter("uname");
			 spwd=request.getParameter("pwd");
			 email=request.getParameter("emai");
			 ps.setString(1, sname);
			 ps.setString(2, spwd);
			 ps.setString(3, email);
			 count=ps.executeUpdate();
			 if(count!=0)
				 System.out.println("values inserted");
			 else
				 System.out.println("something wrong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   try {
				ConnectionManager.release(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   pw.println("<a href='first.html'>Login page</a>");
		  
		  
	}

}
