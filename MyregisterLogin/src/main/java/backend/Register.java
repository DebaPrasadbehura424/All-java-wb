package backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/reg")
public class Register extends HttpServlet {


  
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
	String myname =req.getParameter("name1");
	String myemail=req.getParameter("email");
	String mypass= req.getParameter("pass");
	String gender=req.getParameter("gender1");
	String mycity=req.getParameter("citys");
	
	   PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjava","root","sitaram");
		    PreparedStatement ps= con.prepareStatement("insert into register values(?,?,?,?,?)");
		    //? Positional parameter 
		    ps.setString(1, myname);
		    ps.setString(2, myemail);
		    ps.setString(3, mypass);
		    ps.setString(4,gender);
		    ps.setString(5, mycity);
		    int count= ps.executeUpdate();
		    
		 
		    if(count>0) {
		    
		    	out.print("<h3  style='color:green'>user register succesfully</h3>");
		    	RequestDispatcher rd= req.getRequestDispatcher("/Register.jsp");
		    	rd.include(req, resp);
		    }else {
		    	
		    	out.print("<h3  style='color:red'>user register falied </h3>");
		    	RequestDispatcher rd= req.getRequestDispatcher("/Register.jsp");
		    	rd.include(req, resp);
		    }
		    
		} catch (Exception e) {
			
	    	out.print("<p>Exception </p>" + e.getMessage());
	    	RequestDispatcher rd= req.getRequestDispatcher("/Register.jsp");
	    	rd.include(req, resp);
		}
		
	
	
	
  }

	


}
