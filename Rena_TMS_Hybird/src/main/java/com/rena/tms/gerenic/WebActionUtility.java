package com.rena.tms.gerenic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;
/**
 * This Class is developed for generic method of WebActions
 * @author Budarpu Madhusudhan
 *
 */
public class WebActionUtility 
{
	FileUtility fLib = new FileUtility();
	int TIME; 
	public WebActionUtility()  {
		String CFILE_PATH;
		try {
			CFILE_PATH = fLib.getExternalFileData("PropertyFilePath");
			String TIMEOUT = fLib.getPropertyData(CFILE_PATH, "time");
			TIME = Integer.parseInt(TIMEOUT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is developed for synchronization using IMPLICITLY WAIT
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME));
	}
	/**
	 * This method is developed for synchronization using EXPLICITLY WAIT
	 * @param driver
	 * @param ELEMENT
	 */
	public void explicitlyWaitForElement(WebDriver driver,WebElement ELEMENT)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME));
		wait.until(ExpectedConditions.visibilityOf(ELEMENT));
	}
	/**
	 *   This method is developed for synchronization using EXPLICITLY WAIT
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 * @throws Throwable 
	 */
	public void explicitlyWaitForPage(WebDriver driver , String partailPageURL) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME));
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}
	/**
	 * This method is developed for synchronization using CUSTOMWAIT
	 * For Clicking
	 * @param ELEMENT
	 * @throws InterruptedException
	 */
	public void customWait(WebElement ELEMENT) throws InterruptedException
	{
		int count=0;
		while(count>TIME)
		{
			try
			{
				ELEMENT.click();
				break;
			}
			catch(Exception e )
			{
				Thread.sleep(5000);
				count++;
			}
		}
	}
	/**
	 * This method is developed for synchronization using CUSTOMWAIT
	 * For writing data
	 * @param element
	 * @param data
	 * @throws InterruptedException
	 */
	public void waitAndType(WebElement ELEMENT, String data) throws InterruptedException
	{
		int count = 0;
		while(count<TIME) {
			try {
				ELEMENT.sendKeys(data);
				break;
			}catch(Throwable e){
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This method is developed for Switch the Window based on TITLE
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchToWindow(WebDriver driver,String expectedTitle)
	{
		Set<String> winAdd = driver.getWindowHandles();
		for(String wh:winAdd)
		{
			String curentTitle = driver.getTitle();
			if(curentTitle.equalsIgnoreCase(expectedTitle))
			{
			driver.switchTo().window(wh);
			System.out.println(expectedTitle + "Switch to Window is passed--!");
			}
		}
	}
	/**
	 * This method is developed for Switch the Window based on URL
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchToWindowURL(WebDriver driver,String expectedPartialURL)
	{
		Set<String> winAdd = driver.getWindowHandles();
		for(String wh:winAdd)
		{
			String curentTitle = driver.getCurrentUrl();
			if(curentTitle.equalsIgnoreCase(expectedPartialURL))
			{
			driver.switchTo().window(wh);
			System.out.println(expectedPartialURL + "Switch to Window is passed--!");
			}
		}
	}
	/**
	 * This method is developed for alertPOPUP accept
	 * @param driver
	 */
	public void alertAccept(WebDriver driver,String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().trim().contains(expectedMsg.trim())) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		alt.accept();
	}
	/**
	 * This method is developed for alertPOPUP Dismiss
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver,String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(expectedMsg.trim())) 
		{
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		alt.dismiss();
	}
	/**
	 * This method is developed for FILEUPLOAD popup
	 * @param driver
	 * @param Path
	 * @param element
	 */
	public void fileUploadPopUp(WebDriver driver,String Path,WebElement element)
	{
		File f = new File(Path);
		String abspath = f.getAbsolutePath();
		element.sendKeys(abspath);

	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver , String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element , String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver , WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * This Method is developed to right click  on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void rightClickOnElement(WebDriver driver , WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This Method is developed for JAVASCRIPT actions
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver , String javaScript) {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeAsyncScript(javaScript);
	}
	/**
	 * This Method is developed for move Scroll Bar to required Element
	 * @param driver
	 * @param element
	 */
	public void exceuteScript(WebDriver driver,WebElement element)
	{
//		String num = a+"";
     	String script = "arguments[0].scrollIntoView()";
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript(script, element);
	}
	    /**
	     * pass enter Key appertain in to Browser
	     * @param driver
	     */
	   public void passEnterKey(WebDriver driver) {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   } 
}
