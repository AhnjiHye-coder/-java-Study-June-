package abstractClass;

import java.util.Arrays;
import java.util.Comparator;

public class Ex06 {
	public static void main(String[] args) {
		
		// 인터페이스도 추상클래스에 속하기 때문에, 익명 내부 클래스 문법으로 사용할 수 있다
		Runnable run1 = new Runnable() {
			@Override
			public void run() { // 매개변수의 개수가 0(생략불가)
				System.out.println("run1");	// 코드가 한줄 (생략가능)
				
			}
		};
		run1.run();
		
		
		// 람다식을 활용하면 아래와 같이 생성한다
		// {};을 생략하지 ㅇ낳아도 문법에 어긋나지 않는다
		Runnable run2 = () -> System.out.println("run2");
		run2.run();
		
		// 람다식 기본 형식 : () -> {};
		// () : 함수의 매개변수를 작성하는 공간, 매개변수가 하나라면 ()생략가능
		// -> : 람다식 기호
		// {} : 함수의 실행내용(body) 실행코드가 한줄이면 {}을 생략
		// 		한줄의 실행코드가  return이면 return도 생략하고 반환값만 작성
		// Comparable는 매개변수가 1개일때 사용
		// 자기자신과 매개변수를 비교하는 것이고 compateTo 함수가 내장되어있다
		Comparable<String> comp1 = new Comparable<String>() {
			
			@Override
			public int compareTo(String o) { // 매개변수 1개 (생략가능)
				return "hello".compareTo(o); // 실행코드 1줄 (생략가능)
			}
		};
		
		int res1 = comp1.compareTo("Hello");
		System.out.println("res1 : " + res1);
		
		Comparable<String> comp2 = o -> "hello".compareTo(o);
		
		int res2 = comp2.compareTo("Hello");
		System.out.println("res2 : " + res2);
		
		// 전/후 비교
		// 람다식 적용 전
		// Comparator는 2개의 매개변수가 있을때 사용하고 compare함수가 내장되어있다
		Comparator<Integer> comp3 = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		
		Integer n1 = 10;
		Integer n2 = 20;
		int res3 = comp3.compare(n1, n2);
		System.out.println("res3 : " + res3);
		
		// 람다식 적용 후
		Comparator<Integer> comp4 = (o1,o2) -> o1.compareTo(o2);
		int res4 = comp4.compare(n1,n2);
		System.out.println("tes4 : " + res4);
		
		
		// comparator 활용
		Integer[] arr = {4, 8, 2, 7, 6};
		
		Arrays.sort(arr,comp4);
		System.out.println(Arrays.toString(arr));
		
		// 자리 바꾸는 것을 간단하게 수행할 수 있다
		// arr(이 배열을 어떤 방식으로 정렬할 것인가?) a와 b를 전달 받아서 a에서 b를 비교한 값을
		Arrays.sort(arr,(a,b) -> a - b);	// a.compareTo(b)방법도 가능
		// 						if(arr[i] - arr[j] > 0)
		// 정렬할 것이다 / 배열을 문자열로 리턴한다
		System.out.println(Arrays.toString(arr));
		// 배열은 그냥 출력하면 알아볼 수 없는 값이 나온다
		// 그래서 toString를 해줘야 한다
		System.out.println(arr);
		
		
		
	}
}








