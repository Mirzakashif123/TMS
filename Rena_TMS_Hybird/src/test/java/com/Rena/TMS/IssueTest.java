/*verify issue raised by user is visible in admin manageissue module*/
package com.Rena.TMS;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.rena.tms.gerenic.BaseClass;
import com.rena.tms.pom.AdminDashboardPage;
import com.rena.tms.pom.AdminManageUserPage;
import com.rena.tms.pom.ConfirmationPage;
import com.rena.tms.pom.PackageListPage;
@Listeners(com.rena.tms.gerenic.LisetenerImplementation.class)
public class IssueTest extends BaseClass {
	@Test(groups="smokeTest")
	public void issueTest() throws IOException {

		/*Creation of Objects for POM classes*/
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		PackageListPage packageListPage = new PackageListPage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		AdminManageUserPage adminManageUserPage = new AdminManageUserPage(driver);

		/*retriving the data from excel and stronging in VARIABLE*/
		String EFILE_PATH = fLib.getExternalFileData("ExcelFilePath");
		String VISIBLETEXT =eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_02","VisibleText");
		String DESCRIPTION =eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_02","Description");
		String EXPECTEDISSUEMSG =eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_02","ExpectedIssueMsg");
		String EXPECTEDMESSAGEVISIBLE =eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_02","MessageVisible");
		
		/*Admin logout*/
		adminLogout();
		
		/*Login as User*/
		userLogin();
		/*write Issue*/
		packageListPage.writeIssue(VISIBLETEXT, DESCRIPTION);

		/*verify issue generation*/
		confirmationPage.verifyIssueGeneration(driver, EXPECTEDISSUEMSG);

		/*User Logout*/
		userLogout();

		/*Admin Login into the Application*/
		adminLogin();

		/*Verify issue raised by user is visible in admin manageIssue module*/
		adminDashboardPage.clickOnManageIssueTab();
		adminManageUserPage.verifyIssueVisible(EXPECTEDMESSAGEVISIBLE);

	}
}
