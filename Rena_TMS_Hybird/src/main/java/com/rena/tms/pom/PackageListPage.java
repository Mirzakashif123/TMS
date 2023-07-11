package com.rena.tms.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rena.tms.gerenic.WebActionUtility;

public class PackageListPage {
	//decalration
	@FindBy(xpath="(//a[text()='Details'])[last()]") private WebElement tourDetailsButton;
	
	@FindBy(xpath="//a[text()=' / Write Us ']") private WebElement writeUslink;
	
	@FindBy(xpath="//select[@class='frm-field required sect']") private WebElement issueDropdown;
	
	@FindBy(xpath="//input[@name='description']") private WebElement descriptionTextfiled;
	
	@FindBy(xpath="//button[@type='submit']") private WebElement submitButton;
	

	//intialization
	public PackageListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public void getTourDetailsButton(WebDriver driver) throws IOException {
		WebActionUtility wLib = new WebActionUtility();
		wLib.exceuteScript(driver, tourDetailsButton);
		 tourDetailsButton.click();
	}
    
	public void writeIssue(String visibleText,String description) throws IOException
	{
		writeUslink.click();
		WebActionUtility wLib = new WebActionUtility();
		wLib.select(issueDropdown, visibleText);
		descriptionTextfiled.sendKeys(description);
		submitButton.click();
	}


}
