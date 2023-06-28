package 안지혜1B;
import java.util.*;

// 학생 정보를 다룰 수 있는 기능
public class Handler {

	// 학생 정보를 저장하는 배열
	Student[] arr = new Student[35];
	
	// 학생 추가
	public int Addstudent(Student tmp) {
		int row = 0;
		
		if(tmp != null){	// tmp 값이 있는 상태
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == null) { // 빈공간일때
					arr[i] = tmp;	 // tmp 값 넣기
					row = 1;		 // row = 1;
					break;
				}
			}
		}
		return row;
	}

	
	// 학생 전체 정보
	public Student[] Arrstudent() {
		return arr;
	}

	
	// 검색
	public Student[] Search(String name) {
		Student[] stu = null;
		int length = 0;
		
		for(int i = 0; i < arr.length; i++) {
			Student s = arr[i];
			if(s != null && s.getName().contains(name)) {
				length++;
			}
		}
		
		stu = new Student[length];
		length = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null && arr[i].getName().contains(name)) {
				stu[length++] = arr[i];
				
			}
		}
		if(length == 0) {
			System.out.println(name + ": 학생정보가 없습니다");
		}
		return stu;
	}
	
	// 삭제
	public int delete(String name) {
		int row = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null && arr[i].getName().equals(name)) {
				arr[i] = null;
				row += 1;
			}
		}
		return row;
	}

	public Student[] sort() {
		// arr을 정렬한다(정렬 기준)
		Arrays.sort(arr, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1 != null && o2 != null) {
					// 0이 아닌 이유 (음수를 반환하면 위치가 바뀐다)
					return o1.getAvg() > o2.getAvg() ? -1 : 1; 					
				}
				return 0;
			}
		});	
		return arr;
	}
	
	

}
