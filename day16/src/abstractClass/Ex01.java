package abstractClass;

class Normal{
	public void test1() {
		System.out.println("test1");
	}
}


abstract class Abstract{
	public void test2() {
		System.out.println("test2");
	}
	// abstract가 추상메서드 표시이다
	// 추상메서드는 바디(함수내용)을 지정할 수 없습니다
	// 추상메서드는 test3는 오직 추상클래스 내부에서만 정의될 수 있습니다
	public abstract void test3();
	// 이렇게 해주면 추상메서드의 형식을 사용할 수 있게 되는 것이다
	// 편의를 위한 방법이니 익혀둬야 한다
}

class Sub extends Abstract {
	// 추상 클래스를 상속받은 클래스 Sub
	// The type Sub must implement the inherited abstract method Abstract.test3()
	// 자료형 Sub는 상속받은 추상메서드 test3() 상속받은 추상메서드를 반드시 구현해야 한다
	// 상속을 받았는데 그 안에 추상메서드가 있다면 반드시 구현해야 한다
	

	@Override
	public void test3() {
		System.out.println("test3");
	}	
	
}

public class Ex01 {
	public static void main(String[] args) {
		// 오버라이딩은 객체의 재정의이다
		
		Normal ob1 = new Normal();
		ob1.test1();
		
		// Cannot instantiate the type Abstract
		// 추상 클래스는 객체화 할 수 없다
//		Abstract ob2 = new Abstract() { 추상클래스 오류라고 뜬다
		// 추상 클래스인 것을 사용할 수 없기 때문에 더욱 구체적인 객체를 구현하고 출력해야 함
		
		Sub ob3 = new Sub();
		ob3.test2();
		ob3.test3();
		
		// 추상화는 개념은 존재하지만 육안으로 볼 수 없고 보여줄 수 없다
		// 언니를 사랑하지만 그 사랑을 보여줄 수 없듯
		// 그 개념 그 관념이 어떤 사물, 어떤 것에 투형되어 나타낼 수는 있다
		// 행위로 보여주거나 선물을 준다거나 머리를 쓰다듬는 등의 행위로 그 사랑을
		// 표현할 수는 있지만 이런 것들을 안하고 육안으로 바로 보여줄 수 없는 것이
		// 추상화이다
		// 그리고 클래스를 만든다고 한다면 동물이라는 추상화에 움직이는 방법,
		// 먹는 행동 등 동물이라는 클래스에 추상화메서드를 하나 정의해서
		// 토끼라는 동물에 추상메소드를 재정의하여 먹는 방법을 적고
		// 말일때는 또 다른 방법을 추상메소드로 적고 하면서 각 호출할때 그에 맞는
		// 추상메소드가 호출 될 수 있도록 하는 것이 방법이다
		
		Abstract ob4 = new Sub();	// 슈퍼클래스 ob4 = new 서브클래스();
	//    동물			       강아지
		ob4.test3();
		// test3의 내용만 구체화하여 결정한다면 객체를 생성할 수 있다
		Abstract ob5 = new Abstract() {
			// 객체를 생성할 때 안에 내용을 직접 적어준다
			// ob5는 Abstract의 내용을 상속받은 후 test3()의 내용을 구현한 이름없는 클래스
			// 미구현 메서드의 내용을 만들기위해 클래스를 새로 작성하는 것이 번거로울 수 있다
			// 즉성에서 클래스 상속 + 미구현 메소드 내용 구현을 수행하면서 객체를 생성하는 문법
			// Anonymous Inner Type : 익명 내부 클래스
			
			// 상속은 받았는데 이름이 별도로 옶눈 곳울 악명클래스라고 한다		
			@Override
			public void test3() {
				System.out.println("즉성에서 작성한 test3");
			}
		};
		ob5.test3();
		// 오버라이딩은 물려받은 내용을 덮어쓰는 것이다
										
	}
}
