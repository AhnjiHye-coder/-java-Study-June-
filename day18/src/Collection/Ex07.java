package Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Ex07 {
	public static void main(String[] args) {
		
		Random ran = new Random();
		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		// 1 ~ 45사이의 중복 없는 숫자를 6개 뽑아서 오름차순으로
		// 정렬한 후 한 줄에 출력해라
		// 중복없는 숫자를 뽀ㅃ아서 리스트에 담아서 출력해야 한다
		
		while(set.size() != 6) { // 6이 아닐때까지 이기 때문에 !=를 해줘야 한다 / ==라면 6일떄 반복을 하게 된다
			// 중복없는 수이기 때문에 set에 넣어야 중복없이 값이 들어간다
			set.add(ran.nextInt(45) + 1);
		}
		System.out.println(set);
		
		// 이후 set에 있는 값을  list에 넣어 정렬한다
		// set은 순서가 없기 떄문에 정렬이 불가능하다
		for(Integer i : set) {
			list.add(i);
		}
		list.sort(null);
		System.out.println(list);
		
		// 선생님 코드
		while(true) {
			int num = ran.nextInt(45) + 1;
			System.out.println("num : " + num);
			set.add(num);
			if(set.size() == 6) {
				break;
			}
		}
		System.out.println("set : " + set);
		
		// 향상된 for문 사용
		for(int num : set) {
			list.add(num);
		}
		System.out.println("list : " + list);
		
		// forEach : 각 num에 조건에 맞는 num을 출력
//		set.forEach(num -> list.add(num));
		
		// 생성자 매개변수 전달하기
		list = new ArrayList<Integer>(set);
		
		list.sort(null);
		// java.lang.Integer 클래스는 Comparable한 클래스이다
		
		System.out.println();
		// 중복수를 못 잡기 떄문에 for을 사용하면 함정에 빠질 수 있다
		// 반복횟루를 6번으로 설정하면, 중복이 발생했을 경우 결과 개수가 부족하다
//		for(int i = 0; i < 6; i++) {
//		int num = ran.nextInt(45) + 1;
//		System.out.println("num : " + num);
//		set.add(num);
//	}
	
	}
}
