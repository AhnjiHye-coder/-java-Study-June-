package Collection;

import java.util.HashSet;

public class Ex06 {
	public static void main(String[] args) {
		
		// Set : 순번이 없고, 값의 중복을 허용하지 않는다
		
		HashSet<Integer> set = new HashSet<>();
		// Generic Type에는 primitive 타입을 지정할 수 없다
		// 대신 wrapper class를 이용하여 지정할 수 있다
		
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(20);
		
		System.out.println(set);
		
		// 순번이 없어서, 특정값을 지정해서 불러올 수 없다
		// System.out.println(set.get(0));
		
		for(Integer num : set) {
			System.out.println(num);
		}
		System.out.println();
		
		// 중복이 없어서 data는 4개를 넣었지만 들어간 값은 3개인 것이다
		System.out.println("set.size() : " + set.size());
		
		// 리스트는 칸이 정해져있는 상태이다
		// set의 경우는 순서는 없어도 data가 분명이 모여있고
		// 순서대로 꺼낼 수는 없어도 잡히는걸 꺼낼 수는 있다
		// 또 구조상 중복이 없도록 만들어 놓았다
		
		
		
		
		
		
		
	}
}
