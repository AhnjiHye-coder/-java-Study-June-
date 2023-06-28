package file;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) throws Exception {
		
		// 프로젝트 폴더에 ex09.txt파일을 생성한 다음
		// FileWriter를 이용하여 본인의 이름과 생일을 기록하세요
		
		// 이름은 첫 줄, 생일과 월과 일만 두번째줄에 기록하세요
		
		// Scanner을 사용하여 대상 파일을 읽어서
		// 한 줄씩 화면에 출력하세요
		
		File f = new File("ex09.txt");
		FileWriter fw = new FileWriter(f);
		
		if(f.exists() == false) {
			
			boolean flag = f.createNewFile(); // 파일이 없다면 새로 생성
			System.out.println("f - " + flag);
		}
		
		
		
		fw.append("안지헤\n");
		fw.append("12월 18일\n");
		fw.flush();
		fw.close();
		
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			String line = sc.nextLine(); // sc를 line에 담아서 
			System.out.println(line);	 // 출력
		}
		sc.close();
		
		// "notpad" : 명령어인데 메모장을 부를 수 있다(마지막에 한칸 띄워야 한다
		// 내가 실행하고 싶은 프로그램("notpad") +  절대경로
		String command = "notpad " + f.getAbsolutePath();
		Process pro = Runtime.getRuntime().exec(command);
		Thread.sleep(5000);
		pro.destroy();
	}
}
