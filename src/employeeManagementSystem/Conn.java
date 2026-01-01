package employeeManagementSystem;

import java.sql.*;

public class Conn 
{
	Connection c;
	Statement s;
	
	public Conn()
	{
		try 
		{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljava", "root", "9868");
			s= c.createStatement();
		} 
			catch (Exception e) 
			{
			e.printStackTrace();
			}
	}
	
	
	public static void main(String[] args) 
	{

	}

}
