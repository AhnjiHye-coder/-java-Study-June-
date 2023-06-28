package ������1B;

// �Ϲ��л�
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
		String fomat = "%s : �հ� : %d, ��� : %.2f\n";
		Object[] args= {getName(),total,avg};
		return String.format(fomat, args);
	}
	
	@Override
	public String toString() {
		String fomat = "�̸� : %s\n"
				+ "c���: %d\n"
				+ "java: %d\n"
				+ "spring: %d\n"
				+ "�հ� : %d\n"
				+ "��� : %.2f\n";
		Object[] args= {getName(),c,java,spring,total,avg};
		return String.format(fomat, args);
	}
	

}
