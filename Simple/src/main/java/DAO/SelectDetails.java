package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import Model.Student;

public class SelectDetails {
public static Student getStudentById(int id)
{
    Student s=new Student();
    try {
	Connection con=GetConDAO.getConnection();
	PreparedStatement pst=con.prepareStatement("select *from reg where id=?");
	pst.setInt(1, id);
	ResultSet rs=pst.executeQuery();
	if(rs.next())
		
	{
		s.setId(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setEmail(rs.getString(3));
		s.setPassword(rs.getString(4));
		s.setAddress(rs.getString(5));
		s.setCity(rs.getString(6));
		s.setCountry(rs.getString(7));
	}
   con.close();
}
	catch(Exception e){
	System.out.println(e);
}
	return s;
}
public static List<Student>getAllStudent()
{
	List<Student>list=new ArrayList<Student>();
	try {
		Connection con=GetConDAO.getConnection();
		PreparedStatement pst=con.prepareStatement("select *from reg");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			Student s=new Student();
			
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setEmail(rs.getString(3));
			s.setPassword(rs.getString(4));
			s.setAddress(rs.getString(5));
			s.setCity(rs.getString(6));
			s.setCountry(rs.getString(7));
			list.add(s);
		}
	   con.close();
		
	}
	catch(Exception e)
	{
		System.out.println(e);
		
	}
	return list;
}
}
