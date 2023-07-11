package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataProviderTestingExcel 
{
	public void dataFromExcel() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream("C:\\Users\\hp\\Desktop\\TYSS MANUAL\\ExcelFiles\\DataProviderTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet row = wb.getSheet("DB");
		int rowCount = row.getLastRowNum();
		Object[][] obj = new Object[10][2];
	}
}
