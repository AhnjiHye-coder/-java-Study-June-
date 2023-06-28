package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex08 {
	public static void main(String[] args) throws Exception {
		
		File f = new File("a.txt");
		
		if(f.exists() == false) {
			f.createNewFile(); // 파일이 없으면 생성
		}
		
		// 기존 내용을 유지하고 아래쪽에 내용을 추가할 것인가?
		// 덧 붙일거라면 false, 밑에 추가할 거라면 true
		
		boolean append = true;
		
		FileWriter fw =  new FileWriter(f,append);
		// FileWriter : 텍스트를 기록하는 함수
		// 파일과 append 함수를 썼을때 그 내용을 파일에 옮기는 역할
		// 즉 통로의 역할을 한다
		fw.append("Hello\n"); // 기록한 파일에 문자 추가
		fw.append("world\n");
		fw.append("java\n");
		fw.append("한글\n");
		fw.append("안지혜\n");
								// 사용한 fw공간을 정리한다
		fw.flush();				// 다 옮겼다면 fw공간을 비운다
		fw.close();				// 그리고 공간을 닫는다
		
		System.out.println("완료");
	}
}
