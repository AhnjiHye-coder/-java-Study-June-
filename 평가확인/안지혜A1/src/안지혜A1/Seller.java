package 안지혜A1;
//판매자
public class Seller extends Member{
	
	// 가게이름을 입력 받을 필드
	String storeName;  
	
	public Seller(String id, String password, String name, String storeName) {
		super(id,password, name);
		this.storeName = storeName;
		
	}

	@Override
	public String toString() {
		System.out.println("[판매자 정보]");
		String format = "ID : %s\n"
				+ "PW : ********\n"
				+ "이름 : %s 님\n"
				+ "가게 이름 : %s\n";
		Object[] args = {id, password, name, storeName};
		return String.format(format, args);
	}
}
