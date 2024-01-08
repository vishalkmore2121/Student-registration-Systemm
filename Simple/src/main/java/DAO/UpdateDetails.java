package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Student;

public class UpdateDetails {
public static int update(Student s) {
	
	int status=0;
	try {
		Connection con=GetConDAO.getConnection();
		PreparedStatement pst=con.prepareStatement("update reg set name=?,email=?,password=?,address=?,city=?,country=? where id=?");
	
     		pst.setString(1,s.getName());
			pst.setString(2,s.getEmail());
			pst.setString(3,s.getPassword());
			pst.setString(4,s.getAddress());
			pst.setString(5,s.getCity());
			pst.setString(6,s.getCountry());
			pst.setInt(7,s.getId());
			
			status=pst.executeUpdate();
			con.close();
		}
	catch(Exception e) {
		System.out.println(e);
	}
	return status;
	
}
}
