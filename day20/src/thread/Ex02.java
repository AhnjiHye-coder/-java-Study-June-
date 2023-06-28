package thread;

// 내가 만드는 작업 클래스가 이미 다른 클래스를 상속받고 있다면
// 자바 클래스의 다중 상속을 허용하지 않기 떄문에 Runnable(러너블)
// implements(인터페이스)를 구현하여 내부 run오버라이딩을 한다

// 하나만 상속받을 수 있어서 하나만 상속받을 수 있지만 인터페이스로는 다중 상속이 가능하다

class JobC extends Object implements Runnable{

	@Override
	public void run() {
		for(char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(ch + " ");
		}
		
	}
	
}
public class Ex02 {
	// main한수도 하나의 스레드 안에서 작동한다
	public static void main(String[] args) {
		JobC ob = new JobC();
		
		// 다중 작동이 필요한 상태
		// 런만 오버라이딩하고 오버라이딩하고 있는 상속자들 사용해서 static를 사용하여 다중상속
//		ob.run();	// run은 다중 스레드로 작동하지 않는다
//		ob.start();	// runnable은 start 메서드가 없다
		
		// 연결해준 상태
		// Runnable과 연결되어있는 JobC클래스를 Thread에 담아 연결시켜준다
		// 이렇게 되면 Thread의 함수인 start을 사용하여 출력할 수 있게 되는 것이다
		// 따라서 start가 있는 함수를 연결시켜주어 다중상속의 효과를 보게 된다
		Thread th = new Thread(ob);
		th.start();
		
		for(int i = 0; i < 25; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		
	}
}
