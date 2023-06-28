package 안지혜1B;

// 학생
public abstract class Student {
	
	//이름
	
	private String name;
	private int total;
	private double avg;

	
	
	public void setTotal(int total) {
		this.total = total;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getTotal() {
		return total;
	}
	
	public double getAvg() {
		return avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	// 기본 정보 생성자 
	public Student(String name) {
		this.name = name;
		

	}
	
	
	public String toString2() {
		return null;
	}

	// 학생 추상 메서드
	@Override
	public abstract String toString();
	
	
	
}
