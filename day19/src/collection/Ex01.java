package collection;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		
		// 프로그램 진행 중 발생하는 예외 상황을 나타내기 위한 클래스 : (입섹션)Exception
		// 예외 상황 조차도 객체로 나타낸다
		
		Scanner sc = new Scanner(System.in);
		int n1, n2, result;
		
		System.out.println("정수1 입력 : ");
		String s1 = sc.nextLine();
		
		boolean flag1 = true;
		for(int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if(ch > 0 || 9 > ch) {
				flag1 = false;
			}
		}
		if(flag1 == false) {
			System.out.println("정수가 올바르게 입력되지 않았습니다");
			System.out.println("다시 실행해주세요");
			sc.close();
			return;
		}
		else {
			n1 = Integer.parseInt(s1);
		}
		System.out.println("정수2 입력 : ");
		n2 = sc.nextInt();
		
		result = n1 + n2;
		System.out.println("result : " + result);
		
		sc.close();
		
	}
}
