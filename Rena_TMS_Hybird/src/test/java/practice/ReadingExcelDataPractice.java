package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.rena.tms.gerenic.ExcelUtility;

public class ReadingExcelDataPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	 ExcelUtility eLib = new ExcelUtility();
	 String packageName = eLib.getExcelData("./src/test/resources/TestData.xlsx","Booking","tc_01","PackageName");
	 System.out.println(packageName);

	}

}
