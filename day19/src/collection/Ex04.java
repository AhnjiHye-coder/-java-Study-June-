package collection;

import java.util.InputMismatchException;
import java.util.Scanner;

class ScoreOutOfBoundsException extends Exception{
	// Exception 클래스를 상속받은 새로운 클래스
	// 예외가 가져야할 모든 항목들을 상속받아서 가지고 있게 된다
	
	private static final long serialVersionUID = 1L;
	private int value;
	
	public ScoreOutOfBoundsException(int vlaue) {
		this.value = vlaue;
	}
	
	@Override
	public String toString() {
		return "점수가 범위를 벗어났습니다 -> " + value;
	}
	
	
	@Override
	public String getMessage() {
		return this.getClass().toGenericString();
	}
	
}


public class Ex04 {
	public static void main(String[] args) throws Exception {
		// 예외 클래스 만들기
		Scanner sc = new Scanner(System.in);
		String result;
		int score;
		
		try {
			System.out.println("점수 입력(0 ~ 100) : ");
			score = sc.nextInt();
			
			if(score < 0 || 100 < score) {
				// 예외 객체를 생성하고 던진다
				ScoreOutOfBoundsException e = new ScoreOutOfBoundsException(score);
				throw e;	// 던진다(드로우)
			}
		}catch(InputMismatchException n) {
			System.out.println("잫못된 형식의 값을 입력했습니다");
			score = 0;
			
			// 억지로 만들어서 사용하려는 이유는 나중에 한 곳에 묶어서 사용하는 경우가 발생하기 떄문
			// 예외들을 한 곳에 몰아서 해결하는 코드도 가능하다
			// 상속을 받으면 예외로써 받아야하는 모든 조건을 모두 받아 쓸 수 있다
		}catch(ScoreOutOfBoundsException s) {	// 예외를 받는다
			// 시간을 딜레이하는 방법
			try {Thread.sleep(200);} catch(Exception r) {}	
			
			System.out.println(s.getMessage());
			System.out.println(s);
			score = 0;
		}finally {
			sc.close();
		}
		
		result = score >= 60 ? "합격" : "불합격";
		
		System.out.printf("점수 : %d, 결과 : %s\n", score, result);
		
	}
}


















