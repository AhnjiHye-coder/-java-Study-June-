package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quiz {
	public static void main(String[] args) throws Exception {
		// 매월 2주, 4주 일요일은 대형마트 휴무일이다
		// 2주,4주를 출력하고 달 마다 끊어서 출력해라
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");

		// 먼저 날짜 범위 구성 (2023년은 대형마트 휴무일 언제인지 출력하기)
		Date d1 = sdf1.parse("2023-01-01");
		Date d2 = sdf1.parse("2023-12-31");
		
		int month = 1;
		int count = 0;
		int sum = 0;
		
		
		for(long i = d1.getTime(); i <= d2.getTime(); i+= 1000 * 60 * 60 * 24) {
			String s = sdf2.format(new Date(i)); // 범위를 형식대로 s에 담기
			
			// 만약 s가 월요일을 포함하면 출력
			// contains : 포함하면
			// 대형마트 휴무일인 일요일을 출력해야 하는 것이기 때문에
			// 일요일일때 라는 조건 안에 또 다른 조건을 넣어야 한다
			if(s.contains("일")) {
//				System.out.println(s);
				// 맨 처음 month는 1이다 . 즉 1월을 의미하며,
				// 밑 if코드의 내용은 1월과 모든 date가 저장된 s의 값이 현재 일치하는가? 이다
				// 일치 하지 않으면 한칸 밑으로 , 일치하면 현재 월의 2,4주 일요일을 출력하고
				// 그 월을 month에 저장하여 다시 if문에서 동일한가?를 확인하며 코드 진행.
				if(month != Integer.parseInt(s.substring(6,8))) {
					System.out.println(); // 다르면 한칸 띄우기
					count = 1;	// 카운터를 1로 만들어주어, 일요일이고 같은 달이지만,
					// 2,4주만 출력해야 하기 때문에 구분할 수 있는 변수를 따로 준비한다.
				}
					if(count == 2 || count == 4) {
						System.out.printf("%s (%d)\n", s, count);
						sum++;
					}
					// 만약 일요일인데 1,3,5주라면
					count++;	// 카운터를 올려 2,4주가 되도록 하고
					// 현재 월에서 움직일 수 있도록 해당 월을 저장한다
					month = Integer.parseInt(s.substring(6,8));	
				}
			}
			// 각 조건에 맞춰서 2,4에 휴무일을 출력한다
			System.out.printf("\n2023년 대형마트 휴무일은  %d일 입니다", sum);
		
	} 

}
