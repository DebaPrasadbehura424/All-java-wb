package backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/logins")
public class Loginups extends HttpServlet {

   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	   
		String myemail=req.getParameter("email");
		String mypass= req.getParameter("pass");
		PrintWriter out= resp.getWriter();
	    
	   resp.setContentType("text/html");
	   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjava","root","sitaram");
	    PreparedStatement ps=con.prepareStatement("select * from register where email=? AND pass=?");
	    ps.setString(1, myemail);
	    ps.setString(2, mypass);
	    ResultSet res= ps.executeQuery();
	    if(res.next()) {
	    	out.print("<h3 style='color:red'> mathed </h3>");
	    	HttpSession session=req.getSession();
	    	session.setAttribute("ses_name", res.getString("name"));
	    	
	    	RequestDispatcher rd= req.getRequestDispatcher("/Profile.jsp");
	    	rd.include(req, resp);
	    	
	    }else {
	    	out.print("<h3 style='color:red'>not mathed </h3>");
	    	RequestDispatcher rd= req.getRequestDispatcher("/Loginup.jsp");
	    	rd.include(req, resp);
	    }
	
	
	} catch (Exception e) {
		out.print("<h3 style='color:red'>"+ e.getMessage()+"</h3>");
    	RequestDispatcher rd= req.getRequestDispatcher("/Loginup.jsp");
    	rd.include(req, resp);
	}
	   
	 
	   
	   

   }

}
