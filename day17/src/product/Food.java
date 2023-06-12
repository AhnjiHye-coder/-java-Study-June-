package product;

// 유통기한
public class Food extends Product {
	
	String food;
	
	public Food(String name, int price, String food) {
		super(name, price);
		this.food = food;	
	}


	@Override
	public String toString() {
		String format = "%s] %,d원 (유통기한 : %s)";
		Object[] args = {name, price, food};
		return String.format(format, args);
	}
	
	
}
