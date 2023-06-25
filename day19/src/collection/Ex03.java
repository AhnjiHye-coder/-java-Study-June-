package collection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int o1 = 0, o2 = 0;
		String tmp = null;
		
		try {	// 문자,정수 둘다 받기
			System.out.print("입력1 : ");
			tmp = sc.nextLine();
			o1 = Integer.parseInt(tmp);
			
			System.out.print("입력2 : ");
			tmp = sc.nextLine();
			o2 = Integer.parseInt(tmp);
			
		}catch(NumberFormatException e) {
			System.err.println("err발생");
			System.out.println(e.toString());
			return;
			
		}catch(Exception n) {
			System.out.println("기타 예외 발생 : " + n);
			// catch는 클래스의 상속구조에 따라 슈퍼클래이기 때문에 서브클래스 아래에
			// 배치되어야 한다
			
		}finally {
			System.out.println("시스템 종료");
			sc.close();
		}
		System.out.printf("%d + %d = %d\n", o1, o2, o1 + o2);
	
		
	}
}
