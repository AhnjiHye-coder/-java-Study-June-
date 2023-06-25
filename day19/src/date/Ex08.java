package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex08 {
	public static void main(String[] args) throws Exception {
		// 서로 다른 기간을 시작,종료 구성으로 2구성을 입력받아
		// 기간이 겹치는지 아닌지 판별하시오
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.print("기간1일 시작일 : ");
		Date n1 = sdf.parse(sc.nextLine()); 
		
		System.out.print("기간1일 종료일 : ");
		Date n2 = sdf.parse(sc.nextLine()); 
		
		System.out.print("기간2일 시작일 : ");
		Date p1 = sdf.parse(sc.nextLine()); 
		
		System.out.print("기간2일 종료일 : ");
		Date p2 = sdf.parse(sc.nextLine()); 
		
		boolean flag1 = p1.getTime() < n2.getTime();
		boolean flag2 = n1.getTime() < p2.getTime();
		
		System.out.println(flag1 ? "겹침" : "안 겹침");
		System.out.println(flag2 ? "겹침" : "안 겹침");
		
		sc.close();
	}
}
