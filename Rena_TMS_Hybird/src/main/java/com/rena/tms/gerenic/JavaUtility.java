package com.rena.tms.gerenic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**
 * This Class is developed for getting Date,CustomDate,RandomNum etc..,
 * @author BudarpuMadhusudhan
 *
 */
public class JavaUtility {
	Date dObj= new Date();
	SimpleDateFormat sim = new SimpleDateFormat("YYYY/MM/dd");
	/**
	 * This Method is developed for getting Current Date in"YYYY/MM/DD"
	 * @return date
	 */
	public String getDate()
	{
		String date = sim.format(dObj);
		return date;
	}
	/**
	 * This method is developed to get the required date in "yyyy-MM-dd "format 
	 * if days is positive number , it provides upcoming date based numeric count
	 * if days is negative number , it provides previous date based numeric count
	 * @param days
	 * @return
	 */
	public String getDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date date1 = cal.getTime();
		String date = sim.format(date1);
		return date;
	}
	/**
	 * This Method is developed for genarating random integer value
	 * @return random valvue
	 */
	public int getRandomNum()
	{
		Random r = new Random();
		int randomNum = r.nextInt(5000);
		return randomNum;
	}
	/**
	 * This Method is 
	 * @throws InterruptedException
	 */
	public void waitSleep() throws InterruptedException
	{
		 Thread.sleep(5000);
	}
}


