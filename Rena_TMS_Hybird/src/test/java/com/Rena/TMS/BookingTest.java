/*verify user can book the tickets and confirm his booking status*/
package com.Rena.TMS;
import java.io.IOException;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.rena.tms.gerenic.BaseClass;
import com.rena.tms.pom.AdminDashboardPage;
import com.rena.tms.pom.AdminManageBookingsPage;
import com.rena.tms.pom.AdminPackageCreationPage;
import com.rena.tms.pom.MyTourHistoryPage;
import com.rena.tms.pom.PackageDetailsPage;
import com.rena.tms.pom.PackageListPage;
import com.rena.tms.pom.TMSHomePage;
@Listeners(com.rena.tms.gerenic.LisetenerImplementation.class)
public class BookingTest extends BaseClass {

	@Test /*(groups= "reggTest")*/(retryAnalyzer=com.rena.tms.gerenic.RetryImplementation.class)
	public void bookingTest() throws IOException, InterruptedException
	{
		/*Creation of Objects for POM classes*/
		TMSHomePage tmsHomePage = new TMSHomePage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		AdminPackageCreationPage adminPackageCreationPage = new AdminPackageCreationPage(driver);
		PackageListPage packageListPage = new PackageListPage(driver);
		PackageDetailsPage packageDetailsPage = new PackageDetailsPage(driver);
		MyTourHistoryPage myTourHistoryPage = new MyTourHistoryPage(driver);
		AdminManageBookingsPage adminManageBookingsPage = new AdminManageBookingsPage(driver);

		/*retriving the data from excel and stronging in VARIABLE*/
		String EFILE_PATH = fLib.getExternalFileData("ExcelFilePath");
		String PACKAGENAME =eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_01","PackageName");
		String PACKAGETYPE =eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_01","PackageType");
		String PACKAGELOC = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_01","PackageLoc");
		String PACKAGEPRICE = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_01","PackagePrice");
		String PACKAGEFEATURE = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_01","PackageFeature");
		String PACKAGEDETAILS = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_01","PackageDetails");
		String COMMENTTOBOOK = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_01","Comments to book");
		String EXPECTEDTOURCREATEDMESSAGE = eLib.getExcelData(EFILE_PATH, "Booking" ,"tc_01","PackageMessage");
		String EXPECTEDBOOKINGMESSAGE = eLib.getExcelData(EFILE_PATH, "Booking" ,"tc_01","BookingMessage");
		String EXPECTEDBOOKINGCONFIRMMESSAGE = eLib.getExcelData(EFILE_PATH, "Booking" ,"tc_01","ConfirmMessage");
		String USERCONFIRMATION = eLib.getExcelData(EFILE_PATH, "Booking" ,"tc_01","UserVerify");
		String KEY = eLib.getExcelData(EFILE_PATH, "Booking" ,"tc_01","key");

		/*Admin creation of TourPackage*/ 
		adminDashboardPage.moveMouseOverToTourPackage(driver);
		adminDashboardPage.getAdminCreateTab();
		adminPackageCreationPage.getAllTextfields(driver, PACKAGENAME, PACKAGETYPE, PACKAGELOC, PACKAGEPRICE, PACKAGEFEATURE, PACKAGEDETAILS, KEY);

		/*verify Tour Package Successfully created */
		adminPackageCreationPage.verifyTourPackageCreated(EXPECTEDTOURCREATEDMESSAGE);

		/*Admin Logout*/
		adminLogout();

		/*Login as User*/
		userLogin();

		/*User Booking Tour Package*/
		packageListPage.getTourDetailsButton(driver);
		packageDetailsPage.enterFromDate();
		packageDetailsPage.enterToDate();
		packageDetailsPage.enterComment(driver, COMMENTTOBOOK);
		packageDetailsPage.getBookBotton();

		/*Verify booking */
		packageDetailsPage.verifyBooking(EXPECTEDBOOKINGMESSAGE);

		/*Store the Booking ID*/
		tmsHomePage.clickOnMyTourHistory();
		String EXPECTEDBOOKINGID = myTourHistoryPage.storeBookingId();

		/*User Logout*/
		userLogout();

		/*Admin Login*/
		adminLogin();

		/*Admin confirms User's booking based on BookingID*/
		adminDashboardPage.getManageBookingTab();
		adminManageBookingsPage.adminConfirmBooking(driver, EXPECTEDBOOKINGID);

		/*Verfiy Admin has Confirmed users booking */
		adminManageBookingsPage.verifyBookingConfirmation(EXPECTEDBOOKINGCONFIRMMESSAGE);

		/*Admin Logout*/
		adminLogout();

		/*Login as User*/
		userLogin();
	
		/*verifying by user as booking is confirmed */
		tmsHomePage.clickOnMyTourHistory();
		myTourHistoryPage.verifybookingConfirmed(USERCONFIRMATION);

		/*User Logout*/
		userLogout();
		
		/*Admin Login*/
		adminLogin();

		//Changs done in Madhu Branch
	}
}



