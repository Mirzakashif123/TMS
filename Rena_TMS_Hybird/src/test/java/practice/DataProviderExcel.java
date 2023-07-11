package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rena.tms.gerenic.FileUtility;
import com.rena.tms.pom.AdminSignInPage;
import com.rena.tms.pom.TMSHomePage;

public class DataProviderExcel {
	FileUtility fLib = new FileUtility();
	String URL;

	@Test(dataProvider="data")
	public void test(String us,String pwd) throws IOException
	{
		WebDriver driver = new ChromeDriver();
		String COMMONDATAPATH = fLib.getExternalFileData("PropertyFilePath");
		URL = fLib.getPropertyData(COMMONDATAPATH, "url");
		driver.get(URL);
		TMSHomePage tMSHomePage = new TMSHomePage(driver);
		tMSHomePage.clickOnAdminLoginButton();
		AdminSignInPage adminSignInPage = new AdminSignInPage(driver);
		adminSignInPage.AdminLogin(us,pwd);
		driver.switchTo().alert().accept();
		driver.close();
	}
	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Desktop\\TYSS MANUAL\\ExcelFiles\\DataProviderTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("DP");
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowCount][cellCount];
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				obj[i][j]= sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
