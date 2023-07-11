package com.rena.tms.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.rena.tms.gerenic.WebActionUtility;

public class AdminManageUserPage {

	@FindBy(xpath="(//tbody/tr)[last()]/td[6]") private WebElement issurDescription;
	public WebActionUtility wLib;
	//intialization
	public AdminManageUserPage(WebDriver driver) throws IOException
	{
		PageFactory.initElements(driver, this);
		wLib= new WebActionUtility();
	}
	
	public void verifyIssueVisible(String expectedIssueVisible)
	{
		String actualVisibleMsg=issurDescription.getText();
		
		Assert.assertTrue(expectedIssueVisible.contains(actualVisibleMsg), actualVisibleMsg+ "issue Raised by the User is not visible in Admin ManageIssue ");
		Reporter.log(actualVisibleMsg+"issue Raised by the User is visible in Admin ManageIssue ", true);
	}	
	
}
