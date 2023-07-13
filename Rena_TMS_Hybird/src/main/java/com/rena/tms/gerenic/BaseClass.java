package com.rena.tms.gerenic;

import java.io.IOException;
import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.rena.tms.pom.AdminDashboardPage;
import com.rena.tms.pom.AdminManageBookingsPage;
import com.rena.tms.pom.AdminPackageCreationPage;
import com.rena.tms.pom.AdminSignInPage;
import com.rena.tms.pom.MyTourHistoryPage;
import com.rena.tms.pom.PackageDetailsPage;
import com.rena.tms.pom.PackageListPage;
import com.rena.tms.pom.TMSHomePage;
import com.rena.tms.pom.UserSignInPage;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * This BaseClass is developed for using Configuration Method
 * for Connection to DataBase,Opening Browser
 * And normal methods for (Admin Login and Logout)and (User Login and Logout)
 * @author Budarpu Madhusudhan
 */
public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebActionUtility wLib = new WebActionUtility();
	public DataBaseUtility dLib= new DataBaseUtility();
	public String FILE_PATH;

	public AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
	public AdminPackageCreationPage adminPackageCreationPage = new AdminPackageCreationPage(driver);
	public UserSignInPage userSignInPage = new UserSignInPage(driver);
	public PackageListPage packageListPage = new PackageListPage(driver);
	public PackageDetailsPage packageDetailsPage = new PackageDetailsPage(driver);
	public MyTourHistoryPage myTourHistoryPage = new MyTourHistoryPage(driver);
	public AdminManageBookingsPage adminManageBookingsPage = new AdminManageBookingsPage(driver);
/**
 * This Configuration method for developed for Connecting to DATABASE
 */
	@BeforeSuite(groups= {"smokeTest","reggTest"})
	public void connectToDB()
	{
		//dLib.connectiontoJDBC();
		System.out.println("connected to db");   
	}
	/**
	 * This Configuration method is developed for Launching Browser based on user configuration
	 * Maximize the browser
	 * Enter url
	 * and synchronize with implicitly wait
	 * @throws IOException
	 */
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","reggTest"})
	public void openBrowser(/*String BROWSER*/) throws IOException
	{
		System.out.println("openBrowser");
		FILE_PATH = fLib.getExternalFileData("PropertyFilePath");
	    String BROWSER =System.getProperty("browser", fLib.getPropertyData(FILE_PATH, "browser"));
		String URL = System.getProperty("url",fLib.getPropertyData(FILE_PATH, "url"));
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
	//	WebDriverManager.edgedriver().setup();
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			driver= new ChromeDriver();
		}
		 sdriver = driver;
		driver.manage().window().maximize();
		driver.get(URL);
		wLib.implicitlyWait(driver);
	}
	/**
	 * This Configuration method is developed for Admin Login into the application
	 * Getting credentials from propetry file
	 * @throws IOException
	 */
	@BeforeMethod(groups= {"smokeTest","reggTest"})
	public void adminLogini() throws IOException
	{
		TMSHomePage tmsHomePage = new TMSHomePage(driver);
		AdminSignInPage adminSignInPage = new AdminSignInPage(driver);
		tmsHomePage.clickOnAdminLoginButton();
		String ADMINUSERNAME =System.getProperty("adminusername", fLib.getPropertyData(FILE_PATH, "adminusername"));
		String ADMINPASSWORD =System.getProperty("adminpassword", fLib.getPropertyData(FILE_PATH, "adminpassword"));
		adminSignInPage.AdminLogin(ADMINUSERNAME, ADMINPASSWORD);
	}
	/**
	 * This Configuration method is developed for Admin LogOut from the application
	 */
	@AfterMethod(groups= {"smokeTest","reggTest"})
	public void adminLogoutt()
	{
		AdminSignInPage adminSignInPage = new AdminSignInPage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		adminDashboardPage.getAdminLogout();
		adminSignInPage.returnToHomePage();
	}	
	/**
	 * This Configuration method is developed for closing the browser
	 */
	@AfterClass(groups= {"smokeTest","reggTest"})
	public void closeBrowser()
	{
		driver.quit();
	}
	/**
	 * this Configuration method is developed for closing the DATABASE
	 * @throws SQLException
	 */
	@AfterSuite(groups= {"smokeTest","reggTest"})
	public void closeDB() throws SQLException
	{
		//dLib.closeJDBC();
		System.out.println("close DB");  
	}
	/**
	 * This Method is developed for Admin Login
	 * @throws IOException
	 */
	public void adminLogin() throws IOException
	{
		TMSHomePage tmsHomePage = new TMSHomePage(driver);
		AdminSignInPage adminSignInPage = new AdminSignInPage(driver);
		tmsHomePage.clickOnAdminLoginButton();
		String ADMINUSERNAME =System.getProperty("adminusername", fLib.getPropertyData(FILE_PATH, "adminusername"));
		String ADMINPASSWORD =System.getProperty("adminpassword", fLib.getPropertyData(FILE_PATH, "adminpassword"));
		adminSignInPage.AdminLogin(ADMINUSERNAME, ADMINPASSWORD);
	}
	/**
	 * this Method is developed for user Login
	 * @throws IOException
	 */
	public void userLogin() throws IOException
	{
		TMSHomePage tmsHomePage = new TMSHomePage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		tmsHomePage.clickOnUserLoginButton();
		String USERUSERNAME =System.getProperty("userusername", fLib.getPropertyData(FILE_PATH, "userusername"));
		String USERPASSWORD = System.getProperty("userpassword",fLib.getPropertyData(FILE_PATH, "userpassword"));
		userSignInPage.getUserSign(USERUSERNAME, USERPASSWORD);
	}
	/**
	 * This method is developed for User Logout
	 */
	public void userLogout()
	{
		TMSHomePage tmsHomePage = new TMSHomePage(driver);
		tmsHomePage.getUserLogOutButton();
	}
	/**
	 * This method is developed for Admin logout
	 */
	public void adminLogout()
	{
		AdminSignInPage adminSignInPage = new AdminSignInPage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		adminDashboardPage.getAdminLogout();
		adminSignInPage.returnToHomePage();
	}
}
