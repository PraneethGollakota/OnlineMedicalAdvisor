package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gvp.cse.team1.common.DatabaseConnector;


/**
 * Servlet implementation class SymptomsServlet
 */
@WebServlet("/symptoms")
public class SymptomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SymptomsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		String fever=request.getParameter("fever");
		String vomitings=request.getParameter("vomitings");
		String headache=request.getParameter("headache");
		String motions=request.getParameter("motions");
		
		try
		{
			Connection  con= new DatabaseConnector().createDatabaseConnection();
			PreparedStatement ps=con.prepareStatement("select disname from disease where fever=? and vomitings=? and headache=? and motions=?");
			ps.setString(1, fever);
			ps.setString(2, vomitings);
			ps.setString(3, headache);
			ps.setString(4, motions);
			
						
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Disease Name:"+rs.getString(1));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
