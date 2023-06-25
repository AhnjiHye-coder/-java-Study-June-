package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07 {
	public static void main(String[] args) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd E W주차");
		
		String begin = "2023-06-01";
		String end = "2023-06-30";
		
		Date d1 = sdf.parse(begin);
		Date d2 = sdf.parse(end);
		
		System.out.println(d1);
		System.out.println(d2);
		
		for(long i = d1.getTime(); i <= d2.getTime(); i += 1000 * 60 * 60 * 24) {
			Date n = new Date(i);
			String s = sdf1.format(n);
			if(s.contains("토")) {
				System.out.println();
			}
		}
		
	}
}
