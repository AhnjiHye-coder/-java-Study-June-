package thread;

import java.util.Scanner;

class Timer2 implements Runnable{
	
	private boolean over = false; // 실행,중단 을 조절하는 논리값
	private Quesrion quesrion;		// 입력 후엔 멈출 수 있도록  입력받는 기능이 탑제된 클래스 참조
	
	// 오버라이딩으로 실행하여 여기서는 타이머 자체를 실행하게 만든다
	// 타이머 턴을 만들고 break로 반복이 끝나면 종료할 지점을 설정한다
	// 그리고 있는 것을 가져다 쓰는 Quesrion 클래스에서 타이머 기능을 가져다가 범위만 정해주면 된다
	@Override
	public void run() {
		try {Thread.sleep(500);} catch(Exception e) {}
		
		// quesrion.isInputed() == false인 상태는 아직 입력을 하지 않은상태
		// 입력을 하게 되면 Quesrion 클래스의 run메서드가 실행되면서 Timer2클래스의
		// isOver가 true로 바뀌게 된다
		// 이렇게 연동을 하려면 각 클래스에 따른 is함수가 있어야 연결이 된다
		// 그리고 각 클래스에서 담당하는 boolean 타입이여야 한다
		// boolean 타입을 해야 하는 이유는 타이머가 false일때 작동하고 true일때 멈추기 때문이다
		// quesrion.isInputed이 false면 작동하는데 over이 true여야 멈추기 때문에
		//  Quesrion여기에  over인 isOver 메서드를 연결시켜 입력했을때 true로 만들어주는
		// 식을 구현하면 된다
		
		// 5초 타이머, 1씩 감소, -1이 되면 종료
		for(int i = 5; i != -1 && quesrion.isInputed() == false; i--) {
			// 시간 출력
			System.out.printf("\n%02d : %02d\t", i /60, i % 06);
			// 중간 시간 텀
			try {Thread.sleep(1000);} catch(Exception e) {}
		}
		over = true; // 반복문이 끝나면 필드에 true가 담기면서 종료
	}
	
	public void setQuesrion(Quesrion quesrion) {
		this.quesrion = quesrion;
	}
	
	public boolean isOver() {
		return over;
	}
	
}

class Quesrion implements Runnable {
	
	private boolean inputed = false;
	private Scanner sc = new Scanner(System.in);
	private Timer2 timer;
	
	// 다른 클래스에서 참조할 수 있도록 set 생성
	public void setTimer(Timer2 timer) {
		this.timer = timer;
	}
	
	// 현재 클래스 안에서 타이머를 실행하는 boolean타입 생성
	public boolean isInputed() {
		return inputed;
	}
	
	@Override
	public void run() {
		System.out.println("문제) 다음 중 출연 작품이 서로 다른 하나는?");
		System.out.println("1. 짱구");
		System.out.println("2. 유리");
		System.out.println("3. 철수");
		System.out.println("4. 코난");
		System.out.println("5. 훈이");
		System.out.print("입력 >>> ");
		int answer = sc.nextInt();
		inputed = true;
		if(answer == 4 && timer.isOver() == false) {
			System.out.println("정답");
		}
		else {
			System.out.println("오답");
		}
		sc.close();
	}	
}


public class Ex04 {
	public static void main(String[] args) {
		
		// 타이머가 시작된 후 문제를 낸다
		// 문제는 객관식으로 1번에서 5번까지의 선택지가 잇다
		// 답을 입력하면 정답, 오답을 판별하여 출력해야 한다
		// 정답,오답 여부에 상관없이 타이머가 종료되었다면 오답으로 판정한다
		// 이미 입력이 끝났다면 더 이상 타이머를 진행하지 않아야 한다
				
		// 만들면서 하려면 생성자
		// 만들어놓고 하려면 set		
		
		Timer2 timer = new Timer2();		// 두 객체를 생성
		Quesrion question = new Quesrion();
		
		Thread th1 = new Thread(timer);		// 객체를 스레드로 만들기
		Thread th2 = new Thread(question);	
		
		timer.setQuesrion(question);	// 객체 끼리 서로 참조시키기
		question.setTimer(timer);		// 생성자를 이용하려면 힘들다
		
		
		th2.start();
		th1.start();
		
		System.out.println(timer.isOver());  // true

	}
}
