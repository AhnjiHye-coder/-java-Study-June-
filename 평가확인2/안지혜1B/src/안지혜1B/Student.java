package ������1B;

// �л�
public abstract class Student {
	
	//�̸�
	
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

	
	// �⺻ ���� ������ 
	public Student(String name) {
		this.name = name;
		

	}
	
	
	public String toString2() {
		return null;
	}

	// �л� �߻� �޼���
	@Override
	public abstract String toString();
	
	
	
}
