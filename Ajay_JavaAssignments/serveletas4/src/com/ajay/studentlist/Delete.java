package com.ajay.studentlist;

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

import com.aj_servelet.utility.ConnectionManager;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Delete() {
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
	String sname;
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		 sname =request.getParameter("name");
		 sname = sname.replace(" ","");
		 pw.println("s"+sname+"s");
		
		
		   
		   int count=0;
		   try {
			   con=ConnectionManager.getConnection();
			ps=con.prepareStatement("delete * from ass3$ where name=?;");
			 
			 
			 ps.setString(1, sname);
		
			 count=ps.executeUpdate();
			 if(count!=0)
				 pw.println(sname +"is Deleted from  the list");
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
		   finally
		   {
			   try {
					ConnectionManager.release(con,ps);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
		   pw.println("<a href='./View'>View All Data</a>");
		 
	}

}
