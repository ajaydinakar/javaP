package com.ajay.marchtwsev;
import com.ajay.dbconnect.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


/**
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public NewUser() {
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
	
		String name=request.getParameter("name");
		String father=request.getParameter("father");
		String course=request.getParameter("course");
		String sex=request.getParameter("sex");
		String add=request.getParameter("address");
		 
		
         int count=0;
		 
		   try {
			   con=ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into mar27ass1 values(?,?,?,?,?)");
			
			 ps.setString(1, name);
			 ps.setString(2, father);
			 ps.setString(3, course);
			 ps.setString(4, sex);
			 ps.setString(5, add);
			 
			 count=ps.executeUpdate();
			 if (count!=0)
			 {out.println("values inserted to database the valaues are");
			 out.println("name:"+name);
			 out.println("<br>");
				out.println("fathername:"+father);
				out.println("<br>");
					out.println("course:"+course);	
					out.println("<br>");
				out.println("sex:"+sex);
				 out.println("<br>");
				out.println("address:"+add);
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
						ConnectionManager.release(con,ps);;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   }
		
	}

}
