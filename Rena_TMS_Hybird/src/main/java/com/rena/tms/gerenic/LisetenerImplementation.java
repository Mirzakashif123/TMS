package com.rena.tms.gerenic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * This class is devloped for Listener Implementation 
 * @author Budarpu Madhusudhan
 *
 */
public class LisetenerImplementation implements ITestListener{

	
	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		
	}
/**
 * This Method is devloped for Taking ScreenShot for failed tetScripts
 */
	public void onTestFailure(ITestResult result) {
	String methodName = result.getMethod().getMethodName();
	LocalDate dt = LocalDate.now();
	String dateTime = dt.toString().replace(" ","_").replace(" ", "_");
	TakesScreenshot takesScreenshot=(TakesScreenshot)BaseClass.sdriver;
	File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
	File desc= new File("./ScreenShot/"+methodName+"_"+dateTime +".png"); 
	try {
		FileUtils.copyFile(src, desc);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
 
	
}
