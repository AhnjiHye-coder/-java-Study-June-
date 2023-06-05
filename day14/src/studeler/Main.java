package studeler;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Student st = new Student();
		Handler ha = new Handler();
		
		String key;		// case 3번 검색어 입력받기
		int menu = 0;	// 메뉴
		String name;	// 학생정보 이름 입력받는 함수
		int kor,eng,mat;	// 학생 점수 입력받는 변수
		Student tmp;		// 받은 학생 정보를 Student클래스의 
							// 매소드,생성자를 사용할 수 있도록하는 필드
		Student[] arr = null;
		int row; // 각 case에서 정보를 담는 역할
		
		while(true) {
			System.out.println("1. 전체 목록");
			System.out.println("2. 추가");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("0. 종료");
			System.out.print("선택 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				System.out.println("<목록보기>");
				
				// 메소드는 Handler클래스에 있지만 그 메소드의 
				// 자료형은 Student이기 때문에 arr의 자료형은
				// Student여야 하며, 배열이기 때문에 배열로 한다
				arr = ha.getArray();
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] != null) {
						arr[i].total();
					}
				}
				break;
				
				
			case 2:				
				System.out.println("학생 이름 : ");
				name = sc.nextLine();
				
				System.out.println("국, 영, 수 입력 : ");
				kor = sc.nextInt();
				eng = sc.nextInt();
				mat = sc.nextInt();
				
				tmp = new Student(name,kor,eng,mat);
				row = ha.add(tmp);
				// tmp로 바로 출력이 안되는 이유는 현재 클래스에서 자료형이 안맞기 때문이다
				// tmp는 Studlent이고 및 삼항연산은 int로 해야하기 때문이다
				System.out.println(row != 0 ? "추가 성공" : "추가 실패");
				break;
				
			case 3:
				System.out.print("이름으로 검색 : ");
				key = sc.nextLine();
				
				// arr은 Student이다
				// ha는 Handler이다
				// 메소드는 ha에 있지만 메소드 반환형태가Sudent이다
				// 그러므로 Student의 배열을 반환하기 때문에
				// arr은 Student의 배열 형태로 받아야 하는 것이다 
/*검색어 배열에 담고*/	arr = ha.search(key);			
/*길이만큼 반복하면서*/for(int i = 0; i < arr.length; i++) {
					arr[i].total(); // 배열에 검색어랑 일치하는 data더가 있다
				// 그 데이터를 total형식으로 출력
				}
				break;
				
			case 4:
				System.out.print("이름으로 삭제 : ");
				name = sc.nextLine();
				
				row = ha.puis(name);
				System.out.println(row != 0 ? "삭제 완료" : "삭제 실패");
				break;
				
			case 0:
				System.out.println("프로그램 종료");
				sc.close();
				return;
			}
			System.out.println();
			
		}
		
	}
}
