package inheritance;

import java.util.Scanner;

public class Ex06_MessageBox {
	
	private Scanner sc;
	private String message;
	
	public Ex06_MessageBox(Scanner sc) {
		this.sc = sc;
		System.out.println("MessageBox 생성자 호출");
	}
	
	void setMessage(String message) {
		this.message = message;
	}
	
	Scanner getScanner() {
		return sc;
	}
	
	void input() {
		System.out.print("메세지 입력 : ");
		message = sc.nextLine();
	}
	
	String getMessage() {
		return message;
	}
	
	
	
}
