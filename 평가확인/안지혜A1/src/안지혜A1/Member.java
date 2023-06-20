package 안지혜A1;
//회원
public abstract class Member {
	
	// 회원이 가져야할 기본 정보
	String id;
	String password;
	String name;
	
	// 기본 정보를 초기화
	public Member(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
		
	}
	
	// 추상메서드
	@Override
	public abstract String toString();
	
	
	
}
