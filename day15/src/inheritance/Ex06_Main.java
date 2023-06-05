package inheritance;

import java.util.Scanner;

public class Ex06_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		// 속성이 있는 class를 main에서 사용하겠다는 절차 1단계
		Ex06_MessageBox box1 = new Ex06_MessageBox(sc);
		box1.input();
		String s1 = box1.getMessage();
		System.out.print("s1 : " + s1);
		System.out.println();
		
		// 슈퍼클래스의 입력 부분을 Time가 상속받고 그 형식대로 main클래스에서
		// 사용하기 위해 msg 기능을 담고 있는 클래스의 객체를 하나 생성함
		Ex06_TimeMessageBox box2 = new Ex06_TimeMessageBox(sc);
		box2.input();
		String s2 = box2.getMessage();
		System.out.print("s2 : " + s2);
		System.out.println();
		
		Ex06_MessageBox test = box2;
		test.input();
		String s3 = test.getMessage(); // 입력받은 메세지를 get(내보낸다)
		System.out.println("s3 : " + s3);
		System.out.println();
		
		sc.close();
		
		
		
	}
}
