package com.rena.tms.pom;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rena.tms.gerenic.JavaUtility;

public class UserSignUpPage {
	
	JavaUtility jLib =new JavaUtility();
	@FindBy(xpath="//input[@name=\"fname\"]") private WebElement fullnameTextField;
	
	@FindBy(xpath="//input[@name=\"mobilenumber\"]")private WebElement phonenumtextfield;
	
	@FindBy(xpath="//input[@placeholder=\"Email id\"]") private WebElement emailTextfield;
	
	@FindBy(xpath="//div[@id='myModal']/descendant::input[@name='password']") private WebElement passwordTextfield;
	
	@FindBy(xpath="//input[@value='CREATE ACCOUNT']") private WebElement createAccountButton;
	
	
	public UserSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void userSignUp1(String fullname1,String phonenum1,String email1,String password1) throws InterruptedException 
	{
		fullnameTextField.sendKeys(fullname1);
		jLib.waitSleep();
		DateFormatter dat = new DateFormatter();
	//	String t = dat.toString();
	    phonenumtextfield.sendKeys(phonenum1);
		int rNum1 = jLib.getRandomNum();
		String num = rNum1+"";
		jLib.waitSleep();
		emailTextfield.sendKeys(num+email1);
		passwordTextfield.sendKeys(password1);
		createAccountButton.click();	
	}
	public void userSignUp2(String fullname2,String phonenum2,String email2,String password2) throws InterruptedException
	{
		fullnameTextField.sendKeys(fullname2);
		jLib.waitSleep();
		phonenumtextfield.sendKeys(phonenum2);
		int rNum1 = jLib.getRandomNum();
		String num = rNum1+"";
		jLib.waitSleep();
		emailTextfield.sendKeys(num+email2);
		passwordTextfield.sendKeys(password2);
		createAccountButton.click();	
	}
}
