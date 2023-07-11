package practice;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.rena.tms.gerenic.JavaUtility;

import io.opentelemetry.sdk.metrics.data.Data;

public class DateToday {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);

		SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");
		String fDate = sim.format(d);
		System.out.println(fDate);
		
		JavaUtility jl = new JavaUtility();
		String date = jl.getDate();
		System.out.println(date);
		System.out.println(jl.getDate(10));

		
		System.out.println(jl.getRandomNum());
	}

}
 