package View;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.SelectDetails;
import Model.Student;

@WebServlet("/ShowDeatils")
public class ShowDeatils extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<a href='index.html'>Add New Student</a>");
		out.println("<h1>Student List</h1>");
		List<Student> list = SelectDetails.getAllStudent();
		out.println("<table border='2' cellspacing ='0'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Address</th><th>City</th><th>Country</th></tr>");
		for(Student s:list)
		{
			out.println("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getEmail()+"</td><td>"+s.getPassword()+"</td><td>"+s.getAddress()+"</td><td>"+s.getCity()+"</td><td>"+s.getCountry()+"</td><td><a href='UpdateDetails?id="+s.getId()+"'>Edit</a></td><td><a href='DeleteDetails?id="+s.getId()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		out.close();
		
	}

}
