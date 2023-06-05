package chat;

public class Phone {
	
	// 먼저 이 class를 만들려면 어떤 속성이 필요한지 생각한다
	// 메세지는 이름과 내용이 필요하다
	
	private String name;
	private String msg;
	
	public Phone(){
		
	}
	
	// 다른 클래스에서 Phone자료형으로 객체를 만들었을때 바로 초기화까지
	// 할 수 있도록 생성자를 만들어 준다
	public Phone(String name){
		this.name = name;
		
	}
	
	// 다음은 나와 상대방이 문자 내용을 주고 받는 메서드이다
	// 나,상대방,메세지가 모두 들어가야 한다
	// 이때 나를 표현할 수 있는 것은 this를 입력해주면 된다
	// 그렇기 때문에 매개변수는 상대방과 메세지만 해준다
	// 그리고 출력할때 어떤 형식을 사용할지는 다른 메소드에서 만들어준 것을
	// msg메소드에 반영한다
	public void Msg(Phone to, String msg) {
		to.recieveMessage(this,msg);
	}
	
	// 메세지 초기화는 사용하는 메서드인 recieveMessage에서 해주며 출력문 실행
	public void recieveMessage(Phone to, String msg) {
		this.msg = msg;
		System.out.println("보낸사람 : " + this.name);
		// 상대방을 호출할때는 to만하는 것이 아니라 to인 상대방의 어떤 것을?
		// 이름을 호출한다는 형식으로 사용해야 한다
		System.out.println("받는 사람 : " + to.name);
		System.out.println("내    용 : " + msg);

	}
	
	
}
