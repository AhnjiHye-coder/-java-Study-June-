package static_final;

class Test2{
	/*
	 	final : 변경할 수 없다. 마지막 값이다
	 	지역변수에 사용가능, 처음 설정한 값을 이후 변경할 수 없다
	 	멤버필드에 사용가능,처음 설정한 값을 이후 변경할 수 없다
	 	메서드에 사용가능, 함수의 내용을 변경할 수 없다(오버라이딩 불가)
	 	클래스에 사용가능, 클래스 구성을 변경할 수 없다(상속불가) 	
	 */
	
	final int n3 = 10;
//	final int n4;
	// The blank final field n4 may not have been initialized
	// n4는 초기화가 되지 않은 값이라고 뜬다
	final int n4; // 생성자를 통해서 초기화해준다면 오류는 뜨지 않는다
	private final int n5 = 30;
	public static final String ACADEMY_NAME = "ITBANK";
	final int n6 = Integer.MAX_VALUE;	// 하나만 있는 값이고 바꿀 수 없는 상수
	// static = 정해져있는 것
	// final = 한번 정하면 값을 바꿀 수 없는 것
	// 여기서 private접근 제한자로 static final로 변수를 만든다면
	// 사용하지 않겠다는 의미와 같다
	// 변경을 할 수도 없고 다른 class에서 get메소드가 없다면 사용할 수도 없기 때문이다
	
	// n4를 위한 생성자
	// 생성자로 초기화하여 값을 정해준다
	// 하지만 한번 정한 값은 더 이상 바꿀 수 없다
	Test2 (int n4){
		this.n4 = n4;  // final멤퍼 필드는 생성자를 통한 초기화가 가능하다
	}
	
	// set는 외부로 부터 값을 받아서 대입하는 메소드이기때문에 이미 초기화 된 n5에는
	// 대입할 수 없다
	// 하지만 get은 된다(정해진 값을 다른 클래스로 내보내는 것)
	public int getN5() {
		return n5;
		
	}
	
}


public class Ex03 {
	public static void main(String[] args) {
		int n1 = 10;
		final int n2 = 20;
		
		System.out.println(n1);
		System.out.println(n2);
		
		n1 += 1;
		
//		n2 += 1; // final이기 때문에 값을 변경할 수 없다며 오류 발생
		// The final local variable n2 cannot be assigned.
		// It must be blank and not using a compound assignment
		
		System.out.println("학원 이름 : " + Test2.ACADEMY_NAME);
//		System.out.println("학원 이름 : " + Test2.n6);
		
		
	}
}
