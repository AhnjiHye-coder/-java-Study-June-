package product;

// 추상클래스
// 필요한 기본적인 필드(어디서나 사용될 필드)
// 내 것에 대한 생성자
// 추상메서드생성

public abstract class Product {
	// 필드속성
	String name;
	int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public abstract String toString();
	
}
