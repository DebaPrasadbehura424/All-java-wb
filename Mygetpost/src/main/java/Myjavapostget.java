

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/login")
public class Myjavapostget extends HttpServlet {
	
	
	
	@Override
    protected void service (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
 {
	
	String myemail=request.getParameter("names");
	String mypass=request.getParameter("pass");
	PrintWriter out=response.getWriter();
	
	if(myemail.equals("deba")  && mypass.equals("123")) {
		request.setAttribute("name_key","deba ");
		RequestDispatcher red= request.getRequestDispatcher("/NewFile.jsp");
		red.forward(request, response);
	}else {
		out.print("name and  id didn't mathched ");
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("/NewFile.html");
		rd.include(request, response);
	}

	
 }
}
