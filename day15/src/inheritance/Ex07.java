package inheritance;

class Human {
	String name;			// 필드
	
	Human(String name){		// 생성자
		this.name = name;
	}
	
	void show() {	// 메서드
		System.out.println("이름 : " + name);
		System.out.println();
	}	
}

class Student extends Human {	// 학생은 사람이다
	
	String school;				// school 추가되고
	
	Student(String name, String school){
		super(name);			// 슈퍼클래스를 참조하기 위해 생성자에 넣어주면서
		this.school = school;	// 현재 서브 클래스의 필드 값도 생성자로 초기화해준다
	}
	
	@Override
	void show() {
		System.out.println("소속 : " + school);
		System.out.println("이름 : " + name);
		System.out.println();
	}
}


class Actor extends Human {		// 배우는 사람이다
	String drama;
	
	Actor(String name, String drama){
		super(name);
		this.drama = drama;
	}
	
	@Override
	void show() {
		System.out.println("출연작 : " + drama);
		System.out.println("이름 : " + name);
		System.out.println();
	}
}

class Car {
	// 사람이 앉을 수 있는 4인승 자동차
	
	// 4개의 데이터가 들어갈 수 있는 배열
	Human[]  seat = new Human[4];
	
	void entrance(Human ob) {
		for(int i = 0; i < seat.length; i++) {		// 배열 길이만큼 반복
			if(seat[i] == null) {					// 공간이 null이면
				seat[i] = ob;						// 들어온 data 추가
				return;
			}
		}											// 길이만큼 반복했을때
		System.out.println(ob.name + "자리가 없습니다"); // null공간이 없다면
	}
	
	void checkPeople() {
		for(int i = 0; i < seat.length; i++) {
			if(seat[i] != null) {
				seat[i].show();
			}
		}
	}
}




 public class Ex07 {
	 public static void main(String[] args) {
		
		 // 상속이 되면 생성자,오버라이딩을 신경써서 해줘야하고
		 // 내 클래스에 다른 클래스의 객체를 참조하게 되면
		 // 상속이랑은 다르게 내 클래스에서 참조된 클래스의 타입으로
		 // 생성자와 이런거 생관 없이 자료형을 사용할 수 있는 개념이다
		 
		 Car car = new Car();
			
		Student st1 = new Student("안지혜", "KGITBANK");
		Student st2 = new Student("이현우", "KGITBANK");
		Actor ac1 = new Actor("송승헌", "가을동화");
		Actor ac2 = new Actor("마동석", "범죄도시3");
		Human driver = new Human("한문철");
		
		
		// 함수호출하면서 업캐스팅이 발생한다
		// car의 클래스를 사용하는데 그 안에는 Human클래스가 참조되어
		// Human를 슈퍼클래스로 둔 클래스들의 필드를 사용할 수 있는 것이다
		car.entrance(driver);
		car.entrance(st1);		// 인자의 자료형은 서브클래스이지만
		car.entrance(st2);		// 매개변수의 자료형이 슈퍼클래스이므로
		car.entrance(ac1);		// 함수를 호출하면서 업캐스팅이 발생한다
		car.entrance(ac2);
		
		// 내 이름이 따로 있지만 엄마 이름 예기해야 할 상황이 있는 것처럼 다양한 data를
		// 처리해야 할 때 사용 빈도수가 높을 있겠다
		Human t1 = ac1;	// 서브클래스의 객체를 슈퍼클래스 타입으로 참조한다(업캐스팅)
		Human t2 = st1; // 업캐스팅은 각각 다른 타입의 객체를 묶어서 처리하고 싶을때 사용
		// 한 엄마 밑에 아이들이 3명 있다고 했을떄 슈퍼에서 돈을 내야 하는 상황에는 동일한 엄마 1명이 가듯
		// 여러가지 객체이지만 한번에 묶어서 처리하려면 대표적으로 슈퍼클래스로 처리하면 된다
		// 하지만 서브에서 오버라이딩이 된 메소드는 업케스팅이 되어도 서브메서드의 재정의된 내용이 실행된다
		
		car.checkPeople();
		
		// 1) 함수 호출이 가능한가 ?
		// 재정의가 되어있어야 호출가능
		// (둘다 같은 이름의 함수가 있어야 업캐스팅이 적용되어 호출할 수 있다)
		// 현재 슈퍼 클래스에서 show() 메서드가 정의되어 있으므로 호출가능
		
		
		// 2) 내용은 어떻게 실행되는가 ? 
		// 객체를 참조하는 타입만 업캐스팅이 되었고, 객체가 가지는 내용은 변하지 않는다
		// 객체는 오버라이딩 메서드를 가지고 있어서 자료형에 맞는 내용으로 실행된다
		
		// 자바객체지향의 4가지 특성
		// 캡슐화 : 서로 다른 자료형의 변수와 함수를 하나의 객체로 묶어서 취급한다(은닉)
		// 상   속 : 기존 클래스를 활용하여 새로운 클래스를 작성한다
		// (추가로 만들수도 있고, 다른 사람것을 사용할 수도 있다 - 주로 프레임워크때 많이 사용)
		// 추상화 :  실제 객체에서 필요한 부분만 가져와서 클래스의 형태로 구현한다
		// 안드로이드에서 많이 사용되며 형태만 있고, 내용이 없는 함수를 만들어서 이후에 구현한다
		// 다형성 : 하나의 객체는 슈퍼클래스로 참조되거나, 서브클래스로 참조될 수 있다
		// 인터페이스 쓸 때 굉장히 많이 사용하고 자바 전반에 걸쳐서 많이 사용된다
		
		
		
		
	} 
	 
}
