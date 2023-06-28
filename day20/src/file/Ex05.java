package file;

import java.io.File;
import java.io.IOException;

public class Ex05 {
	public static void main(String[] args) throws Exception {
		
		File f1 = new File("a.txt");
		File f2 = new File("C:\\upload", "b.txt");
		File dir = new File("C:\\upload");
		File f3 = new File(dir, "c.txt");
		
		// 자바에서 파일 객체를 생성한다고해서, 실제 디스크에 파일이 만들어지는 것이 아니다
		
		// 실제 파일이 있는지 없는지 확인하는 방법이 있다
		// exists() : 파일 생성의 여부
		// createNewFile() : 생성
		// delete() : 파일 삭제
		System.out.println("f1이 존재하는가 : " + f1.exists());
		System.out.println("f2이 존재하는가 : " + f2.exists());
		System.out.println("dir이 존재하는가 : " + dir.exists());
		System.out.println("f3이 존재하는가 : " + f3.exists());
		
		// 파일이 지정한 위치에 존재하지 않으면 새로운 파일을 생성하는 방법
		if(f1.exists() == false) {  // 파일이 있는가?를 확인하고 false는 없다면 이라는 의미다
			// 즉, 없다면 파일을 생성하는 함수를 넣어줘야 한다
			boolean flag1 = f1.createNewFile();	
			System.out.println("f1이 생성되었는가 : " + flag1);
		}
		
		if(dir.exists()) {  // 파일이 있다면 
			boolean flag2 = dir.delete(); // 삭제 한다
			System.out.println("dir가 삭제되었는가 : " + flag2);	// 삭제 되었는지 확인
		}
		
		System.out.println("f1이 존재하는가 : " + f1.exists());   	// 생성
		System.out.println("f1이 읽기 가능한가  : " + f1.canRead());	// 파일 읽을때
		System.out.println("f1이 쓰기 가능한가  : " + f1.canWrite());	// 파일을 쓸때
		System.out.println("f1이 실행 가능한가  : " + f1.canExecute());
		System.out.println("f1이 파일인가  : " + f1.isFile());
		System.out.println("f1이 디렉토리(폴더)인가  : " + f1.isDirectory());
		System.out.println();
		
	}
}
