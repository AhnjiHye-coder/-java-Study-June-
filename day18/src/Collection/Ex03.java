package Collection;

import java.util.ArrayList;

public class Ex03 {
	public static void main(String[] args) {
		// 컬렉션의 제네릭 타입
		
		// 컬렉션에 들어가는 객체는 기본적으로 object로 취급된다
		// object로 되어있으면 모든 객체를 추가할 수 있다는 장점이 있으나
		// 특정 프로그램에서는 보통 특정 타입의 객체만 다루게 되고
		// object로 업케스팅 되어있으면 특정 메서드를 호출하기 위해 다운 캐스팅을 수행해야 한다
		// 불필요한 다운 캐스팅을 하지 않기 위해서 리스트에 들어가는 객체의 표준 타입을 지정할 수 있다
		// 자바 1.5이후로는 제네릭 타입을 지정하는 것이 기본 권장 사항이다
		
		ArrayList<String> list = new ArrayList<>();
		
		// 이렇게 입력하면 ArrayList의 타입이 String이기 때문에 타입문제로 오류발생
		// list.add(10); 
		
		list.add("10");
		list.add("20");
		list.add("I T B A N K");
		list.add("20");
		
		System.out.println(list);
		
		// 자체적으로 바로 바꾸면서 반환형이 없는 함수를 사용해야 한다
		// ArrayList을 제네릭 타입인 String로 지정했기 때문에 가능하다
		list.forEach(s -> System.out.println(s.replace("", " ")));
		
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("list.get(%d) : %s\n", list.get(i));
		}
		System.out.println();
		
		for(String s : list) {		// list를 s로 취급하고
			System.out.println(s);	// s를 출력하면 list 자체를 출력하게 된다
		}
		System.out.println();
	}
}
