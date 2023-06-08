package abstractClass;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

// 인터페이스는 추상클래스의 한 종류이다
// 인터페이스는 자료형으로 사용할 수 있다
// 인터페이스의 모든 필드는 public static final이다
// 인터페이스의 모든 메서드는 public abstract이다
// 인터페이스는 extends 대신 implements 키워드로 상속(구현)처리한다
// 인터페이스는 일반적인 상속과 달라 다중 상속을 허용한다

interface Test1 {
	public static final int n1 = 10;
	int n2 = 20;
	
	// default를 함수에 지정하면 인터페이스 내부에서도 코드를 작성할 수 있다
	public abstract void show();
	
}

// class Test2 implements Test1 {
// 원래 위이 형식이 맞지만 다중 상속일때는 틀리다
// 밑에 형식이 다중상속을 할때 사용되는 형식이다
class Test2 implements Test1, Serializable, Closeable {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void close() throws IOException {
		System.out.printf("%d, %d\n", n1, n2);
		
	}

	@Override
	public void show() {
		System.out.println("close!!");
		
	}
}

public class Ex04 {
	public static void main(String[] args) throws Exception{
		Test2 ob = new Test2();
		ob.show();
		ob.close();
			
	}
}
