package period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Solution2 {

	public boolean isConflict(Date d1, Date d2, Date d3, Date d4) {
		boolean flag = false;
		
		long ln1 = d1.getTime();
		long ln2 = d2.getTime();
		long ln3 = d3.getTime();
		long ln4 = d4.getTime();
		
		
		if(ln1 > ln3 && ln2 > ln4) {
			long tmp = ln1;
			ln1 = ln3;
			ln3 = tmp;
			
			tmp = ln2;
			ln2 = ln4;
			ln4 = tmp;
		}
		
		if(ln2 >= ln3) {
			flag = true;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String p1 = String.format("[%s ~ %s]", sdf.format(d1), sdf.format(d2));
		String p2 = String.format("[%s ~ %s]", sdf.format(d3), sdf.format(d4));

		System.out.printf("%s와 %s는 %s\n\n", p1, p2, flag ? "겹친다" : "겹치지 않는다");
		return flag;
		
	}
	
}

public class Main2 {
	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse("2022-01-01");
		Date d2 = sdf.parse("2022-06-10");
		Date d3 = sdf.parse("2022-05-01");
		Date d4 = sdf.parse("2023-12-31");
		
		Solution2 s = new Solution2();
		boolean flag1 = s.isConflict(d1, d3, d2, d4);  // true
		boolean flag2 = s.isConflict(d1, d2, d3, d4);  // false
		boolean flag3 = s.isConflict(d1, d4, d2, d3);  // true
		boolean flag4 = s.isConflict(d2, d3, d1, d4);  // true
		boolean flag5 = s.isConflict(d3, d4, d1, d2);  // false
		
		
		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3);
		System.out.println(flag4);
		System.out.println(flag5);
		
		
	}
}
