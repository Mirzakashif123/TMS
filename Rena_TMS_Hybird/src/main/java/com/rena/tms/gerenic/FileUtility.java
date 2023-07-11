package com.rena.tms.gerenic;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This Class is developed to get data from external files
 * @author Budarpu Madhusudhan
 *
 */
public class FileUtility 
{
   /**
    * This method is developed for fetching the path from external files 
    * @param key
    * @return String Path
    * @throws IOException
    */
	public String getExternalFileData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/ExternalFile.property");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
/**
 * This method is developed for fetch data from Property FILE
 * @param FILE_PATH
 * @param key
 * @return Value
 * @throws IOException
 */
	public String getPropertyData(String FILE_PATH,String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(FILE_PATH);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
