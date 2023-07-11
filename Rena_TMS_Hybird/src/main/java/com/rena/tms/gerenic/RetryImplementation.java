package com.rena.tms.gerenic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This Class is developed for RetryImplementation of IRetryAnalyzer
 * @author Budarpu MadhuSudhan
 *
 */
public class RetryImplementation implements IRetryAnalyzer
{
	/**
	 * This Method is developed for Retry and Execute Script
	 */
	int count =0;
	int retryLimit=3;
	public boolean retry(ITestResult result) {
		if(count<retryLimit)
		{
		count++;
		return true;
		}
		return false;
	}

}
