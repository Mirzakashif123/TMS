package com.rena.tms.pom;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.rena.tms.gerenic.JavaUtility;
import com.rena.tms.gerenic.WebActionUtility;
/**
 * This Class is devloped for  
 * @author hp
 *
 */
public class AdminManageBookingsPage
{
 @FindBy(xpath="//div[contains(text(),':Booking Confirm successfully ')]") private WebElement bookingConfirmMessage;

	public AdminManageBookingsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void adminConfirmBooking(WebDriver driver,String expectedId) throws IOException, InterruptedException
	{
		WebActionUtility wLib=new WebActionUtility();
		List<WebElement> bookingIds = driver.findElements(By.xpath("//tbody/tr/td/span[contains(text(),'#BK-')]"));
		for(WebElement bI:bookingIds)
		{
			String actualBookingIdText = bI.getAttribute("innerHTML").toString().replaceAll("-", "");
			if(actualBookingIdText.contains(expectedId))
			{
				WebElement confirmLink = driver.findElement(By.xpath("//span[contains(text(),'"+expectedId+"')]/../../descendant::a[text()='Confirm']"));
				wLib.exceuteScript(driver, confirmLink);
				confirmLink.click();
				JavaUtility jLib = new JavaUtility();
				jLib.waitSleep();
				wLib.alertAccept(driver, "Do you really want to ");
				break;
			}
		}
	}
	
	public void verifyBookingConfirmation(String expectedBookingConfirmMessage)
	{
		String actualBookingConfirmMessage = bookingConfirmMessage.getText();
		
		Assert.assertTrue(actualBookingConfirmMessage.equalsIgnoreCase(expectedBookingConfirmMessage), "Admin failed "+actualBookingConfirmMessage);
		Reporter.log("Admin "+actualBookingConfirmMessage,true);
	}
}


