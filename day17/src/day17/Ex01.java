package day17;

class Car {
	private Tire tire1;
	
	public Tire getTire1() {
		return tire1;
	}
	
	// set를 이용해서 타이어 객체를 넣어줘야 한다
	public void setTier1(Tire tire1) {
		this.tire1 = tire1;
	}
	
	public void run() {
		System.out.println(tire1 == null ? "작동불가\n" : "작동 가능\n");
		
	}
	
	@Override
	public String toString() {
		return "자동차에 장착된 타이어 : " + tire1;
		
		// 타이어 객체를 참조하여 다른 클래스에서 이름을 정하면 get로 다른 클래스에 보여질 수 있고
		// set로 다른 클래스에서 매개변수를 전달 받아서 Tire 클래스에 전달할 수 있다
		// 그리고 매개변수로 전달받은 타이어의 작동 유/무
		// 오버라이딩 된 메서드로 장착된 타이어의 작동 유/무 판별이 가능하다
		// 즉, car라는 클래스에 끼운 타이어가 작동하는지, 어떤 타이어를 끼웠는지
		// 판별하도록 만든 클래스이다
	}
}

// abstract는 추상메서드 할때 사용
// extends는 상속 할때 사용
// 타이어를 차에 끼우면 어떤 타이어를 끼웠는지 다른 클래스에서
// toString메서드를 오버라이딩 하여 공유해올 것이다
abstract class Tire {	// 슈퍼클래스가 추상클래스이고
	public abstract String toString();	// 어떤 추상메서드를 포함한다면
};

class SnowTire extends Tire { // 상속에서 서브클래스는 추상클래스의 추상메서드를 반드시 구현
	
	// 각 오버라이딩으로 어떤 타이어가 있는지 Tire를 상속받아 오버라이딩해준다
	// 그럼 Tire를 참조하고 있는 car에서 Tire와 연결되어있는 타이어들을 호출하여
	// 작동 유/무를 판단한다
	
	@Override
	public String toString() {
		return "스노우 타이어";
	}
	
}

class NormalTire extends Tire {

	@Override
	public String toString() {
		return "일반 타이어";
	}
	
}

class OffroadTire extends Tire {

	@Override
	public String toString() {
		return "오프로드 타이어";
	}
	
}


public class Ex01 {
	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car);
		car.run();
		
		// 서로 다른 타입의 타이어 객체 생성
		SnowTire snowTire = new SnowTire();
		OffroadTire off = new OffroadTire();
		NormalTire Norma = new NormalTire();
		
		car.setTier1(snowTire); // 자동차에 타이어 장착
		System.out.println(car); // 장착된 타이어 출력
		car.run();				 // 작동 유무
		
		car.setTier1(Norma);
		System.out.println(car);
		car.run();
		
		car.setTier1(off);
		System.out.println(car);
		car.run();
		
		// 타이어 해제
		car.setTier1(null);
		System.out.println(car);
		car.run();
		System.out.print("타이어 해제");
		// 클래스 Car가 Tire타입의 객체를 필요로 할때 (의존성)
		// Tire의 서브 클래스(s, o, n)객체를 교체해여 연결해도
		// Car의 작동에는 문제가 없어야 한다
		
		
	}
}











