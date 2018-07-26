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
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public DeleteStudent() {
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
PrintWriter out=response.getWriter();		
		String studentname=request.getParameter("name");
         int count=0;
		 
		   try {
			   con=ConnectionManager.getConnection();
			    ps=con.prepareStatement("delete from stulist where  name=? ");
			    ps.setString(1, studentname); 
			 count=ps.executeUpdate();
			 if (count!=0)
			 {
				 out.println(studentname+"was deleted from Records ");
			}
			 else
			 {
				 out.println("something went wrong");
			 }
	}
		   catch (SQLException e) {
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
		   out.println("<a href=\"home.html\">Go to home</a>");
		   out.println("<a href=\"./ViewRecords\">View All Records</a>");
	}

}
