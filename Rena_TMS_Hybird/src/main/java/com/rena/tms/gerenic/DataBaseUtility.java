package com.rena.tms.gerenic;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * This Class is developed for Perfrom DataBase Action 
 * @author Budarpu MadhuSudhan
 *
 */
public class DataBaseUtility {

	Driver driver;
	Connection conn;

	FileUtility fLib = new FileUtility();
	String DBFILE_PATH;
	String URL;
	String USERNAME;
	String PASSWORD;
	
	/*Constructor */
	public DataBaseUtility()
	{
		String DBFILE_PATH;
		try {
			DBFILE_PATH = fLib.getExternalFileData("DataBaseFilePath");

			 URL = fLib.getPropertyData(DBFILE_PATH, "url");
		 USERNAME = fLib.getPropertyData(DBFILE_PATH, "username");
		PASSWORD = fLib.getPropertyData(DBFILE_PATH, "password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is developed to get connection to DATABASE
	 */
	public void connectiontoJDBC()
	{
		try
		{
			driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * This method is developed to close JDBC
	 * @throws SQLException
	 */
	public void closeJDBC() throws SQLException
	{
		try
		{
			conn.close();
		}
		catch(Exception e) {
		}
	}
	/**
	 * This method is developed for executing query
	 * @param QUERY
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String QUERY) throws SQLException
	{
		ResultSet result = conn.createStatement().executeQuery(QUERY);
		return result;
	}

	/**
	 * This method is developed for executing query
	 * @param QUERY
	 * @return
	 * @throws SQLException
	 */
	public int updateQuery(String QUERY) throws SQLException
	{
		int result = conn.createStatement().executeUpdate(QUERY);
		return result;
	}

	/**
	 * This method will execute querry based on querry and it will verify the data. 
	 * @param querry
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public boolean executeQuerryAndVerify(String Querry,int cloumnIndex,String expectedData) throws Throwable {
		boolean flag=false;
		ResultSet result = conn.createStatement().executeQuery(Querry);
		while(result.next()) {
			if(result.getString(cloumnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData+"==>Data is verified in the data base table");
			return flag;
		}else {
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}
	}
}
