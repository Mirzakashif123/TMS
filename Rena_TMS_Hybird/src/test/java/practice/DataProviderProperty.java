package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rena.tms.gerenic.FileUtility;
import com.rena.tms.pom.AdminSignInPage;
import com.rena.tms.pom.TMSHomePage;

public class DataProviderProperty 
{
	FileUtility fLib = new FileUtility();
	String URL;
	
	@Test(dataProvider="data")
	public void test(String us,String pwd)
	{
       WebDriver driver = new ChromeDriver();
       driver.get(URL);
       TMSHomePage tMSHomePage = new TMSHomePage(driver);
       tMSHomePage.clickOnAdminLoginButton();
      AdminSignInPage adminSignInPage = new AdminSignInPage(driver);
       adminSignInPage.AdminLogin(us,pwd);
       driver.close();
       
	}

	@DataProvider
	public Object[][] data() throws IOException
	{ 
		
		String COMMONDATAPATH = fLib.getExternalFileData("PropertyFilePath");
		URL = fLib.getPropertyData(COMMONDATAPATH, "url");
		String AU = fLib.getPropertyData(COMMONDATAPATH, "adminusername");
		String AP = fLib.getPropertyData(COMMONDATAPATH, "adminpassword");
		String UU = fLib.getPropertyData(COMMONDATAPATH, "userusername");
		String UP = fLib.getPropertyData(COMMONDATAPATH, "userpassword");

		Object[][] obj = new Object[2][2];

		obj[0][0]=AU;
		obj[0][1]=AP;

		obj[1][0]=UU;
		obj[1][1]=UP;

		return obj;

	}
}
