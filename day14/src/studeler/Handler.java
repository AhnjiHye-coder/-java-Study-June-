package studeler;

public class Handler {
	
	// 저장할 배열 만들기
	private Student[] arr = new Student[10];
	
	// 추가
	public int add(Student st) {
		int row = 0; // main에서 성공,실패를 판별하기 위해 있음
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				arr[i] = st;
				row = 1;
				break;
			}
		}
		return row;
	}
	
	
	// 삭제
	public int puis(String name) {
		int row = 0; // main에서 성공,실패를 판별하기 위해 있음
		for(int i = 0; i < arr.length; i++) {
			// arr[i]는 Student자료형이기 때문에 배열에서 정보를
			// 비교하거나 대입하려면 Student에 get메서드가 있어야 한다
			if(arr[i] != null && arr[i].getName().equals(name)) {
				arr[i] = null;
				row = 1;
				break;
			}
		}
		return row;
	}
	
	// 배열을 내보낼때는 자료형에 배열임을 표시해야 한다
	public Student[] getArray() {
		return arr;
	}
	
	// 검색
	// 1) 내가 입력한 문자와 일치하면 배열에 담고
	// 2) 아니면 패스
	// 3) 마지막에 배열 return(반환)
	
	public Student[] search(String key) {
		// 검색한 사람에게 줄 목록
		// 목록은 비어있으니 null이다
		Student[] retult = null;
		
		// 배열에 넣기 전 학생 숫자를 셀 변수
		int con = 0;
		// 인원수를 체크하고, 인원 정보를 배열에서 꺼내어 만들어 놓은 배열에 넣는다
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null && arr[i].getName().contains(key)) {
				con++;
				
			}
		}
		
		retult = new Student[con];
		int 
		index = 0;
		
		// 이렇게 배열을 두번 거치는 이유는 배열의 공간을 미리 정해야 하기 때문이다
		// 1) 배열의 크기가 낭비되면 안되고
		// 2) 배열은 알아서 줄어들지 않기 떄문이다
		
		// 배열의 크기는 자동으로 줄어들고 커지지 않는다
		// 그러므로 먼저 학생정보가 들어갈 수 있는 공간의 크기를 마련하고
		// 이후에 일치했던 학생들을 원래 배열에서 새로 만든 배열에 복사한다
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null && arr[i].getName().contains(key)) {
				retult[index++] = arr[i];
				
			}
		}
		return retult;
		
		
	}



}











