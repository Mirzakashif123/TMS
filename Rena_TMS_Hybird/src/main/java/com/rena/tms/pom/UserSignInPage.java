package com.rena.tms.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSignInPage {
	//declaration
	@FindBy(xpath="//input[@placeholder='Enter your Email']") private WebElement userUsernameTextfiled;

	@FindBy(xpath="//input[@id='password']") private WebElement userPasswordTextfiled;

	@FindBy(xpath="//input[@name='signin']") private WebElement userSignInButton;
	
	//intialization
	public UserSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUserUsernameTextfiled() {
		return userUsernameTextfiled;
	}

	public WebElement getUserPasswordTextfiled() {
		return userPasswordTextfiled;
	}

	public WebElement getUserSignaInButton() {
		return userSignInButton;
	}
	
	//bussiness Libraries
	public void getUserSign(String username,String password)
	{
		userUsernameTextfiled.sendKeys(username);
		userPasswordTextfiled.sendKeys(password);
		userSignInButton.click();
		
	}
	
	
}
