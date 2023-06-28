package socket;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception{
		
			Scanner sc = new Scanner(System.in);
			String target;
			String data;
		
			System.out.print("접속할 서버의 IP를 입력 : ");
			target = sc.nextLine();
		
			// 많은 서버 채널 중에 7777을 선택
			Socket so = new Socket(target, 7777);
			PrintWriter pw = new PrintWriter(so.getOutputStream());
		
			System.err.print("보낼 메세지 입력 : ");
			data = sc.nextLine();
		
			pw.write(data);
			pw.flush();
			pw.close();
			so.close();
		
			sc.close();
		
	}
}
