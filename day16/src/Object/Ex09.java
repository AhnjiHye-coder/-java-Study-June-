package Object;

class Student { // extends Object 표시는 없지만 상속받고 있음 
	String name;
	int kor, eng, mat, sum;
	double avg;
	
	public Student(String name, int k, int e, int m) {
		this.name = name;
		kor = k;
		eng = e;
		mat = m;
		sum = k + e + m;
		avg = sum / 3.0;
	}
	
	public void show() {
		System.out.printf("%s] %d, %d, %d, %d, %.2f\n"
				,name, kor, eng, mat, sum, avg);
	}
	@Override
		public String toString() {
		String format = "%s] %d, %d, %d, %d, %.2f\n";
		Object[] args = {name, kor, eng, mat, sum, avg};
		String s = String.format(format, args); // 입력받은 것을 printf로 처리
			return s;
		}
}

public class Ex09 {
	public static void main(String[] args) {
		Student s1 = new Student("짱구", 11, 12, 13);
		Student s2 = new Student("유리", 21, 22, 23);
		
		s1.show();
		
		// 원레 다른 클래스의 내용을 바로 출력하는 것은 안되지만 s2가 가능한 이유는
		// Object가 있기때문에 가능
		System.out.println(s2);	
		
	}
	
	
}
