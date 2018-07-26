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
 * Servlet implementation class Forget
 */
@WebServlet("/Forget")
public class Forget extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Forget() {
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
		
		 
		   int count=0;
		   try {
			ps=con.prepareStatement("select * from login where name=? ");
			 sname =request.getParameter("name");
	
			
			 ps.setString(1, sname);
		
	
			 count=ps.executeUpdate();
			 if(count!=0){
				 pw.println("you are a valid user");
			 pw.println("<a href='forget.html'>go to login</a>");
			 }
			 else{
				 pw.println("you are not valid user ,please register");
				 pw.println("<a href='retrive.html'>go to retrive</a>");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  pw.println("<a href='forget.html'>try again</a>");
	  pw.println("<a href='retrive.html'>register </a>");
	}

}
