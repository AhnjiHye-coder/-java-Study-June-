package Object;

import java.util.Scanner;

class Test {}

class Test2 extends Object {
	// extends를 지정하지 않으면, 자동으로 Object 클래스를 상속받는다
	// 상속받은 메서드를 오버라이딩 하기 위해서 선택해야하는 메뉴 호출
	// source - override/implement methods
	
	// 자신과 대상의 일치여부를 비교하여 boolean으로 반환
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	// 객체를 출력하기 위해 문자열로 변환하여 반환
	@Override
	public String toString() {
		// 모든 자바의 객체는 .toString객체를 가지고 있고
		// (문자열로 변환)
		return "Test2";
	}
	
	
}

public class Ex08 {
	public static void main(String[] args) {
		
		// Object : 자바의 모든 클래스의 최상위 슈퍼클래스
		Test ob1 = new Test();
		System.out.println(ob1.getClass().getSimpleName());
		
		Test2 ob2 = new Test2();
		System.out.println(ob2.getClass().getSimpleName());
		
		System.out.println("ob1 : " + ob1);
		System.out.println("ob1 : " + ob2);
		System.out.println("ob1 : " + ob1.toString());
		System.out.println("ob1 : " + ob2.toString());
		
		// 형태(타입)에 상관없이 어떤 객체를 저장하기 위해서
		// Object클래스를 사용하기도 한다
		Integer num = new Integer(100);
		String str = new String("Hello\nWorld");
		Scanner sc = new Scanner(str);
		
		// 람다식 객체
		Runnable run = () -> System.out.println("RUN");
		
		// 배열
		double[] a = {1.2, 5.3};
		
		// 래퍼런스 타입이면 모두 오브젝트타입으로 저장할 수 있다
		// 모든 클래스가 Object를 상속받는다
		Object[] arr = {num, str, sc, run, a};
		// 장점 : 자료형에 상관없이 어떤 객채든 저장할 수 있다
		// 단점 : 다른 곳에서 꺼내서 사용하려면 다운 캐스팅을 해야 정상적으로 사용가능
		// 박스에 묶어서 트럭에 실어서 이동할 수 있다
		// 하지만 물건 하나하나를 보려면 박스를 열어야 하듯 Object에 담는 것은
		// 가능하지만 하나하나 살피지는 못한다
		
		System.out.println("sc == arr[2]" + (sc == arr[2]));
		System.out.println("str == arr[2]" + (str == arr[2]));
		
		// Hello하고 줄바꿈이 되기 때문에 Hello만 출력
		System.out.println(sc.nextLine());
		
		// 다운 캐스팅이 없으면 호출할 수 없다
		// 트럭에서 바로 꺼내볼 수는 없다, 즉, Object가 되어있다면
		// 바로 꺼내볼 수 없고 그 클래스의 자료형으로 다운캐스팅을 진행한 후
		// 꺼내 볼 수 있게 된다
//		System.out.println(arr[2].nextLine());
		
		// 스캐너로 다운캐스팅
		System.out.println(((Scanner)arr[2]).nextLine());
		
		// Object의 메서드를 오버라딩 하는 내용 -> Ex09
	}
}










