package thread;

import java.util.ArrayList;
import java.util.Scanner;

class Timer implements Runnable{

	@Override
	public void run() {
		for(int i = 10; i != -1; i--) { // 10부터 1까지 감소하면서 반복
			// 시간을 출력하고
			System.out.printf("%02d : %02d\n", i / 60, i % 60);
			try {
				Thread.sleep(1000); // 1초씩 기다리는 타이머 코드
			}catch(InterruptedException e) {}
		}
		
	}
	
}

class StringInput implements Runnable {
	
	private Scanner sc = new Scanner(System.in);
	private ArrayList<String> list = new ArrayList<String>();
	// 빈칸을 두고 사용할때 값을 넣고 살아있는 동안에만 입력을 받는다
	private Thread timer;
	
	// 객체 생성시 타이머 스레드가 필요하다
	public StringInput(Thread timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		// Thread 클래스에는 isAlive()메서드를 이용하여 스레드 동작 여부를 판단
									// 오버라이딩으로 타이머가 작동하게 만들었고
		while(timer.isAlive()) { 	// 타이머가 작동 중이라면
			System.out.println("입력 : ");	// 입력을 받고 
			list.add(sc.nextLine());		// 입력 받은 것을 리스트에 추가
		}
		System.out.println("입력 끝, 출력 시작"); // 반복이 종료 되면
		list.forEach(System.out::println);  // 각 리스트의 내용 출력
		System.out.println();
		// 이 코드는 타이머 스레드가 종료되었다면 더이상 입력받지 않겠다는 의미이다
	}		
}


public class Ex03 {
	public static void main(String[] args) {
		
		// run을 오버라이딩으로 담고있고 타이머 감소기능을 담고있는 Timer 클래스
		Timer timer = new Timer();
		
		
		// 타이머가 작동하게 하려면 있어야 하는 Thread클래스
		Thread th1 = new Thread(timer);
		
		
		// run의 오버라이딩을 담고 있고 Threar이 있어야 작동하는 run의 기능을 가지고 있는 
		// StringInput 클래스
		StringInput st = new StringInput(th1);
		
		// 타이머가 작동하는 할떄 입력받고 출력하는 st를 Thread에 담아서
		// start을 해줘야 동시작업을 수행할 수 있게 되는 것이다
		// 즉, start의 함수로  run의 기능을 사용할 수 있는데 start를 사용하려면
		// Thread 클래스를 사용해야 한다 그러므로 StringInput 클래스를 Thread에 담는 것이다
		Thread th2 = new Thread(st);
		
		th1.start(); // 타이머 시작
		th2.start(); // 타이머 시작 후 입력 받는 문자를 리스트에 담고 출력
		
	}
}










