package Collection;

import java.util.HashMap;
import java.util.HashSet;

class Solution{
	/*
	 	 연구실에 있는 총 N마리의 폰켓몬 중에서 N/2마리를 가져도 좋다
	 	 최대한 많은 종류의폰켓몬을 포함하여 N/2마리를 선택해야 한다
	 	 
	 	 N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법에서
	 	 폰켓몬 종류번호의 개수 return
	 */
	
	public int solution(int[] nums) {
		int answer = 0;
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int num : nums) {
			set.add(num); // 맵에 들어온 배열을 넣고
		}
		
		// 전체 마리 수의 절반만 가져갈 수 있다
		int n = nums.length / 2;	// 배열 길이의 중간을 n에 담는다
		
		// 중복이 없기 떄문에 마릿수가 아니라 종류만 체크
		// map에서 value의 역할이 없어서 set으로 바꿔서 작성함(한가지의 값만 다루는 set를 사용)
		int m = set.size();		// nums의 맵 값이 담긴 set의 사이즈를 m에 담고
		
		answer = n > m ? m : n;	// 배열 길이의 중간 사이즈가 set의 사이즈보다 크면
		// set의 사이즈가 answer에 담기고, 아니면 n이 담긴 후 반환된다
		
		// 2번쨰 방법
//		HashMap<String, Integer> map = new HashMap<>();
//		
//		for(int num : nums1) {
//			map.put(num + "번 폰켓몬", map.getOrDefault(num + "번 폰켓몬", 0) + 1);
//		}
//		System.out.println(map);
//		
//		int u = nums1.length / 2;
//		int y = map.size();
//		
//		answer = u > y ? u : y;
		
		return answer;
	}
}

public class Programmers1845 {
	public static void main(String[] args) {
		
		// 1845번 폰켓몬
		
		Solution s =  new Solution();
		
		int[] num1 = {3,1,2,3};
		int[] num2 = {3, 3, 3, 3, 2, 4};
		int[] num3 = {3, 3, 3, 2, 2, 2};
		
		int ret1 = 2;
		int ret2 = 3;
		int ret3 = 2;
		
		System.out.println("test1 : " + (s.solution(num1) == ret1));
		System.out.println("test2 : " + (s.solution(num2) == ret2));
		System.out.println("test3 : " + (s.solution(num3) == ret3));
		
		
	}
}
