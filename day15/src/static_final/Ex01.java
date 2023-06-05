package static_final;

/*
 	static은 클래스에 소속되는 필드 및 메소드
 	클래스가 객체보다 먼저 메모리 로드된다
 	클래스가 로드되는 시점에서 static요소는 생성되어있다
 	클래스만 로드된 시점에서 아직 객체는 생성되지 않았다
 	따라서 static요소 non-static요소를 정상적으로 참조할 수 있는 보장이 없다
 	
 	static는 static를 참조하고
 	non-static은 non-static를 참조하는 것 처럼
 	같은 것 끼리 참조하는 것이 좋다
 	static는 non-static을 참조할 수 있지만
 	non-static은 static를 참조할 수 없다
 	(변수에 담는 다는 것으로 생각해본다면 non-static에
 	static를 담을 수 없지만 그 반대는 된다
 	이유는 static는 클래스가 만들어짐과 동시에 만들어지기 때문이다
 */

class Test1{
	int n1 = 10;
	static int n2 = 20;
	
	// Cannot make a static reference to the non-static field n1
	// 정적 참조를 할 수 없습니다
	// 여기는 스테틱을 붙이면 안된다
	// n1은 non-static이기때문에 static을 붙일 수 없다
	/*static*/void showN1(){
		System.out.println(n1);
	}
	
	static void showN2() {
		System.out.println(n2);
	}
	
}

public class Ex01 {
	public static void main(String[] args) {
		// static : 고정되어있다, 객체마다 서로 다른 값이 아니라, 클래스에 고정된 값
		// 개체에 접근하지 않아도 될떄 static을 붙여준다
		
//		System.out.println("Test1.n1 : " + Test1.n1);  // 불가능
		System.out.println("Test1.n2 : " + Test1.n2);
		
		Test1 ob = new Test1();
		System.out.println("ob.n1 : " + ob.n1);
		System.out.println("ob.n2 : " + ob.n2);
		// The static field Test1.n2 should be accessed in a static way
		// 서로 다른 객체들이 공유하는 값이 된다
		
		// static는 class와 같이 만들어진다
		// 책이라고 하면 사각형이라고 하는 것이 고정되어 생각나듯 이렇게 그때마다 다른것이 아닌
		// 공통된 부분,변하지 않는 부분을  static라고 한다
		// 체크카드로 비유해보자면 카드는 같은 크기,길이,사이즈가 동일해야 한다
		// 이렇게 서로 다른 객체라도 사이즈를 공유해야 하는 것을 static로 처리한다
		
		// non-static는 책은 책이지만 무슨 색깔, 금액, 각격 등 바뀔 수 있는 것을 의미한다
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
