package abstractClass;

// 운영체제/ 장치종류에 상관없이 PC주변 기기를 컴퓨터에 연결할 수 있는 표준 프로토콜
interface USB {
	// 꼽는다라는 것은 동일하기 때문에 USB에서 오버라이딩을 할 수 있는 메서드를 만든디
	void onClick();
}
// 옛날에 쓰던 저장장치
class FloopyDisk {
	
}

// PC에서 연결하는 저장장치
// 메모리도 USB방식
// 기존에 슈퍼클래스가 있어도 인터페이스는 관계없이 중복가능하다
class MemroyStick extends FloopyDisk implements USB {

	@Override
	public void onClick() {
		System.out.println("USB 메모리 연결됨. 탐색기 실행");
		
	}	
}

// PC에 연결하는 입력장치
// 키보드도 USB방식
class Keyboard implements USB {

	@Override
	public void onClick() {
		System.out.println("키보드 연결됨. 국가코드 및 언어 탐색 후 적용");
		
	}
	
}

// PC에 연결하는 출력장치
// 스피커도 USB방식
class Speaker implements USB {

	@Override
	public void onClick() {
		System.out.println("스피커 연결됨. 음성채널 설정 및 볼륨테스트");
		
	}
	
}

// 이전에 만들어 놓은 것을 모두 연결해줄 PC라는 객체 생성
class PC {
	// 모두 USB에 연결되어있으니 USB자료형을 매개변수로 받아서
	// 재정의한 오버라이딩 매개변수를 사용한다
	void connect(USB bevice) {
		bevice.onClick();
	}
}


public class Ex05 {
	public static void main(String[] args) {
		
		// 각 내부에 있는 오버라이딩 메서드를 사용하기 위해 참조객체 생성
		Speaker ob1 = new Speaker();
		MemroyStick ob2 = new MemroyStick();
		Keyboard ob3 = new Keyboard();
		
		PC pc = new PC();
		
		pc.connect(ob1);
		pc.connect(ob2);
		pc.connect(ob3);
		
		// 즉석에서 만듬
		USB mouse = () -> System.out.println("마우스연결됨");
		pc.connect(mouse);
		
		// 인터페이스의 추상메서드가 오직 하나만 있으면 "함수형 인터페이스"라고 한다
		// 함수형 인터페이는 자바8에서 추가된 람다식을 이용하여 객체를 생성할 수 있다
		// 익명 클래스와 유사하지만, 훨씬 더 간결한 문법으로 처리할 수 있다
		
		
		
	}
}
