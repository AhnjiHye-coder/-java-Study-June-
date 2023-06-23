package Collection;

import java.util.HashMap;

public class Ex11 {
	public static void main(String[] args) {
		
		// 1부터 1000사이의 정수 중에서
		// 3의 배수, 5의 배수, 7의 배수의 개수를 각각 구하세요
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i <= 1000; i++) {
			if(i % 3 == 0) {
				// map에 put함수로 3의 배수가 들어오면 +1을 반환하고
				// 없다면 0을 반환하여 증가되는 것이 없도록 설계한다
				// getOrDefault :두 가지의 인자를 넣는데 첫번째 인자는 key값으로
				// key값이 동일하면 vlaue에서 값을 주게 된다.
				// 여기 식에서 본다면 3의 배수일때 if조건으로 진입하게 된다
				// 그러므로 진입했을때 
				map.put("3의 배수", map.getOrDefault("3의 배수", 0) + 1);
			}
			if( i % 5 == 0) {
				map.put("5의 배수", map.getOrDefault("5의 배수", 0) + 1);
				
			}
			if( i % 7 == 0) {
				map.put("7의 배수", map.getOrDefault("7의 배수", 0) + 1);
			}
		}
		System.out.println(map);
		
		
	}
}
