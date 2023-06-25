package collection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n1 = 0, n2 = 0, sum = 0;
		
		// 트라이 : 예외 발생 가능성이 있는 코드를 넣어서 묶어 처리한다
		try {
			System.out.println("정수1 입력 : ");
			n1 = sc.nextInt();
			
			System.out.println("정수2 입력 : ");
			n2 = sc.nextInt();
			
			sum = n1 + n2;
			System.out.println("sum : " + sum);
			
			// 캐치 : 특정 타입의 예외가 발생하면 처리하는 코드를 작성하는 영역이다
			// 사용방식은 발생한 예외를 자료형처럼 넣고 매개변수를 선정하여
			// 매개변수로 예외가 발생했을때 처리방식을 어떻게 할 것인지 구현한다
		}catch(InputMismatchException e) {
			System.err.println("잘못 입력하셨습니다");
			System.out.println(e.toString());
			// 여기서 리턴의 효과는 리턴을 만나면서 코드는 종료된다.
			// 히지만 리턴을 넣지 않으면 종료되지 않고 다음 영역이 실행된다.
			return;
			
			// 파이널리 :  어떠한 경우에도 실행되는 영역이다
		}finally {
			sc.close();
		}
		System.out.println("프로그램 종료");
	}
}

// 다음 코드로 넘어갈때 : system("pause");(퍼스)
// system("cls");