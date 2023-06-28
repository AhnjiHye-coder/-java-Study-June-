package ������1B;
import java.util.*;

// �л� ������ �ٷ� �� �ִ� ���
public class Handler {

	// �л� ������ �����ϴ� �迭
	Student[] arr = new Student[35];
	
	// �л� �߰�
	public int Addstudent(Student tmp) {
		int row = 0;
		
		if(tmp != null){	// tmp ���� �ִ� ����
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == null) { // ������϶�
					arr[i] = tmp;	 // tmp �� �ֱ�
					row = 1;		 // row = 1;
					break;
				}
			}
		}
		return row;
	}

	
	// �л� ��ü ����
	public Student[] Arrstudent() {
		return arr;
	}

	
	// �˻�
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
			System.out.println(name + ": �л������� �����ϴ�");
		}
		return stu;
	}
	
	// ����
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
		// arr�� �����Ѵ�(���� ����)
		Arrays.sort(arr, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1 != null && o2 != null) {
					// 0�� �ƴ� ���� (������ ��ȯ�ϸ� ��ġ�� �ٲ��)
					return o1.getAvg() > o2.getAvg() ? -1 : 1; 					
				}
				return 0;
			}
		});	
		return arr;
	}
	
	

}
