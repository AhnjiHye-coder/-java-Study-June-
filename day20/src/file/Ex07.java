package file;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import java.util.Iterator;

public class Ex07 {
	public static void main(String[] args) throws Exception {
		
		// 1) 한국배우목록.txt 파일을 불러 올 수 있도록 파일 객체를 생성하세요
		// 파일 객체를 바로 출력해보세요
		
		File f = new File("한국배우목록.txt");
		System.out.println(f);
		System.out.println(f.toString());  // . 앞에 있는 대상의 것을 문자열로 보여준다
		System.out.println(f.getName());	// 파일이름
		System.out.println(f.getAbsolutePath());	// 절대 경로
		System.out.println(f.length());				// 용량,크기
		
		// 파일 이름을 이용하여 이름이 3글자인 사람만 대상으로 하고
		// 성씨별로 인원수가 몇명인지 확인할 수 있는 HasMap을 만들자
		
		HashMap<String, Integer> map = new HashMap<>();
		Scanner sc = new Scanner(f);
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.length() == 3) { // line의 길이가 3인 것만 if로 진입
				String key = line.substring(0,1);	// 그리고 index 0~1만 자른 후 비교
				// key값과 value의 값이 동일하면 0을 반환하는 것은 맞다
				// 하지만 그렇게 되면 동일한 값이 나올때마다 0만 반환되기 때문에 개수를 측정할 수 없어 +1을 해준는 것
				// 그리고 개수를 세는 형식은 같은 값이 나올때마다 그에 일치하는 key에 +1을 해주고 +1을 해주면서
				// 이전에 있던 value를 덮어씌운다. 따라서 숫자를 덮어 씌운다고 생각하면된다
				// 같은 key를 잘 세다가 다른 key가 오면 똑같이 0을 반환하면서 +1이 되어 개수1개로 증가
				// 그러므로 문자는 key이고 개수가 올라가는 것은 value인 것이다
				map.put(key,map.getOrDefault(key, 0) + 1);
			}
		}
		sc.close();
		
		// entrySet() :key와 value의 값이 모두 필요할때 사용
		// keySet() : key의 값만 필요할때 사용한다
		// values : 반복문 없이 value의 값을 모두 가져온다
		for(String key : map.keySet()) { // 각 성씨들을 key에 담는다
//			System.out.println(key);
			int value = map.get(key);	 // map안에 key값 가져와서 value에 넣기
			System.out.printf("%s씨는 %d명\n",key, value);
			// key로는 value를 출력할 수 있지만 vlaue로는 key를 꺼낼 수 없다
		}
		
		
		// 3) 리스트에 넣어서 성씨 순, 인원수 순으로 정렬
		
		ArrayList<String> list = new ArrayList<>();
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) { // map에 key를 담은 it가 다음 문자가 있으면 실행
			// map을 list에 넣을 수 있도록 먼저 key, value를 구분한다
			// 빼서 넣어줘야 한다는걸 잊지말자
			String key = it.next(); // key문자를 key 변수에 넣고
			int value = map.get(key);	// 나이순 정렬을 위해 value도 int value에 넣는다
			list.add(key + "=" + value); // list에 옆 형식과 같이 넣는다
			
		}
		// 그리곤 이름 순으로 정렬을 해준다
		list.sort(null);
		
		// 정렬된 것을 출력한다
		list.forEach(s -> System.out.println(s));
		
		System.out.println();
		System.out.println("인원 순으로 정렬하여 출력!!");
		
		list.sort((a, b) -> {
			// "="을 시작으로 index 1의 자리를 비교하여 정렬한다
			int n1 = Integer.parseInt(a.split("=")[1]);
			int n2 = Integer.parseInt(b.split("=")[1]);
			//내림차순이 되게끔 n1(앞)n2(뒤)
			// n2에서 n1을 뺐을 떄, n1이 더 작으면 n2가 먼저 출력하면서 큰수에서 작은수로 내려가는 내림차순 구현
			return n2 - n1;		// 이 상태에서 음수가 나오면 n1이 앞으로 가고, 양수가 나오면 n2가 출력
		});
		list.forEach(s -> System.out.println(s));
	}
}
