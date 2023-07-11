package com.rena.tms.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TMSHomePage {

	//declaration
	@FindBy(xpath="//a[text()='Admin Login']") private WebElement adminLoginButton;

	@FindBy(xpath="//a[text()='/ Sign In']") private WebElement userLoginButton;

	@FindBy(xpath="//a[text()='My Tour History']") private WebElement myTourHistoryButton;

	@FindBy(xpath ="//a[text()='/ Logout']") private WebElement userLogOutButton;
	
	@FindBy(xpath="//a[text()='Sign Up']") private WebElement userSignUpButton;

	//initilaztion
	public TMSHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//untilization
	public WebElement getAdminLoginButton() {
		return adminLoginButton;
	}

	public WebElement getUserLoginButton() {
		return userLoginButton;
	}

	public WebElement getMyTourHistoryButton() {
		return myTourHistoryButton;
	}

	public void getUserLogOutButton() {
	 userLogOutButton.click();;
	}
	
	//business
	public void clickOnUserLoginButton()
	{
		userLoginButton.click();
	}
	
	public void clickOnAdminLoginButton()
	{
		adminLoginButton.click();
	}
	
	public void clickOnMyTourHistory()
	{
		
		myTourHistoryButton.click();
	}
	
	public void clickOnUserSignUpButton()
	{
		userSignUpButton.click();
	}

}






