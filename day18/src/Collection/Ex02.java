package Collection;

import java.util.ArrayList;

public class Ex02 {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList<>();
		System.out.println("리스트의 크기 : " + list.size());
		
		list.add(10);		// 리스트에 객체를 추가하는 메서드
		list.add(20);		// 리스트의 맨 마지막에 요소를 추가한다
		list.add("ITBANK");	// 리스트의 값을 추가할 때마다 길이가 증가
		list.add(20);		// 리스트에서는 값의 중복이 허용된다
		
		// 컬렉션 toString()이 오버라이딩 되어있어서 바로 출력할 수 있다
		System.out.println(list);
		// 원래 리스트의 size는 0이었지만 add로 값을 추가함으로 현재 길이는 4로 변경되었다
		System.out.println("리스트의 크기 : " + list.size());
		System.out.println();
		
		// 리스트에서 index를 이용하여 특정 요소 불러오기
		// 리스트에서 삭제되는 것은 아니다
		System.out.println("list.get(0) : " + list.get(0));
		System.out.println("list.get(1) : " + list.get(1));
		System.out.println("list.get(2) : " + list.get(2));
		System.out.println("list.get(3) : " + list.get(3));
		System.out.println();
		
		// remove : 값이 제거된다
		list.remove(1);		// remove(int index) : index번쨰 객체 삭제 한다
							// 빈칸을 그대로 두지 않고 당겨서 채우고 size가 감소한다
		
		System.out.println(list); 
		System.out.println("리스트의 크기 : " + list.size());
		System.out.println();
		
		// 반복되는 작업을 처리하는 별도의 메서드가 있다
		
		// forEach : 배열을 순회하는 메서드로 o라는 key와 그에 맞는 o(value)를
		// 반복적으로 출력하는 방법이다
		// 밑에 코드대로 한다면 key의 index 순서대로 value를 출력한다
		list.forEach(o -> System.out.println(o));
		
		// Object 클래스에서는 replace()함수가 정의되어 있지 않아서 호출할 수 없다
		// list.forEaxh(o -> System.out.println(s.replace(" ". "")));
		
		
		
		
	} 

}
