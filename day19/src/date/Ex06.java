package date;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Ex06 {
	public static void main(String[] args) throws ParseException{
		// 컴퓨터의 맨 처음 시간은 1970년 1월 1일 00시 00분 00초가 기준이다
		
		Date d1 = new Date();	// 객체 생성 시점의 현재 날씨
		long t1 = d1.getTime();	// Date에 저장된 정수 값을 long으로 반환
		// millisecond : 1 / 1000초
		System.out.println("t1 : " + t1);
		
		// 밀리세컨즈 초로 변환
		t1 =  t1 / 1000;
		
		long sec = t1 % 60;
		t1 = t1 / 60;
		
		long minute = t1 % 60;
		t1 /= 60;
		
		long hour = t1 % 24;
		t1 /= 24;
		
		System.out.printf("%d:%d:%d\n", hour,minute, sec);
		
		System.out.println(t1);
		
		long year = t1 / 365;
		System.out.println(year + 1970);
		
		// Date타입의 값을 서식에 맞춰서 문자열로 변경해주는 클래스
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		String now = sdf.format(d1);// Date를 String로 변경
		System.out.println("now : " + now);
		
		String s2 = "1993-05-16 오전 00:00:00";
		Date d2 = sdf.parse(s2);// String를 Date로 변경
		System.out.println("d2 : " + d2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
