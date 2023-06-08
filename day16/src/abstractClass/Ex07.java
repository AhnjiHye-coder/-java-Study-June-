package abstractClass;

import java.util.Arrays;
import java.util.Comparator;

class Student {
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
}

public class Ex07 {
	static void showArray(Student[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i].show();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Student[] arr = {
				new Student("짱구", 91, 62, 76),
				new Student("훈이", 41, 23, 57),
				new Student("철수", 89, 92, 78),
				new Student("유리", 62, 64, 88),
				new Student("맹구", 34, 45, 57),
		};
		showArray(arr);
		
		// 잠깐, 정수의 배열을 정렬해보자
		Integer[] arr2 = {4, 8, 2, 7, 6};
		System.out.println(Arrays.toString(arr2));
		Arrays.sort(arr2,null); // arr2배열 null방식으로 정렬하라는 의미
		// null이지만 정렬된 이유는 기본값이 적용된 것이다
		// 정렬의 기본값은 오름차순이다
		
		System.out.println(Arrays.toString(arr2));
		System.out.println();
		
		// 다시, 학생 배열로 돌아와서, 배열을 지정하지 않고 정렬을 시도한다
//		Arrays.sort(arr,null);	// 실행불가
		// Student cannot be cast to Comparable
		// 위 의미는 Student는 Comparable 타입으로 변환할 수 없다는 의미
		// Student는 비교가능한 타입이 아니다(크기 비교에 대한 기준이 없다)
		
		// 대신, 선택정렬을 이용하여 합계순으로 내림차순 정렬하는 함수를 만들어보자
		selectionSortOrderBySumDesc(arr);
		showArray(arr);
		
		// 서로 다른 두 객체를 비교하는 내용을 담은 함수를 전달해야 한다
		// 함수는 객체 취급될 수 없어서, 함수를 포함하는 객체를 생성해서 전달
		// 1) 국어 점수를 기준으로 내리마순 정렬하는 객체를 익명클래스로 작성하기
		Comparator<Student> korComp = new Comparator<Student>() {
			@Override
			public int compare(Student a, Student b) {
				return b.kor - a.kor;
			}
		};
		Arrays.sort(arr, korComp);
		showArray(arr);
		
		// 2) 람다식을 이용하여 객체를 생성하고, 영어점수 기준 내림차순 정렬하기
		Comparator<Student> engComp = (a,b) -> {return b.eng - a.eng;};
		Arrays.sort(arr,engComp);
		showArray(arr);
		
		// 3) 람다식으로 즉성에서 객체를 생성하면서 전달하고, 수학점수 기준 내림차순 정렬하기
		// 배열의 a,b객체 받고 b,a정렬반환
		Arrays.sort(arr, (a,b) -> b.mat - a.mat);
		// 매개변수로 전달받은 값을 반복문으로 배열에 추가한다는 메서드로
		// 반환된 값을 출력한다
		showArray(arr);
		
		
	}
	
	static void selectionSortOrderBySumDesc(Student[] arr) {
		for(int i = 0; i < arr.length -1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i].sum - arr[j].sum < 0) {
					Student a = arr[i];
					Student b = arr[j];
					if(a.sum - b.sum < 0) {
						Student tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
		}
	}
}










