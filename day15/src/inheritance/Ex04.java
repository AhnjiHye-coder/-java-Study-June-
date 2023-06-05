package inheritance;

class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	void show() {
		System.out.println("x : " + x + "\n" + "y : " + y);
	}
}


// 상속하는 이유 : 기존 클래스를 가져와서 기존 클래스 기반으로 사용하고 싶을때
// 상속 : 이미 만들어진 필드와 메소드를 그대로 물려받고 필요한 필드/메서드를 추가하거나
// 기본 메서드의 내용을 변경하여 새로운 용도의 클래스를 작성하는 방법
// 상속을 할때의 장점은 이미 만들어진 클래스에 상세한 내용을 몰라도 클래스의 이름만 알면
// 필요한 기능을 모두 가져올 수 있다, 즉 자료형의 재활용을 할 수 있는 것이다

// 특징
// 슈퍼 클래스가 가지고 있는 형식을 똑같이 맞춰야 하고 내용을 덮어 쓸 수 있다

class Pos3D extends Pos{
	// Pos3D 클래스에 Pos클래스가 상속해주었다
	// 이때는 Pos에 있는 필드까지 서브클래스에 해줄 필요는 없다
	// 상속을 받게 되면 상속을 해준 Pos 생성자에 전달되어 알아서 넣어준다
	// 그러므로 필요한 필드만 생성해주면 된다
	int z;
	
	Pos3D(int x, int y, int z){
		// 여기도 마찬가지로 Pos의 필드를 여기에 새로 초기화할 필요없이
		// Pos에 전달 되도록 super로 생성자에 넣어주면 슈퍼클래스에 전달되며
		// 슈퍼클래스에서 필드의 대한 생성자가 진행되고 처리가 끝나면 다시
		// 서브클래스로 오는 것이다
		super(x,y);
		this.z = z;
	}
	
	@Override			//상속받은 함수의 형태 그대로 내용만 덮어쓴다
	void show() {		// 함수도 물려받지만 새로 정의하면 내용을 바꿔서 실행할 수 있다
		System.out.printf("x : %d\ny : %d\nz : %d\n", x, y, z);
	}
}


public class Ex04 {
	public static void main(String[] args) {
		Pos ob1 = new Pos(2, 3);
		ob1.show();
		System.out.println();
		
		Pos3D ob2 = new Pos3D(4, 7, 3);
		ob2.show();
		System.out.println();
		
			
		
	}
}
