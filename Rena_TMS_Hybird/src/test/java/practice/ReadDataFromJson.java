package practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
       JSONParser p = new JSONParser() ; 
       Object obj = p.parse(new FileReader("C:\\Users\\hp\\Desktop\\TYSS MANUAL\\NotePad\\CommonData.json"));
       
       JSONObject map=(JSONObject) obj;
      Object BROWSER = map.get("browser");
       System.out.println(map.get(BROWSER));
       Object URL = map.get("url");
       System.out.println(URL);
       
	
	}
}
