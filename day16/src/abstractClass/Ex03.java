package abstractClass;

// 추상메서드가 없는 경우

class TestButton2{
	
	protected void onClick() throws Exception{
		System.out.println("test");
	}
}

class SquareButton2{
	private int size;
	
	public SquareButton2(int size) {
		this.size = size;
	}
	
	
	protected void onClick() throws Exception{
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

public class Ex03 {
	public static void main(String[] args) {
		
		TestButton2 btn1 = new TestButton2();
//		btn1.Click();
		
		
		SquareButton2 btn2 = new SquareButton2(5);
//		btn2.Click();
		
		Object[] arr = {btn1, btn2};
//		for(Object ob : arr) {
//			ob.Click();
//			ob.onClick();
//		}
		// Object 클래스에는 Click()혹은 onClick()이라는 함수가 없어서 호출 불가
		// 개별처리는 가능하지만, 일괄처리는 불가능하다
	}
}




