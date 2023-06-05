package static_final;

class Guest{
	String name;
	static int count;
	
	Guest(String name){
		this.name = name;
		count += 1;
	}
	
	void show() {
		System.out.println(name + "입장!!");
		System.out.println("현재까지 입장한 손님의 인원 수  : " + count);
		
	}
}
// class에서 점(.)찍어서 호출할 수 있으면  static이다
// System.,out., 등 이런 경우들이 모두 static이라고 한다

public class Ex02 {
	public static void main(String[] args) {
		Guest ob1 = new Guest("이지은 ");
		ob1.show();
		
		Guest ob2 = new Guest("홍진호 ");
		ob2.show();
		
		System.out.println("현재까지 손님의 수 : " + Guest.count);
		
		// 문자열을 int로 치환하여 +1과 계산되고 반환
		System.out.println(Integer.parseInt("1234") + 1);
		
	}
}
