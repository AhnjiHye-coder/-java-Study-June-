package product;

import java.util.Scanner;

// 다른 클래스에서 푸드로 만들어진 것들을 활용하여 메뉴판 만들기 
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 가져올 함수를 가진 클래스
		Handler  handler = new Handler();
		Product[] arr = null;
		Product tmp = null;
		
		// main에서 사용할 필드
		String name;	// 상품이름
//		int pricer;		// 금액
//		String industr;	// 재조국가
//		String food;	// 유통기한
		int menu;		// 메뉴
		int orw;		// 추가 여부
		
		
		while(true) {
			System.out.println("-----메뉴 선택-----");
			System.out.println("1. 전체 메뉴");
			System.out.println("2. 추가");
			System.out.println("3. 삭제");
			System.out.println("4. 검색");
			System.out.println("5. 정렬");
			System.out.println("0. 종료");
			System.out.print("선택 >> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:		// 전체 메뉴 출력
				arr = handler.seletAll();	//handler클래스에 product배열이 담겨있다 그리고 전체 배열을 출력하는 메서드도 있다 
				for(Product p : arr) {		// 배열 전체를 p에 담고
					if(p != null) {			// 배열에서 null이면 출력 안하고 null아닌 정보가 있다면
						System.out.println(p);	// 출력해라
					}
				}
				break;
				
			case 2:		// 식품,가공품 구별해서 추가하기
				System.out.println("추가 할 제품 선택");
				System.out.print("1. 식품 | 2. 공산품 :");
				menu = Integer.parseInt(sc.nextLine());
				// 각 선택한 것에 대해 입력을 받는 메서드 먼저
				// 그리고 입력받은 것을 배열에 추가하는 메서드
				// sc를 매개변수로 넣어줘야 입력받은 것을 받아올 수 있다
				if(menu == 1) 		tmp = conFood(sc);
				else if(menu == 2) 	tmp = conIndustr(sc);
				else				tmp = null;
				// 선택했다면 배열에 추가할 차례
				orw = handler.insert(tmp);
				System.out.println(orw != 0 ? "추가 성공" : "추가 실패");
				break;
				
			case 3:		// 내 입력어에 일치하는 문자 삭제
				System.out.print("삭제할 제품 입력 : ");
				name = sc.nextLine();
				
				orw = handler.delete(name);
				System.out.println("삭제된 개수 : " + orw);
				System.out.println(orw != 0 ? "삭제 성공" : "삭제 실패");				
				break;
				
			case 4:		// 내 입력에에 일치하는 문자 찾기(검색)
				System.out.print("검색 할 상품 : ");
				name = sc.nextLine();
				
				arr = handler.search(name);
				for(int i = 0; i < arr.length; i++) {
					Product p = arr[i];
					if(p != null) {
						System.out.println(p);
					}
				}
				break;
				
			case 5:		// 오름차순으로 정렬
				System.out.println("오름차순으로 정렬되었습니다");
				arr = handler.sort(); // 가독성을 위해서 배열에 담아준다
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] != null) {	// 빈공간에 없으면 정렬하고
						System.out.println(arr[i]);	// 출력해라
					}
				}
				
				break;
				
			case 0:
				sc.close();
				System.out.println("프로그램 종료");
				return;
				
			default:
				System.out.println("메뉴를 잘못 선택했습니다");
			}
			System.out.println();		
		}
	}

	private static Product conIndustr(Scanner sc) {
		String name;
		int pricer;
		String industr;
		
		System.out.print("식품 이름 : ");
		name = sc.nextLine();
		
		System.out.print("금   액 :");
		pricer = Integer.parseInt(sc.nextLine());
		
		System.out.print("제조 국가 : ");
		industr = sc.nextLine();
		
		IndustrialProduct indu = new IndustrialProduct(name, pricer, industr);
		
		return indu;
	}

	private static Product conFood(Scanner sc) {
		String name;
		int pricer;
		String food;
		System.out.print("식품 이름 : ");
		name = sc.nextLine();
		
		System.out.print("금   액 :");
		pricer = Integer.parseInt(sc.nextLine());
		
		System.out.print("유통 기한 : ");
		food = sc.nextLine();
		
		Food fod = new Food(name, pricer, food);
		
		return fod;
	}
}














