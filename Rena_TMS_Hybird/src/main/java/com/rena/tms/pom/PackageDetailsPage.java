package com.rena.tms.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.rena.tms.gerenic.JavaUtility;
import com.rena.tms.gerenic.WebActionUtility;

public class PackageDetailsPage {

	JavaUtility jLib = new JavaUtility();
	//declaration
	@FindBy(xpath="//input[@id='datepicker']") private WebElement fromDateTextField;

	@FindBy(xpath="//input[@id='datepicker1']") private WebElement toDateTextField;

	@FindBy(xpath="//input[@name='comment']") private WebElement commentTextfield;

	@FindBy(xpath="//button[text()='Book']") private WebElement bookBotton;

	@FindBy(xpath="//div[1]/div[1][contains(.,'Booked Successfully')]") private WebElement actualBookSuccessMessage;

	//initilization
	public PackageDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//untilization
	public WebElement getFromDateTextField() {
		return fromDateTextField;
	}

	public WebElement getToDateTextField() {
		return toDateTextField;
	}

	public WebElement getCommentTextfield() {
		return commentTextfield;
	}

	public void getBookBotton() {
		bookBotton.click();;
	}

	public WebElement getActualBookSuccessMessage() {
		return actualBookSuccessMessage;
	}

	public void enterFromDate()
	{
		String fromDate = jLib.getDate(5);
		fromDateTextField.sendKeys(fromDate);
	}

	public void enterToDate()
	{
		String toDate=jLib.getDate(10);
		toDateTextField.sendKeys(toDate);
	}

	public void enterComment(WebDriver driver,String comment) throws IOException
	{
		WebActionUtility wLib = new WebActionUtility();
		wLib.exceuteScript(driver, commentTextfield);
		commentTextfield.sendKeys(comment);
	}

	public void verifyBooking(String expectedMsg)
	{
		Assert.assertTrue(actualBookSuccessMessage.getText().equals(expectedMsg),"User failed "+expectedMsg );
		Reporter.log("User"+expectedMsg, true);
	}
}




