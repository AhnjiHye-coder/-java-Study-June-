package 안지혜A1;
import java.util.Scanner;

//사용자에게 보여지는 메뉴
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	// 입력
		Handler handler = new Handler();		// main에서 기능을 참조하기 위해 생성
		Member[] arr = null;					// 가독성을 위한 Member 참조 클래스
		Member tmp = null;						// 구매자,판매자 판별

		
		// main에서 받을 정보
		String id = null;	// 아이디
		int row = 0;		// 탈퇴/가입 판단여부
		int menu = 0;		// 메뉴값 받을 변수
		
		handler.addition(new Customer("라", "ㅇㄴㅇㄹㄴ", "헤이", "부산"));
		handler.addition(new Customer("다", "ㅇㄴㅇㄹㄴ", "헤이", "부산"));
		handler.addition(new Customer("마", "ㅇㄴㅇㄹㄴ", "헤이", "부산"));
		handler.addition(new Customer("가", "ㅇㄴㅇㄹㄴ", "헤이", "부산"));
		handler.addition(new Customer("나", "ㅇㄴㅇㄹㄴ", "헤이", "부산"));
		
		
		
		while(true) {
			System.out.println("\t쇼핑몰 회원관리 프로그램 (응시자 : 안 지 혜)");
			System.out.println("1. 회원 가입");
			System.out.println("2. 전체 목록");
			System.out.println("3. 회원 검색");
			System.out.println("4. 회원 탈퇴");
			System.out.println("5. 회원 정렬");			
			System.out.println("0. 종료");
			System.out.print("선택 >> ");
			menu = Integer.parseInt(sc.nextLine());
			
			// 선택한 메뉴에 따라서 해당 목록으로 이동합니다
			switch(menu) {
			case 1:	// 회원 가입 기능
				System.out.println("\t회원 가입");
				System.out.print("회원 유형을 선택하세요(1. 구매자 | 2. 판매자) : ");
				menu = Integer.parseInt(sc.nextLine());
				
				if(menu == 1)		tmp = Customerjoin(sc);
				else if(menu == 2) 	tmp = Sellerjoin(sc);
				else				tmp = null;
				
				row = handler.addition(tmp);
				System.out.println(row != 0 ? "\n\t회원가입이 정상적으로 처리되었습니다" : "\n\t회원가입이 실패하였습니다. 다시 시도해주세요");
				break;
				
			case 2:	// 전체 목록 확인
				System.out.println("\t전체 회원 정보");
				arr = handler.MemberAll();
				
				for(Member m : arr) {
					if(m != null) {
						System.out.println(m);						
					}
				}
				break;
				
			case 3:	// 회원 정보 검색
				System.out.println("\tID로 회원을 검색합니다");
				System.out.print("검색할 ID 입력 : ");
				id = sc.nextLine();
				
				tmp = handler.idsearch(id);    			// 그 arr의 id를 m에 넣고
				if(tmp != null) {						// 내가 입력한 id가 null이 아니면 
					System.out.println(tmp);			// 출력
					}
				else {
					System.out.println("\t" + id + " : 회원정보를 찾을 수 없습니다");	// 출력																				
					}
				break;
				
			case 4:	// 회원 탈퇴 기능
				System.out.println("\tID로 회원을 검색합니다");
				System.out.print("검색할 ID 입력 : ");
				String keyeword = sc.nextLine();
				
				tmp = handler.idsearch(keyeword);
				System.out.println(tmp != null ? tmp : "회원정보가 없습니다");
				
				
				System.out.print("정말 탈퇴하시겠습니까? (y/n) :");
				id = sc.nextLine();
				
				if(id.equals("n") || id.equals("N")) {
					System.out.println("회원탈퇴를 취소하였습니다");					
				}
				else if(id.equals("y") || id.equals("Y")){
					row = handler.delete(keyeword);
					System.out.println("정상적으로 탈퇴되었습니다");
				}
				else {
					System.out.println("잘못 입력하셨습니다");
				}
				break;
				
			case 5:	// 정렬 기능
				arr = handler.sort();
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] != null) {
						System.out.println(arr[i]);
						}
				}
				
				break;
				
			case 0:
				sc.close();
				System.out.println("프로그램이 정상적으로 종료되었습니다");
				return;
				
			default:
				System.err.println("번호를 다시 입력 해주세요");
			}
			System.out.println();
			
		}
		
		
	}
	
	

	private static Member Sellerjoin(Scanner sc) {
		
		String name,storeName,id,password;
		
		System.out.print("ID를 입력하세요 : ");
		id = sc.nextLine();
		
		System.out.print("Password를 입력하세요 : ");
		password = sc.nextLine();
		
		System.out.print("이름을 입력하세요 : ");
		name = sc.nextLine();
		
		System.out.print("가게이름을 입력하세요 : ");
		storeName = sc.nextLine();
		
		Seller seller = new Seller(id, password, name, storeName);
		
		return seller;
	}

	// 구매자
	private static Member Customerjoin(Scanner sc) {
	
		String name,address,id,password;
		
		System.out.print("ID를 입력하세요 : ");
		id = sc.nextLine();
		
		System.out.print("Password를 입력하세요 : ");
		password = sc.nextLine();
		
		System.out.print("이름을 입력하세요 : ");
		name = sc.nextLine();
		
		System.out.print("배송주소를 입력하세요 : ");
		address = sc.nextLine();
		
		Customer cust = new Customer(id, password, name, address);
		
		return cust;
	}
}
