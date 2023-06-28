package 안지혜1B;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Handler handler = new Handler();
		Student[] arr = null;	// 메서드에서 넘어온 배열 담는 공간
		Student tmp = null;		// 메서드에서 넘어온 값을 담는 공간
		
		// main에서 사용할 변수
		int menu;
		int row;
		String name = null;
		
		// 더미 데이터
		handler.Addstudent(new Common("희동이",60,85,97));
		handler.Addstudent(new Common("둘리",79,80,65));
//		handler.Addstudent(new Common("또치",67,98,94));
//		handler.Addstudent(new Common("마이콜",96,84,87));
//		handler.Addstudent(new Second("도우너",92,78,97,84));
		handler.Addstudent(new Second("짱구",93,87,77,71));
		handler.Addstudent(new Second("철수",88,79,98,62));
		handler.Addstudent(new Second("맹구",65,84,87,74));
//		handler.Addstudent(new Second("훈이",90,89,95,97));
//		handler.Addstudent(new Second("유리",49,87,90,98));
		
		
		while(true) {
			System.out.println("\t학생관리프로그램 (응시자 : 안 지 혜)");
			System.out.println("1. 학생추가");
			System.out.println("2. 전체목록");
			System.out.println("3. 학생검색");
			System.out.println("4. 학생삭제");
			System.out.println("5. 평균내림차순 출력");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 >>> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:	// 학생 추가
				System.out.println("\t학생 추가");
				System.out.print("(1. 일반 | 2. 제2외국어) : ");
				menu = Integer.parseInt(sc.nextLine());
				
				if(menu == 1 ) 		tmp = Commonstudent(sc); // 일반일때
				else if(menu == 2) 	tmp = Secondstudent(sc); // 제2외국어일때
				else				tmp = null;					
			
				row = handler.Addstudent(tmp);
				System.out.println(row != 0 ? "\n\t학생 데이터를 성공적으로 추가했습니다" : "\n\t학생 정보를 다시 입력하세요");
				break;
				
			case 2: // 전체 목록
				System.out.println("\t전체 회원 정보");
				arr = handler.Arrstudent();
				
				for(int i = 0; i < arr.length; i++) {
				      if(arr[i] != null) {
				    	  System.out.println("번호 : "+i);
				         System.out.println(arr[i].toString2());
				      }
				   }
				break;
				
			case 3: // 검색
				System.out.println("\t이름으로 학생을 검색합니다");
				System.out.print("검색할 이름 입력 : ");
				name = sc.nextLine();
				
				arr = handler.Search(name);
				
				for(int i = 0; i < arr.length; i++) {
					Student s = arr[i];
					if( s != null) {
						System.out.println(s);
					}
				}
				break;
				
			case 4: // 삭제
				System.out.print("삭제할 학생의 이름 입력 : ");
				name = sc.nextLine();
				
				arr = handler.Search(name);
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] != null) {
						System.out.println(arr[i]);
						System.out.print("정말 삭제하시겠습니까? (y/n) :");
						String n = sc.nextLine();
						
						if(n.equals("n") || n.equals("N")) {		
							System.out.println("지정한 학생 정보 삭제를 중단합니다");	
						}
						else if(n.equals("y") || n.equals("Y")){ 
							row = handler.delete(name);			
							System.out.println("지정한 학생의 정보를 삭제합니다"); 
						}
						else {			
							System.out.println("잘못 입력하셨습니다");	
						}
					}
					else {		
						System.out.println("일치하는 학생정보가 없습니다");	
					}
				}
					
				break;
				
			case 5: // 정렬
				System.out.println("\t내림차순대로 정렬하였습니다");
				arr = handler.sort();
				
				for(int i = 0; i < arr.length; i++) {
				      if(arr[i] != null) {
				         System.out.print((i+1) + ". " + arr[i].toString2());
				      }
				   }
				break;
				
			case 0:
				sc.close();
				System.err.println("프로그램을 종료합니다");
				return;
				
			default:	
				System.out.println("번호를 다시 입력하세요");
			}
			System.out.println();
		}
	}

	// 제2외국어
	private static Student Secondstudent(Scanner sc) {
		
		String name;
		int c, java,spring,english;
		
		System.out.print("이름을 입력하세요 : ");
		name = sc.nextLine();
		
		System.out.print("C언어 점수 : ");
		c = Integer.parseInt(sc.nextLine());
		
		System.out.print("java 점수 입력 : ");
		java = Integer.parseInt(sc.nextLine());
		
		System.out.print("spring 점수 입력 : ");
		spring = Integer.parseInt(sc.nextLine());
		
		System.out.print("제 2외국어 점수 입력 : ");
		english = Integer.parseInt(sc.nextLine());
	
		Second seco = new Second(name, c, java, spring,english);
		
		return seco;
	}

	// 일반
	private static Student Commonstudent(Scanner sc) {
		
		String name;
		int c, java,spring;
		
		System.out.print("이름을 입력하세요 : ");
		name = sc.nextLine();
		
		System.out.print("C언어 점수 : ");
		c = Integer.parseInt(sc.nextLine());
		
		System.out.print("java 점수 : ");
		java = Integer.parseInt(sc.nextLine());
		
		System.out.print("spring 점수 : ");
		spring = Integer.parseInt(sc.nextLine());
	
		Common comm = new Common(name, c, java, spring);
		
		return comm;
	}
}
