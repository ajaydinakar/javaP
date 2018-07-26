package com.ajay.studentlist;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import com.ajay.dbconnect.ConnectionManager;

/**
 * Servlet implementation class ViewRecords
 */
@WebServlet("/ViewRecords")
public class ViewRecords extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ViewRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con=null;
 	Statement st=null;
 	ResultSet rs=null;
 	ResultSetMetaData rd=null;
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
		  String name=null;
		   String pwd=null;
		   String email=null;
		   String sex=null;
		   String country=null;
		try
		{
			con=ConnectionManager.getConnection();
		    st=con.createStatement();
		    rs =st.executeQuery("select * from stulist");
		    rd=rs.getMetaData(); 
		    out.println("<table>");
		    out.println("<tr>");		   
		    out.println("<th>");
		    out.println(rd.getColumnLabel(1));
		    out.println("</th>");
		    out.println("<th>");
		    out.println(rd.getColumnLabel(2));
		    out.println("</th>");
		    out.println("<th>");
		    out.println(rd.getColumnLabel(3));
		    out.println("</th>");
		    out.println("<th>");
		    out.println(rd.getColumnLabel(4));
		    out.println("</th>");
		    out.println("<th>");
		    out.println(rd.getColumnLabel(5));
		    out.println("</th>");
		    out.println("</tr>");	    
		    out.println("<br>");
		    while(rs.next())
		    {
		    name=rs.getString(1);
		    pwd=rs.getString(2);
		    email=rs.getString(3);
		    sex=rs.getString(4);
		    country=rs.getString(5);
		    out.println("<tr>");
		    out.println("<td>");
		    out.println(name);
		    out.println("</td>");
		    out.println("<td>");
		    out.println(pwd);
		    out.println("</td>");
		    out.println("<td>");
		    out.println(email);
		    out.println("</td>");
		    out.println("<td>");
		    out.println(sex);
		    out.println("</td>");
		    out.println("<td>");
		    out.println(country);
		    out.println("</td>");
		    out.println("<td>");
		    out.println("<form action=\"./EditStudentDetails\" >");
		    out.print("<button name=\"name\" type=\"submit\" value=\""+name+"\">Edit</button>");
		    out.println("</form>");
		    out.println("</td>");
		    out.println("<td>");
		    out.println("<form action=\"./DeleteStudent\" >");
		  
		    out.print("<button name=\"name\" type=\"submit\" value=\""+name+"\">Delete</button>");

		    out.println("</form>");
		    out.println("</td>");
		    out.println("</tr>");		    
		    }
		    out.println("</table>");
		}
		catch(SQLException e)
		{
		e.printStackTrace();	
		}
		finally
		{
			try {
				ConnectionManager.release(con,st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
