package product;

import java.util.Arrays;

//전산처리 개념
public class Handler {
	
	// 메서드를 다루는 클래스에서는 참조객체로 상속클래스를 추가한다
	// 푸드 배열에 대해 메소드가 작동해야 하기 때문이다
	
	Product[] arr = new Product[10];
	
	// 전체 출력
	public Product[] seletAll() { // 배열 전체를 담아
		return arr;				  // 반환한다
	}

	// 추가
	public int insert(Product tmp) {
		int orw = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if( arr[i] == null) {
				arr[i] = tmp;
				orw = 1;
				break;
			}
		}
		return orw;
	}

	// 삭제
	public int delete(String name) {
		int orw = 0;
		
		for(int i = 0; i < arr.length; i++) {
			// 배열에서 null이 아닌 제품이 있고,
			// 배열의 name과 equals(a와b가 일치하면 true)name 일치하면
			if( arr[i] != null && arr[i].name.equals(name)) {
				arr[i] = null;
				orw++;
				
			}
		}
		return orw;
	}
	
	// 검색
	public Product[] search(String name) {
		Product[] ret = null;
		int length = 0;
		
		for(int i = 0; i < arr.length; i++) {
			Product p = arr[i];
			if(p != null && arr[i].name.contains(name)) {
				length++;
			}
		}
		
		ret = new Product[length];
		length = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null && arr[i].name.contains(name)) {
				ret[length++] = arr[i];
			}
		}
		
		return ret;
	}

	public Product[] sort() {
		Arrays.sort(arr,(a,b) -> (a != null &&  b != null) ? a.name.compareTo(b.name) : 0);
		
		return arr;
	}

	
	
}
