package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class ToConfirmDataFromJDBC {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		String Project_Name= "Renna";
		try
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = conn.createStatement();
			String query ="select * from project";
			ResultSet result = statement.executeQuery(query);
			boolean flag = false;
			while (result.next())
			{
				String value = result.getString(4);
				if(value.equalsIgnoreCase(Project_Name))
				{
					System.out.println("project is created");
					flag= true;
					break;
				}
			}
				if(!flag)
				{
					System.out.println("project is not created");
				}
		}
		finally
		{
			conn.close();
		}
	}
}


