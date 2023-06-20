package 안지혜A1;

public class Customer extends Member{

	// 배송정보를 입력받을 필드
	String address;
	
	public Customer(String id, String password, String name, String address) {
		super(id,password, name);
		this.address = address;
	}

	@Override
	public String toString() {
		System.out.println("[구매자 정보]");
		String format = "ID : %s\n"
				+ "PW : ********\n"
				+ "이름 : %s 님\n"
				+ "배송 주소: %s\n";
		Object[] args = {id, password, name, address};
		return String.format(format, args);
	}
	
}
