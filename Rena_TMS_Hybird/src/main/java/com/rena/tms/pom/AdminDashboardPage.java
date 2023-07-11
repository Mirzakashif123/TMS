package com.rena.tms.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.rena.tms.gerenic.WebActionUtility;
/**
 * This Class is developed to Store WebElements of AdminDashBoardPage
 * @author Budarpu Madhusudhan
 */
public class AdminDashboardPage {

	//declaration
	@FindBy(xpath="//p[text()='Welcome']") private WebElement welComeDropdown ;

	@FindBy(xpath="//a[text()=' Profile']") private WebElement adminProfileButton ;

	@FindBy(xpath="//a[@href='logout.php']") private WebElement adminLogoutButton;

	@FindBy(xpath="//span[text()='Dashboard']") private WebElement adminDashboardTab;

	@FindBy(xpath ="//span[text()=' Tour Packages']") private WebElement adminTourPackageTab;

	@FindBy(xpath ="//a[text()='Create']") private WebElement adminCreateTab;

	@FindBy(xpath="//a[text()='Manage']") private WebElement adminManageTab;

	@FindBy(xpath="//span[text()='Manage Booking']") private WebElement manageBookingTab;

	@FindBy(xpath="//a[@href=\"manageissues.php\"]") private WebElement manageIssueTab;

	@FindBy(xpath="//h3[text()='User']/..//h4") private WebElement userCountInUserTab;

	/**
	 * This Method is developed for clicking on MANAGEISSUE TAB
	 */
	public void clickOnManageIssueTab() {
		manageIssueTab.click();
	}

	//initilazation
	/**
	 * This Constructor is developed for initilization of webelements of ADMINDASHBOARD
	 * @param driver
	 */
	public AdminDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	/**
	 * This Method is developed for clicking on ADMIN CREATETAB
	 */
	public void getAdminCreateTab() {
		adminCreateTab.click();
	}
	/**
	 * This Method is developed for clicking on ADMIN MANAGEBOOKING TAB
	 */
	public void getManageBookingTab() {
		manageBookingTab.click();
	}
	/**
	 * This Method is developed for ADMIN LOGOUT
	 */
	//bussiness libirary
	public void getAdminLogout() 
	{
		welComeDropdown.click();
		adminLogoutButton.click();
	}
	/**
	 * This Method is developed for mouseHover on TOUR PACKAGE
	 * @param driver
	 * @throws IOException
	 */
	public void moveMouseOverToTourPackage(WebDriver driver) throws IOException
	{
		WebActionUtility wLib = new WebActionUtility() ;
		wLib.mouseOverOnElement(driver,adminTourPackageTab);
	}
	/**
	 * This Method is developed for getting 1st User Count
	 * @return userCount1
	 */
	public int firstUserCount() 
	{
		String count1 = userCountInUserTab.getText();
		int userCount1 = Integer.parseInt(count1);
		return userCount1;
	}
	/**
	 * This Method is developed for getting 2nd User Count
	 * @return userCount2
	 */
	public int secondUserCount() 
	{
		String count2 = userCountInUserTab.getText();
		int userCount2 = Integer.parseInt(count2);
		return userCount2;
	}
	/**
	 *This Method is developed for verfiying User Count UPDATION
	 * @param count1
	 * @param count2
	 */
	public void verifyCountUpdation(int count1,int count2)
	{
		Assert.assertTrue(count2>count1, "User count not updated");
		Reporter.log("User count has been updated", true);
	}
}
