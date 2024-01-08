package DAO;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class GetConDAO {
public static Connection getConnection() {
	Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","tejas");
	}
	catch(Exception e)
	{
		System.out.println(e);
		}
	return con;
}
}
