/*Verify user can book the tickets and cancel his tickets*/
package com.Rena.TMS;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.rena.tms.gerenic.BaseClass;
import com.rena.tms.pom.AdminDashboardPage;
import com.rena.tms.pom.AdminPackageCreationPage;
import com.rena.tms.pom.MyTourHistoryPage;
import com.rena.tms.pom.PackageDetailsPage;
import com.rena.tms.pom.PackageListPage;
import com.rena.tms.pom.TMSHomePage;

@Listeners(com.rena.tms.gerenic.LisetenerImplementation.class)
public class RenaTMSCancelBookingTest extends BaseClass {
	@Test(groups= "reggTest")
	public void cancelBookigTest() throws IOException, InterruptedException  {
		/*Creation of Objects for POM classes*/
		TMSHomePage tmsHomePage = new TMSHomePage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		AdminPackageCreationPage adminPackageCreationPage = new AdminPackageCreationPage(driver);
		PackageListPage packageListPage = new PackageListPage(driver);
		PackageDetailsPage packageDetailsPage = new PackageDetailsPage(driver);
		MyTourHistoryPage myTourHistoryPage = new MyTourHistoryPage(driver);

		/*retriving the data from excel and stronging in VARIABLE*/
		String EFILE_PATH = fLib.getExternalFileData("ExcelFilePath");
		String PACKAGENAME =eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_03","PackageName");
		String PACKAGETYPE =eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_03","PackageType");
		String PACKAGELOC = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_03","PackageLoc");
		String PACKAGEPRICE = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_03","PackagePrice");
		String PACKAGEFEATURE = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_03","PackageFeature");
		String PACKAGEDETAILS = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_03","PackageDetails");
		String COMMENTTOBOOK = eLib.getExcelData(EFILE_PATH,"Booking" ,"tc_03","Comments to book");
		String EXPECTEDTOURCREATEDMESSAGE = eLib.getExcelData(EFILE_PATH, "Booking" ,"tc_03","PackageMessage");
		String EXPECTEDBOOKINGMESSAGE = eLib.getExcelData(EFILE_PATH, "Booking" ,"tc_03","BookingMessage");
		String EXPECTEDCANCELMESSAGE = eLib.getExcelData(EFILE_PATH, "Booking" ,"tc_03","CancelMessage");
		String KEY = eLib.getExcelData(EFILE_PATH, "Booking" ,"tc_01","key");


		/*Admin creation of TourPackage*/ 
		adminDashboardPage.moveMouseOverToTourPackage(driver);
		adminDashboardPage.getAdminCreateTab();
		adminPackageCreationPage.getAllTextfields(driver, PACKAGENAME, PACKAGETYPE, PACKAGELOC, PACKAGEPRICE, PACKAGEFEATURE, PACKAGEDETAILS, KEY);

		/*verify Tour Package Successfully created */
		adminPackageCreationPage.verifyTourPackageCreated(EXPECTEDTOURCREATEDMESSAGE);

		/*Admin Logout and back to TMSHomePage*/
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

		/*User cancel his booking*/
		tmsHomePage.clickOnMyTourHistory();
		myTourHistoryPage.cancelBooking(driver);

		/*Verify booking cancelled*/
		myTourHistoryPage.verifyCancelBooking(EXPECTEDCANCELMESSAGE);

		/*User Logout*/
		userLogout();
		
		/*Admin Login into the Application*/
		adminLogin();
	}
}
