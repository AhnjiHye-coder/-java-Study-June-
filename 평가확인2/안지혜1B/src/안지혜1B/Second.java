package ������1B;

// ��2�ܱ��� ����
public class Second extends Student{
	
	private int c;
	private int java;
	private int spring;
	private int eng;
	private int total;
	private double avg;
	
	public Second(String name, int c, int java, int spring, int eng) {
		super(name);
		this.c = c;
		this.java = java;
		this.spring = spring;
		this.eng = eng;
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
		String fomat = "%s : �հ� : %d, ��� : %.2f\n";
		Object[] args= {getName(),total,avg};
		return String.format(fomat, args);
	}
	
	
	@Override
	public String toString() {
		String fomat = "�̸� : %s\n"
				+ "c��� : %d\n"
				+ "java : %d\n"
				+ "spring : %d\n"
				+ "english : %d\n"
				+ "�հ� : %d\n"
				+ "��� : %.2f\n";
		Object[] args= {getName(),c,java,spring,eng, total, avg};
		return String.format(fomat, args);
	}
}
