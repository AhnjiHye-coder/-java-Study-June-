package day21;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Handler handler = new Handler();
		handler.load();	// 틀정 파일 이름의 데이터를 리스트에 불러오기
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		while(true) {
			System.out.println("\t메뉴를 선택해주세요");
			System.out.println("1. 추가 ");
			System.out.println("2. 전체 목록 ");
			System.out.println("3. 검색 ");
			System.out.println("4. 삭제 ");
			System.out.println("0. 종료 ");
			System.out.print("선택 >>> ");
			
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				System.out.print("이름 : ");
				String name = sc.nextLine();
				
				System.out.print("나이 : ");
				int age = Integer.parseInt(sc.nextLine());
				
				System.out.print("번호 : ");
				String pnum = sc.nextLine();
				
				result = handler.save(name,age,pnum);
				System.out.println(result != 0 ? "추가 성공" : "추가 실패");				
				break;
				
			case 2:
				
				handler.selectAll();
				break;
				
			case 3:
				
				System.out.print("검색할 키워드 :" );
				handler.search(sc.nextLine());
				break;
				
			case 4:
				
				System.out.print("삭제할 번호 : ");
				// 삭제할 번호를 담는 이유는 성공,실패 여부를 출력해야 하기 때문에 바로 받지 않고
				// result에 넣는 것이다
				result = handler.delete(sc.nextLine());
				System.out.println(result != 0 ? "삭제 성공" : "삭제 실패");
				break;
				
			case 0:
				sc.close();
				System.out.println("프로그램 종료");
				return;
				
				
			default :
				System.out.println("잘못 입력 하셨습니다");
				break;
				
			}
		}
//		handler.save();
		
	}
}
