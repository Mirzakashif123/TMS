package com.rena.tms.pom;

import java.io.IOException;

import org.apache.poi.ss.formula.functions.WeekNum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.rena.tms.gerenic.FileUtility;
import com.rena.tms.gerenic.WebActionUtility;

public class AdminPackageCreationPage
{
	 FileUtility fLib = new FileUtility() ;
	 
@FindBy(xpath="//input[@id='packagename']") private WebElement packageNameTextFiled;
	
	@FindBy(xpath="//input[@id='packagetype']") private WebElement packageTypeTextFiled;
	
	@FindBy(xpath="//input[@id='packagelocation']") private WebElement packageLocTextFiled;
	
	@FindBy(xpath="//input[@id='packageprice']") private WebElement packagePriceTextFiled;
	
	@FindBy(xpath="//input[@id='packagefeatures']") private WebElement packageFeatureTextFiled;
	
	@FindBy(xpath="//textarea[@id='packagedetails']") private WebElement packageDetailsTextfiled;
	
    @FindBy(xpath="//input[@name='packageimage']") private WebElement packageImageButton;
    
	@FindBy(xpath="//button[text()='Create']") private WebElement createButton;
	
	@FindBy(xpath="//div[contains(text(),':Package Created Successfully ')]") private WebElement actualMsgText;
	
	//intinlization
	public AdminPackageCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getPackageNameTextFiled() {
		return packageNameTextFiled;
	}

	public WebElement getPackageTypeTextFiled() {
		return packageTypeTextFiled;
	}

	public WebElement getPackageLocTextFiled() {
		return packageLocTextFiled;
	}

	public WebElement getPackagePriceTextFiled() {
		return packagePriceTextFiled;
	}

	public WebElement getPackageFeatureTextFiled() {
		return packageFeatureTextFiled;
	}

	public WebElement getPackageDetailsTextfiled() {
		return packageDetailsTextfiled;
	}

	public WebElement getPackageImageButton() {
		return packageImageButton;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	public WebElement getActualMsgText() {
		return actualMsgText;
	}
	
	
     public void getAllTextfields(WebDriver driver,String packagename,String packagetype,String packageLoc,String packageprice,String feature,String details,String key) throws IOException
     {
    	 WebActionUtility wLib = new WebActionUtility();
    	 packageNameTextFiled.sendKeys(packagename);
    	 packageTypeTextFiled.sendKeys(packagetype);
    	 packageLocTextFiled.sendKeys(packageLoc);
    	 packagePriceTextFiled.sendKeys(packageprice);
    	 packageFeatureTextFiled.sendKeys(feature);
         String PICPATH = fLib.getExternalFileData(key);
    	 wLib.fileUploadPopUp(driver,PICPATH, packageImageButton);
    	 packageDetailsTextfiled.sendKeys(details);
         wLib.exceuteScript(driver, createButton);
         createButton.click();
     }
     
     public void verifyTourPackageCreated(String expectedTourCreatedMessage )
     {
    	 String actualTourCreatedMessage=actualMsgText.getText();
    	 
    	 Assert.assertTrue(actualTourCreatedMessage.equalsIgnoreCase(expectedTourCreatedMessage), "Admin failed in "+actualTourCreatedMessage);
				Reporter.log("Admin"+actualTourCreatedMessage, true);

     }
     
    


}
