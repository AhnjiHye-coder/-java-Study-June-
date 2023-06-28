package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) throws Exception {
		// 텍스트 파일의 내용을 읽어오기
		
		
		String parent = "C:\\windows\\system32\\drivers\\etc";
		String child = "hosts";
		File f = new File(parent, child);
		
		
		System.out.println("f 존재하는가 ? :" + f.exists());
		
		if(f.exists()) {
			Scanner sc = new Scanner(f); // 파일의 내용을 읽어내는   Scanner
			
			// 다음 줄이 없을때 반복 종료
			while(sc.hasNextLine()) {			// 다음 줄이 있으면
				String line = sc.nextLine();	// 다음 줄을 저장한 다음
				System.out.println(line);		// 출력하고
				Thread.sleep(500);  // 시간을 지연시킬때 사용 500이 0.5이므로
				// 1000은 1초를 의미한다
			}
			sc.close();
		}
	}
}
