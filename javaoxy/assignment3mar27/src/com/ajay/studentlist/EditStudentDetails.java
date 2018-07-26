package com.ajay.studentlist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class EditStudentDetails
 */
@WebServlet("/EditStudentDetails")
public class EditStudentDetails extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public EditStudentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con=null;
    PreparedStatement ps=null;
 	ResultSet rs=null;
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
		String name=null;
		   String pwd=null;
		   String email=null;
		   String sex=null;
		   String country=null;
		   name=request.getParameter("name");
			
		try
		{
			con=ConnectionManager.getConnection();
		    ps=con.prepareStatement("select * from stulist where name=?");
		    ps.setString(1, name);
		    rs=ps.executeQuery();
		    while(rs.next()) {
		   
		    name=rs.getString(1);
		    pwd=rs.getString(2);
		    email=rs.getString(3);
		    sex=rs.getString(4);
		    country=rs.getString(5);
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
				
				 pw.println("<p>Student Details Edit form for</p>"+name);
				 pw.println("<html>");
				 pw.println("<head>");
								 pw.println("<title>Insert title here</title>");
				 pw.println("</head>");
						 pw.println("<body>");
								 pw.println("<fieldset>");

pw.println("<legend>Login form</legend>");
	pw.println("<form action=\"./UpdateStudentDetails\" method=\"post\">");
	pw.println("<label for=\"name\">User Name</label>");
		pw.println("	<input type=\"text\" name=\"name\" value=\""+name+"\"><br>");
	pw.println("<label for=\"pwd\">Password</label>");
		pw.println("	<input type=\"text\" name=\"pwd\" value=\""+pwd+"\"><br>");
		pw.println("	<label for=\"email\">Email</label>");
		pw.println("	<input type=\"text\" name=\"email\" value=\""+email+"\"><br>");
		pw.println("	<input type=\"checkbox\" name=\"sex\" value =\"male\" checked >male<br>");
		pw.println("	<input type=\"checkbox\" name=\"sex\" value =\"female\">female<br>");
		pw.println("	<label for=\"country\">Country</label >");
		pw.println("	<input type=\"text\" name=\"country\" value=\""+country+"\"><br>");
		pw.println("<input type=\"submit\" name=\"button\" value=\"Submit\">	");	
	pw.println("	</form>");
	pw.println("	<a href=\"home.html\"><button>Main Menu</button></a>");
pw.println(" </fieldset>");
pw.println("</body>");
pw.println("</html>");
			
	}

}
