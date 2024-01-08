package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.SelectDetails;
import Model.Student;

@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Update Employee</h1>");
		String sid=request.getParameter("id");
		int id =Integer.parseInt(sid);
		Student s=SelectDetails.getStudentById(id);
		
		out.println("<form action='UpdateData' method='post'>");
		out.println("<table>");
		out.println("<tr><td><input type='hidden' name='id' value='"+s.getId()+"'></td></tr>");
		out.println("<tr><td>Name:</td><td><input type='text' name='name' value='"+s.getName()+"'></td></tr>");
		out.println("<tr><td>Password:</td><td><input type='password' name='password' value='"+s.getPassword()+"'></td></tr>");
		out.println("<tr><td>Email:</td><td><input type='email' name='email' value='"+s.getEmail()+"'></td></tr>");
		out.println("<tr><td>Address:</td><td><input type='text' name='address' value='"+s.getAddress()+"'></td></tr>");
		
		out.println("<tr><td>City:</td><td>");
		out.println("<select name='city'>");
		out.println("<option>Pune</option>");
		out.println("<option>Mumbai</option>");
		out.println("<option>Solapur</option>");
		out.println("<option>Nagpur</option>");
		out.println("</select>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Country:</td><td>");
		out.println("<select name='country'>");
		out.println("<option>India</option>");
		out.println("<option>Australia</option>");
		out.println("<option>Japan</option>");
		out.println("<option>America</option>");
		out.println("</select>");
		out.println("</td></tr>");
		
		out.println("</table>");
		out.println("<input type='submit' value='Edit & Submit'>");
			}

}
