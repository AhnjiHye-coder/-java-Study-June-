package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Ex10 {
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		System.err.println("경로 입력 : ");
		String url;
		// hppt 403은 권한으로 거절한다는 의미이다
		
		url = sc.nextLine();	// 웹 페이지에서 주소를 복사하여 넣기
		
		// 웹주소랑 연결
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		String contentType = conn.getContentType(); // 타입 확인
		int fileSize = conn.getContentLength();	
		String fileName = "test.";
		fileName += contentType.split("/")[1]; // "/"을 기준으로 문자를 자른다(split)
		
		// 파일을 일정 크기만큼 옮기기 위한 그릇
		byte[] buf = new byte[1024];
		// 한번 받을  떄의 크기 (출력하기 위한)
		int b = 0;
		// 총 누적 다운로드 크기 (출력하기 위한)
		int total = 0;
		// 웹 파일을 불러오는 입력 스트림
		// getInputStream을 사용해서 웹파일을 불러온다
		InputStream is = conn.getInputStream();
		//불러온 데이터 파일을 파일에 기록할때 출력 스트림
		FileOutputStream fos = new FileOutputStream(new File(fileName));
		
		// 불러온 데이터가 -1이 아니면 꼐속 반복해야 한다(-1 : End of file, 파일의 끝)
		while((b = is.read(buf, 0, 1024)) != -1) {
			// 이번 반복에 다운로드 받은 크기를 total에 더한다
			total += b;
			// 누적 바이트를 전체 크기와 계산하여 퍼센트를 구한다
			int rate = total * 100 / fileSize;
			// 다운받은 만큼의 파일에 기록한다 (write가 파일에 쓰는 역할을 한다)
			fos.write(buf, 0, b);
			// 그리고 출력
			System.out.printf("%d / %d(%d%%)\n", total, fileSize, rate);
		}
		fos.flush();
		fos.close();
		
	}
}
