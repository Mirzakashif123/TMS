package com.rena.tms.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.rena.tms.gerenic.JavaUtility;
import com.rena.tms.gerenic.WebActionUtility;

public class MyTourHistoryPage {

	//decalration
	@FindBy(xpath="(//tbody/tr)[last()]/td[2]") private WebElement expectedBookingIdText;

	@FindBy(xpath="(//tbody/tr)[last()]/td[7]") private WebElement expectedBookingConfirmText;

	@FindBy(xpath="(//tbody/tr)[last()]/td[9]//a[text()='Cancel']") private WebElement cancelBookingLink;

	@FindBy(xpath="//div[contains(@class,'Wrap')]") private WebElement cancelMessageText;

	//initilization
	public MyTourHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public String storeBookingId()
	{
		String BOOKINGID=expectedBookingIdText.getText();
		String[] value = BOOKINGID.toString().split("K");
		String ID = value[1];
		return ID;
	}

	public void verifybookingConfirmed(String expectedConfirmedMessage )
	{
		String actualConfirmedMessage = expectedBookingConfirmText.getText();
		Assert.assertTrue(actualConfirmedMessage.equalsIgnoreCase(expectedConfirmedMessage), "Users booking is not"+actualConfirmedMessage);
		Reporter.log("Users booking "+actualConfirmedMessage, true);

	}

	public void cancelBooking(WebDriver driver) throws IOException, InterruptedException
	{
		WebActionUtility wLib = new WebActionUtility();
		wLib.exceuteScript(driver, cancelBookingLink);
		cancelBookingLink.click();
		JavaUtility jLib = new JavaUtility(); 
		jLib.waitSleep();
		wLib.alertAccept(driver, "Do you really want to cancel booking");
	}

	public void verifyCancelBooking(String expectedCancelMsg)
	{
		String actualCancelMsg=cancelMessageText.getText();
		Assert.assertTrue(actualCancelMsg.contains(expectedCancelMsg), "user failed "+actualCancelMsg);
		Reporter.log("user "+actualCancelMsg, true);
	}
}

