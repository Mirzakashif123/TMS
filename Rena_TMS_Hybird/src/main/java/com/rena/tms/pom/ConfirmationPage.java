package com.rena.tms.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.rena.tms.gerenic.WebActionUtility;

public class ConfirmationPage {

	@FindBy(xpath="//h4[text()='  Info successfully submited ']") private WebElement userSignUpConfirmMsg;
	
	@FindBy(xpath="//h4[contains(text(),'Info successfully submited')]") private WebElement issueGeneratedMsg;

	public WebActionUtility wLib;
	//intialization
	public ConfirmationPage(WebDriver driver) throws IOException
	{
		PageFactory.initElements(driver, this);
		wLib= new WebActionUtility();
	}
	public void verify1stUserSignUp(WebDriver driver,String expectedMsg) 
	{
		wLib.exceuteScript(driver, userSignUpConfirmMsg);
		String actualMsg = userSignUpConfirmMsg.getAttribute("innerHTML");
		Assert.assertTrue(actualMsg.contains(expectedMsg), "1st user failed"+actualMsg);
		Reporter.log("1st user created "+actualMsg, true);
	}
	public void verify2ndUserSignUp(WebDriver driver,String expectedMsg) 
	{
		wLib.exceuteScript(driver, userSignUpConfirmMsg);
		String actualMsg = userSignUpConfirmMsg.getAttribute("innerHTML");
		Assert.assertTrue(actualMsg.contains(expectedMsg), "2nd user failed"+actualMsg);
		Reporter.log("2nd user created "+actualMsg, true);
	}
	public void verifyIssueGeneration(WebDriver driver,String expectedMsg) 
	{
		wLib.explicitlyWaitForElement(driver, issueGeneratedMsg);
		String actualMsg=issueGeneratedMsg.getAttribute("innerHTML").toString().trim();
		Assert.assertTrue(expectedMsg.contains(actualMsg), "Issue Generation Failed"+actualMsg);
		Reporter.log("Issue Generation"+actualMsg, true);
	}
}
