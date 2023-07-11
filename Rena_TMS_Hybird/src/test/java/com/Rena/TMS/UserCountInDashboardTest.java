/*verfiy user count is displayed user tab of Admin Dashboard */
package com.Rena.TMS;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.rena.tms.gerenic.BaseClass;
import com.rena.tms.pom.AdminDashboardPage;
import com.rena.tms.pom.ConfirmationPage;
import com.rena.tms.pom.TMSHomePage;
import com.rena.tms.pom.UserSignUpPage;
@Listeners(com.rena.tms.gerenic.LisetenerImplementation.class)
public class UserCountInDashboardTest extends BaseClass {
	@Test(groups= "smokeTest")
	public void dashBoard() throws IOException, InterruptedException  {
		/*Creation of Objects for POM classes*/
		TMSHomePage tmsHomePage = new TMSHomePage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		UserSignUpPage userSignUpPage = new UserSignUpPage(driver);
		ConfirmationPage userSignUpConfirmationPage = new ConfirmationPage(driver);
		
		/*retriving the data from excel and stronging in VARIABLE*/
		String EFILE_PATH = fLib.getExternalFileData("ExcelFilePath");
		String FULLNAME =eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_04","fullname");
		String PHONENUM =eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_04","MobileNum");
		String EMAIL = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_04","email");
		String PASSWORD = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_04","password");
		String SIGNUPCONFIRM = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_04","SignUpConfirm");
		
		/*Admin Logout and back to TMSHomePage*/
		adminLogout();
		
		/*User SignUp and create 1st Account */
		tmsHomePage.clickOnUserSignUpButton();
		userSignUpPage.userSignUp1(FULLNAME, PHONENUM, EMAIL, PASSWORD);

		/*Verify user as Created his 1st Account*/
		userSignUpConfirmationPage.verify1stUserSignUp(driver, SIGNUPCONFIRM);

		/*Admin Login into the Application*/
		adminLogin();

		/*getting  1st userCount from usertab in adminDashboard*/
		int FIRSTUSERCOUNT = adminDashboardPage.firstUserCount();

		/*Admin Logout and back to TMSHomePage*/
		adminLogout();

		/*User SignUp and create 2st Account */
		tmsHomePage.clickOnUserSignUpButton();
		userSignUpPage.userSignUp2(FULLNAME, PHONENUM, EMAIL, PASSWORD);

		/*Verify user as Created his 2st Account*/
		userSignUpConfirmationPage.verify2ndUserSignUp(driver, SIGNUPCONFIRM);

		/*Admin Login into the Application*/
		adminLogin();

		/*getting  2st userCount from usertab in adminDashboard*/
		int SECONDUSERCOUNT = adminDashboardPage.secondUserCount();

		/*verify user count in UserTab in dashboard updated*/
		adminDashboardPage.verifyCountUpdation(FIRSTUSERCOUNT, SECONDUSERCOUNT);
		
		}
}
