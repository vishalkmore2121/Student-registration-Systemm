package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.StudentDAO;
import Model.Student;
@WebServlet("/SaveDetails")
public class SaveDetails extends HttpServlet {
	
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		
		String name,password,email,address,city,country;
		name= request.getParameter("name");
		password= request.getParameter("password");
		email= request.getParameter("email");
		address= request.getParameter("address");
		city= request.getParameter("city");
		country= request.getParameter("country");
		
		Student s = new Student();
		s.setName(name);
		s.setPassword(password);
		s.setEmail(email);
		s.setAddress(address);
		s.setCity(city);
		s.setCountry(country);
		int status = StudentDAO.save(s);
		if(status>0)
		{
			out.println("<h3>Record save succesfully...</h3>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else {
			out.println("<h3>Record Faild To insert ...</h3>");
		}
		out.close();
		
	}

}
