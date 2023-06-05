package inheritance;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ex06_TimeMessageBox extends Ex06_MessageBox{
	
	// Implicit super constructor Ex06_MessageBox() is undefined for default constructor.
	// Must define an explicit constructor
	// 의미 : 서브 클래스는 반드시 슈퍼클래스의 생성자를 호출해야 한다
	// 슈퍼클래스의 기본 생성자가 없으므로, 생성자를 작성하여 직접 연결해야 한다


	public Ex06_TimeMessageBox(Scanner sc) {
		// 자신의 생성자를 호출할때는 this()
		// 슈퍼클래스의 생성자는 super()
		super(sc);	
	}
	
	@Override
	// 프라이빗접근제어자일땐 아무리 부모자식이라도 사용할 수 없다
	void input() {						// 상속받은 메서드 input()의 형식을 유지한 채로
		System.out.print("메세지 입력 : "); // 내용만 새롭게 작성한다
		Date d = new Date();	
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String time = sdf.format(d);
		String msg = time + " ] " + getScanner().nextLine();
		setMessage(msg);
	
	
	}
	
	// 상속받을때 부모클래스보다 접근제한의 보안강도가 높아지면 안된다
	// 반환형, 이름, 매개변수의 형식만 맞춰준다면 자유롭게 사용가능
	// 오버라이딩 하지 않은 함수는 그대로 사용가능
	// 상속받은 슈퍼클래스의 필드가 private라면 자유롭게 접근이 안될 수 있다
	// 서브클래스는 반드시 생성자에 상속받은 슈퍼클래스를 정의해야 한다
	// 정의 방법, 즉 초기화 방법은 super()에 괄호에 슈퍼클래스 생성자에 있는 것을
	// ,를 이용해 구분하여 그대로 넣어주면 된다
	//  꼭 한번은 넣어줘야 하고 그래야 슈퍼클래스의 기능,필드를 사용할 수 있다
	
	
	
}
