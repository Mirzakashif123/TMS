package com.rena.tms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSignInPage {
	
	//declaration
	@FindBy(xpath="//input[@name='username']") private WebElement usernameTextFiled;

	@FindBy(xpath="//input[@name='password']") private WebElement passwordTextFiled;

	@FindBy(xpath="//input[@name='login']") private WebElement loginButton;

	@FindBy(xpath="//a[text()='Back to home']") private WebElement backToHomeLink;

	//Initilization
	public AdminSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUsernameTextFiled() {
		return usernameTextFiled;
	}

	public WebElement getPasswordTextFiled() {
		return passwordTextFiled;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getBackToHomeLink() {
		return backToHomeLink;
	}

	//bussiness librabries
	public void AdminLogin(String username,String password)
	{
		usernameTextFiled.sendKeys(username);
		passwordTextFiled.sendKeys(password);
		loginButton.click();
	}
	
	public void returnToHomePage()
	{
		backToHomeLink.click();
	}
}
