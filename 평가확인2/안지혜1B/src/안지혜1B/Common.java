package 안지혜1B;

// 일반학생
public class Common extends Student{
	
	private int c;
	private int java;
	private int spring;
	private int total;
	private double avg;

	public Common(String name, int c, int java, int spring) {
		super(name);
		this.c = c;
		this.java = java;
		this.spring = spring;
		this.total = c + java + spring;
		this.avg = total / 3.0;
	}

	
	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public double getAvg() {
		return avg;
	}


	public void setAvg(double avg) {
		this.avg = avg;
	}


	public String toString2() {
		String fomat = "%s : 합계 : %d, 평균 : %.2f\n";
		Object[] args= {getName(),total,avg};
		return String.format(fomat, args);
	}
	
	@Override
	public String toString() {
		String fomat = "이름 : %s\n"
				+ "c언어: %d\n"
				+ "java: %d\n"
				+ "spring: %d\n"
				+ "합계 : %d\n"
				+ "평균 : %.2f\n";
		Object[] args= {getName(),c,java,spring,total,avg};
		return String.format(fomat, args);
	}
	

}
