package abstractClass;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

// 직접 객체를 생성하지 않고, 상속을 위한 클래스이다

abstract class MyButton{
	// 일반 메서드 click() : 내장된  onClick()을 실행한다
	// 내장된 onClick의 값을 대입하는 생성자
	public void Click() throws Exception{
		this.onClick();	// 여기서 onClick를 선언한다
		// 그리고 각 클래스에 가져가서 오버라이딩을 실행한다
		// 그럼 Click가 각 클래스마다 오버라이딩이 되어있기 때문에
		// Click만 호출하면 각 클래스 안에 오버라이딩이 되어있는 onClick가 실행
		// Click 한번만 입력해주면 알아서 각 정의된 메서드가 실행된다
	}
	
	// 추상메서드 onClick() : 내용은 정해지지 않았다
	// 내용을 정의하지 않는 onClick 메서드
	protected abstract void onClick() throws Exception;
	// 내용을 정의하기 전까지는 일반 메서드의 오류가 나타난다
}

// MyButton을 상속받는 클래스 TestButton
class TestButton extends MyButton{
	// 상속받는 여기서 onClick의 메소드 내용을 재정의한다

	@Override
	protected void onClick() throws Exception {
		System.out.println("test");
	}
}

class SquareButton extends MyButton{
	private int size;
	
	public SquareButton(int size) {
		this.size = size;
	}

	@Override
	protected void onClick() throws Exception {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

public class Ex02 {
	public static void main(String[] args) throws Exception {
		
		TestButton btn1 = new TestButton();
		btn1.Click();
		
		SquareButton btn2 = new SquareButton(5);
		btn2.Click();
		
		
		MyButton btn3 = new MyButton() {
			
			private String url = "https:map.naver.com";
			private String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; 
			
			@Override
			protected void onClick() throws Exception {
				
				// 운영체계에게 명령을 전달할 수 있는 런타임 가져오기
				Runtime rt = Runtime.getRuntime();
				
				// 문자열 형식의 명령어 준비
				String cmd = String.format("%s %s", chromePath);
				
				// 명령어를 실행하여 프로세스 받기
				Process pro = rt.exec(cmd);
				
				// 5초동안 대기
				Thread.sleep(5000);
				
				// 실행된 프로새스를 강제로 종료
				pro.destroyForcibly();
			}
		};
		btn3.Click();
		
		// 다형성에 의해서 각 서브클래스 객체는 수퍼클래스 MyButton으로 받을 수 있다
		MyButton ob1 = btn1;
		MyButton ob2 = btn2;
		MyButton ob3 = btn3;
			
		
		MyButton[] arr = {ob1, ob2, ob3};
		for(MyButton btn : arr) {	// arr내부의 각 btn에 대하여
			btn.Click();			// btn을 클릭했을때 결과를 호출한다
			// Click를 실행하면 내부에  onClick의 각 객체마다 따로 정의한 오버라이딩 실행
			
		}
		
		// 추상 클래스를 활용하여 객체를 구성하면
		// 서로 다른 클래스를 작성하고 서로 다른 내용의 한수를 구성하면서도
		// 일관된 방식으로 접근하여 처리할 수 있게 된다
		
	}
}






