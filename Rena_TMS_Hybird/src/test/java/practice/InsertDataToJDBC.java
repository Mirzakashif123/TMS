package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataToJDBC {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = conn.createStatement();
			 String Query = "insert into project values('Renaa_TMS_001','Budarpu','29/06/2023','Renaa','completed','5')";
			 int result = statement.executeUpdate(Query);
			 if(result==1)
			 {
			System.out.println("data is created");	 
			 }
			 else
			 {
				 System.out.println("data is not created");
			 }
		}
		finally
		{
			conn.close();
		}
			
	}

}
