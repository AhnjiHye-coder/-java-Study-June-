package product;

// 제조국가
// 슈퍼클래스는 따로 필드를 생성하지 않는다
// 필드는 접근제한자도 하지 않는다
public class IndustrialProduct extends Product {
	
	
	String industr;
	
	// 생성자는 슈퍼클래스의 필드까지 매개변수로 추가한다
	public IndustrialProduct(String name, int price, String industr) {
		super(name, price);
		this.industr = industr;
	}
	

	@Override
	public String toString() {
		String format = "%s] %,d원(made in %s)";
		Object[] args = {name, price, industr};
		return String.format(format, args);
	}

}