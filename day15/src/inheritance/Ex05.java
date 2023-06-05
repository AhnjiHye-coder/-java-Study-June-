package inheritance;

class Calc { // 슈퍼,부모,상위 클래스라고 한다
	protected int add(int n1, int n2) {
		return n1 + n2;
	}
}

class Calc2 extends Calc{	// 서브, 자식, 하위 클래스
	/*
		Cannot reduce the visibility of the inherited method from Calc
	 	1) 상속받은 메소드의 접근 제한 범위를 더 줄일 수 없다(넓히기는 가능함)
	 	2) 상속받은 메소드의 반환형과 일치해야 한다, 이름도 틀리면 안되고 매개변수를 더 넣어도 안되고
	 	       무언가를 줄여도 안되고 무조건 똑같이 입력해야 한다
	 	3) 상속받은 메소드의 이름과 매개변수 유형 및 개수가 정확하게 일치해야 한다
	 	오버로딩 : 똑같은 이름으로 매개변수만 다르게 한다(이름은 같지만 매개변수 자료형과 개수가 다른 형태)
		오버라이딩 : 올라탄다와 덮어쓴다는 의미로 기존에 있는 것을 그대로 덮어쓰는 형태를 가진다
		이름이 하나이고 내용이 바뀌면 여러개가 아니라 하나의 이름으로 계속 업데이트되는 느낌이다
		4) 슈퍼클래스로 참조해도 메소드를 호출하면 서브 클래스에서 정의한대로 실행된다
	 */
	
	@Override
	public int add(int n1, int n2) {
		System.out.printf("%d + %d = %d\n",n1, n2, n1+n2 );
		return n1 + n2;
	}
	
	
}
public class Ex05 {
	public static void main(String[] args) {
		
		// 슈퍼클래스 객체
		Calc ob1 = new Calc();
		
		// 서브클래스 객체
		Calc2 ob2 = new Calc2();
		
		int n1 = ob1.add(10, 20);
		int n2 = ob2.add(12, 23);
		
		// 식이 출력되는 것은 서브클래스의 함수이다
		// 상속에도 규칙이 있는데 분류상 포함관계가 있어야 한다
		// 사람이라고 가정해본다면 사람이라는 것에 더욱 상세하게
		// 표현하기 위해서 다른 사람의 클래스를 상속받아서 사용한다면
		// (학생 -> 사람) (사람 -> 학생) 둘다 가능한 상태는 상속가능
		// 하지만 (자동차 -> 타이어) (타이어 -> 자동차)는 불가능하다
		// 이런 포함관계의 규칙을 잘 생각하며 상속을 해야 한다
		
		System.out.println("n1 : " + n1);
		System.out.println("n2 : " + n2);
		
		// 서브 클래스의 객체는 슈퍼클래스 타입이다
		// 학생은 사람이다, 고양이는 동물이다, 강아지는 동물이다
		// ob2는 calc이다
		//  Calc2는 Calc이다
		
		Calc test = ob2; 	// test자료형은 Clac
		test.add(100, 200);	// add의 실행내용은 Calc2(서브)를 따라간다
	}
}
