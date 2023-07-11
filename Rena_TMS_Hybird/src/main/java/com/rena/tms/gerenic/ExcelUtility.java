package com.rena.tms.gerenic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This Class is developed for Performing Action on MS-Excel 
 * @author Budarpu MadhuSudhan
 *
 */
public class ExcelUtility 
{
	/**
	 * This method is developed to fetch the data from Excel FIle 
	 * @param FILE_PATH
	 * @param sheetName
	 * @param tC_Id
	 * @param Header
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String FILE_PATH,String sheetName, String tC_Id , String Header ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(FILE_PATH);
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int takeRowCount = 0;
		String rowData="";
		String cellData="";
		String data="";
		for(int i=0;i<=rowCount;i++)
		{
			try { rowData = sheet.getRow(i).getCell(0).toString();}catch(Exception e) {};
			if(rowData.equalsIgnoreCase(tC_Id))
			{
				break;
			}
			takeRowCount++;	
		}
		int takeCellCount= 0;
		int lastCellNum = sheet.getRow(takeRowCount-1).getLastCellNum();
		for(int j =0;j<=lastCellNum;j++)
		{
			try{cellData=sheet.getRow(takeRowCount-1).getCell(j).toString();}catch(Exception e) {};
			if(cellData.equals(Header))
			{
				break;
			}
			takeCellCount++;
		}
		try { data = sheet.getRow(takeRowCount).getCell(takeCellCount).toString();}catch(Exception e) {};
		return data;
	}
	
}
