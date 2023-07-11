package practice;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ChangeDateAfter30Days {

	public static void main(String[] args) {
      
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy_MM_dd");
		 String fdate = sim.format(d);
		System.out.println(fdate);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,10);
		Date date = cal.getTime();
		
		
		SimpleDateFormat sim1 = new SimpleDateFormat("yyyy_MM_dd");
		 String ndate = sim.format(date);
		System.out.println(ndate);
	}

}
