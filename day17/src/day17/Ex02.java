package day17;

// abstract : 추상클래스 일때
abstract class Student {
	private String name;
	private int sum;
	private double avg;
	
	public Student(String name, int...scores) {
		this.name = name;	// 이름 그대로 대입
		
		// 점수는 sum에 담아주고 평균을 계산한다
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		avg = (double)sum / scores.length;
	}
	
	// 모든 학생 객체는 출력시 자신의 정보를 문자열로 변환해야 한다
	public abstract String toString();

	public String getName() {
		return name;
	}

	// set/get 만들기
	//shift + ait + s
	
	public void setName(String name) {
		this.name = name;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
}

class Historystudent extends Student { // 학생의 정보

	private int kor, eng, mat, his;
	
	
	public Historystudent(String name, int kor, int eng, int mat,int his) {
		super(name, kor, eng, mat, his); // scores
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.his = his;
	}
	
	@Override
	public String toString() {
		String format = "%s] %d, %d, %d, %d (%d / %.2f)\n";
		Object[] args = {getName(), kor, eng, mat, his,getSum(), getAvg()};
		return String.format(format, args);
	}
}

class CompterScienceStudent extends Student {
	private int kor, eng, mat, clang, java;
	
	public CompterScienceStudent(String name, int kor, int eng, int mat, int clang, int java ) {
		super(name, kor, eng, mat, clang, java);
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.clang = clang;
		this.java = java;
	}

	@Override
	public String toString() {
		String format = "%s] %d, %d, %d, %d, %d (%d / %.2f)\n";
		Object[] args = {getName(), kor, eng, mat, clang, java,getSum(), getAvg()};
		return String.format(format, args);
	}		
}

public class Ex02 {
	public static void main(String[] args) {
		Historystudent ob1 = new Historystudent("짱구", 100, 99, 87, 79);
		System.out.println(ob1);
		
		CompterScienceStudent ob2 = new CompterScienceStudent(
				"철수", 92, 93, 94, 95, 97);
		System.out.println(ob2);
	}
}


















