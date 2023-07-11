package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider {

	@Test(dataProvider="data")
	public void takeData(String name ,String life )
	{
		System.out.println(name+" "+life);
	}
	
	@DataProvider
	public Object[][] data() 
	{
		Object[][] obj = new Object[3][2];
		
		obj[0][0]="Madhu";
		obj[0][1]="Sudhan";
		
		obj[1][0]="Madhu";
		obj[1][1]="Radha";
		
		obj[2][0]="Madhu";
		obj[2][1]="Krishna";
		return obj;	
	}
}
