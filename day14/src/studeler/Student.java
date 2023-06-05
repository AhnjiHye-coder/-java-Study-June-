package studeler;

// 속석
public class Student {
	
	private String name;		   // 학생이름
	private int kor, eng, mat,sum; // 각 점수와 총합
	private double avg;			   // 평균
	
	
	public Student() {
		
	}
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		// 여기서 합계,평균은 this를 생략해도 된다
		this.sum = kor + eng + mat;
		avg = sum / 3.0;
		
	}
	
	public void total() {
		System.out.print("학생이름 : " + name + "\n");
		System.out.println("총 점 : " + sum);
		System.out.println("평균 : " + avg);
	}
	
	public String getName() {
		return name;
	}
	
}
