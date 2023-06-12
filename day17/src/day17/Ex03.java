package day17;

// 현재 패키지 내부에서 다른 패키지의 클래스를 참조하여 사용하려면  import를 해야한다
//import product.Product;
//import product.Food;
//import product.IndustrialProduct;
abstract class Product {
	
	// 필드(속성)
	String name;
	int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;

	}
	
	// 상속받은 서브클래스에서 오버라이딩하도록 선언
	// 그리고 각 유통기한,제조국가 클래스에서 필드에 맞게 출력하기
	public abstract String toString();
	
}
class IndustrialProduct extends Product{
	String madeIn;
	
	// 제조 국가를 입력 받을 필드와 이름, 금액을 생성자로 초기화
	
	public IndustrialProduct(String name, int price, String madeIn) {
		super(name, price);
		this.madeIn = madeIn;
	}

	// 입력을 받으면 출력할 형식은 식품과 다르기 때문에 제조국가 클래스 형식에 따라
	// 따로 정의해야 한다
	// Product(프로덕트) 오버라이딩 제조국가형식에 맞게 재정의
	@Override
	public String toString() {
		String format = "%s] %,d원(made in %s)";
		Object[] args = {name, price, madeIn};
		return String.format(format, args);
	}

	
}


class Food extends Product{

	String expiteData;
	
	public Food(String name, int price, String expiteData) {
		super(name, price);
		this.expiteData = expiteData;
	}

	@Override
	public String toString() {
		String format = "%s] %,d원 (유통기한 : %s)";
		Object[] args = {name, price, expireData};
		return String.format(format, args);
	}
	
}
public class Ex03 {
	public static void main(String[] args) {
		Product[] arr1 = new Product[] {
			new Food("월드콘", 2000, "2023-12-08"),
			new Food("콘칩", 1500, "2024-01-08"),
			null,
			new IndustrialProduct("KF94 마스크 (검정)", 1500, "Korea"),
			new IndustrialProduct("KF94 마스크 (흰색)", 1500, "Korea"),
			new IndustrialProduct("에너자이저 건전지 AA x6", 4800, "China"),
					
			};
		
		String search = "마스크";
		
		int length = 0;	// 배열의 길이를 체크하기 위해서
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] != null && arr1[i].name.contains(search)) {
				length++;
			}
		}
		
Product[] arr2 = new Product[length];	// arr1의 있던 것을 arr2에 옮겨담는다
		
		int j = 0;
		for(int i = 0; i < arr1.length; i++) {	// 0 ~ 5
			if(arr1[i] != null && arr1[i].name.contains(search)) {
				arr2[j] = arr1[i];
				j++;							// 0 ~ 1
			}
		}
		for(Product p : arr1) System.out.println(p);
		System.out.println();
		
		for(Product p : arr2) System.out.println(p);
		System.out.println();

	}
}
