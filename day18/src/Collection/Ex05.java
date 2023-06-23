package Collection;

import java.util.ArrayList;

public class Ex05 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("apple");
		list.add("banana");
		list.add("car");
		list.add("dinosaur");
		list.add("elephant");
		
		System.out.println(list);
		System.out.println(list.size());
		
		System.out.println("list.contains(\"car\") : " + list.contains("car"));
		System.out.println("list.contains(\"carpet\") : " + list.contains("carpet"));
		System.out.println();
		
		// indexOf : 객체가 몇번에 있는지 비교하고 출력하고 없으면 -1을 반환한다
		System.out.println("list.indexOf(\"car\")" + list.indexOf("car"));
		System.out.println("list.indexOf(\"carpet\")" + list.indexOf("carpet"));
		System.out.println();
		
		// removeIf : 조건을 만족하는 객체를 삭제 하겠다
		list.removeIf(s -> s.contains("r"));
		
		System.out.println(list);
		
		list.add("carpet");
		list.add("dictionary");
		
		System.out.println(list);
		
		// sort : 정렬해준다
		// 간편하게 정렬 완료
		list.sort(null);
		// String은 comparable하기 떄문에, 별도의 Comparator를 전달하지 않아도 된다
		// java 8 api 문서에서 java.leng.String 클래스 참조
		
		System.out.println(list);
		
		// 별도로 전달하고 싶은 경우
		list.sort((a,b) -> a.length() - b.length());
		// 필요하다면 특정 정렬 기준을 제시하는 Comparator를 전달할 수도 있다
		System.out.println(list);
		
		
		
	
		
	}
}
