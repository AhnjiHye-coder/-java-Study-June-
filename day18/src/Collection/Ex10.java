package Collection;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Ex10 {
	public static void main(String[] args) {
		
		File f = new File("한국배우목록.tyt");
		Scanner sc = new Scanner(System.in);
		// 리스트에 문자를 담기 떄문에 String자료형으로 지정한다
		ArrayList<String> list = new ArrayList<>();
		while(sc.hasNextLine()) {
			list.add(sc.nextLine());
		}
		sc.close();
		
		System.out.println(list);
		
		// 메모 값을 name에 넣어주면서 비교한다
		// 내가 먼저 넣은 성은 0으로 시작하고 처음 만난 성이 아닌 다른 성을
		// 만나서 1로 증가된다
		HashMap<String, Integer> map = new HashMap<>();
		for(String name : list) {
			String familyName = name.substring(0,1);
			map.put(familyName, map.getOrDefault(familyName, 0) + 1);
		}
		
		ArrayList<String> list2 = new ArrayList<>();
		Set<String> keySet = map.keySet();
		
		for(String key : keySet) {
			int value = map.get(key);
			list2.add(key + ":" + value); // 공백문자가 있으면 정수로 못 바꾼다
		}
		System.out.println();
		
		list2.sort((a,b) -> {
			int aCnt = Integer.parseInt(a.split(":")[1]);
			int bCnt = Integer.parseInt(b.split(":")[1]);
			return bCnt - aCnt;
		});
		list.forEach(s -> System.out.printf("%s씨는 %s명입니다 \n", s.split(":")[0], s.split(":")[1]));
		// 파일의 내용을 차례대로 끌고와서 map에 담고
		// 성을 정수 값으로 넣고 처음 값이 들어가면 0으로 들어가고
		// 두번쨰 성을 만나면 그 성은 1부터 다시 시작하는 것을 반복하면서
		// 동일한 성의 개수를 파악할 수 있는 코드이다
		
		int total = 0;
		for(String s : list2) {
			int count = Integer.parseInt(s.split(":")[1]);
			System.out.printf("%S씨는 %s명입니다", s.split(":")[0], count);
			total += count;
		}
		System.out.println("처음 불러온 파일에서의 데이터 개수 : " + list2);
		System.out.println("성씨로 분류한 인원의 총 합계 : " + total);
		System.out.println(list.size() == total);
		
	}
}
