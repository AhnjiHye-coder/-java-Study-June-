package thread;

// extends(익스텐즈)
class JobA extends Thread {
	// 1) Thread 클래스를 상속받는다
	// 2) pubilc void run()을 오버라이딩하여 내용을 작성한다
	// 3) 객체를 생성한 후 start() 메서드를 호출하여 동시 작업을 수행한다
	
	@Override
	public void run() {
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch + " ");
		}
	}
}


class JobB extends Thread{
	@Override
	public void run() {
		for(int i = 0; i <= 25; i++) {
			System.out.println(i + " ");
		}
	}
}


public class Ex01 {
	public static void main(String[] args) {
		// Thread : 동시에 서로 다른 작업을 수행하기 위한 클래스
		
		JobA th1 = new JobA();
		JobB th2 = new JobB();
		
		th1.run();	// 일반적인 메서드 호출을 진행하여
		th2.run();	// 다중 스레드로 작동하지 않는다
		System.out.println();
		
		th1.start();	// run의 내용을 별도의 스레드를 생성하여
		th1.start();	// 새로운 스레드 내부에서 실행한다
		System.out.println();
		
		
		// 스레드가 필요한 이유
		// 일반적으로는 작업(함수)가 호출되어있는 상태에서는 다른 함수가 호출되지 않는다
		// 함수가 쌓여올라가는 구조이기 때문에 호출되지 않는다
		// 하지만 스레드는 A라는 작업이 있을때 옆에 B라는 작업을 둔다, 즉 cpu가 여러개인 것이다
		// (핵심 코어유닛 - 코어를 분리하여 다중 작업을 할 수 있다)
		// 각각의 스레드가 여러가지 함수를 수행할 수 있게 된다
		// 노트북의 경우 배터리와 같이 있기 떄문에 cpu의 출력이 낮게 설계해놨다
		
		
		
		
		
		
	}
}	
