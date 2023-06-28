package day21;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Handler {

	private ArrayList<PhoneBookInfo> list = new ArrayList<>();
	private final String fileName = "phonebook.txt"; // 파일 이름
			
	
//	// 저장 while이 종료 되고 나서도 남아있는 데이터 구현
//	public void save() throws Exception {
//		// 리스트에 저장된 것을 파일에 저장한다
//		// 1) 파일을 대상으로 하는 출력 통로는 개설해야 한다
//		// 파일 타입의 객체를 만들고, 파일로 정보가 들어갈 수 있는 빨대를 꼽아준다
//		// 빨대 : fileWriter
//		File f = new File(fileName);
//		boolean append = false;
//		FileWriter fw = new FileWriter(f,append);
//			
//		// 2) FileWriter로 문자열을 File에 기록해야 한다
//		// 어떤 것에 대해 기록할 것인지 대상을 정한다
//		// 지금은 list에 있는 것을 파일에 넣어줘야 한다
//		for(PhoneBookInfo s : list) {
//			// 이렇게 각각 넣어줘도 되지만 toString으로 넣어도 된다
//			// 왜냐하면 PhoneBookInfo 클래스에
//			// toString이 오버라이딩 되어있기 때문이다
////			fw.append(s.getName() + (", "));
////			fw.append(s.getAge() + (", "));
////			fw.append(s.getPnum() + ("\n"));
//			fw.append(s.toString() + "\n");
//		}
//			
//		fw.flush();
//		fw.close();
//	}
		
		
	// 추가
	public int save(String name, int age, String pnum) throws Exception {
		int row = 0;
		// 파일에 정보를 추가해야 하기 때문에 대상인 파일을 개설하자
		File f = new File(fileName); 
		
		if(f.exists() == false) { // 파일이 없으면
			f.createNewFile();	// 저장한 이름대로 createNewFile함수로 파일 생성
		}
		list.add(new PhoneBookInfo(name,age,pnum)); // 생성한 후에는 정보를 바로 넣어준다
		
		// 파일이 있는 상태라면 그 파일에 기록할 단계이다
		FileWriter fw = new FileWriter(f); // 대상 파일을 기록하는 기능을 가진 FileWriter함수에 연결
		for(int i = 0; i < list.size(); i++) {
			// 통로역할인 파일에 리스트의 i(name,age,pnum)을 toString을 사용해서 리스트에 맞는
			// 문자열로 변환한 뒤 list에 추가
			// toString은 어떤 객체든 문자열로 변환하여 반환해준다
			fw.append(list.get(i).toString() + "\n");
		}
		fw.flush(); // 공간을 비워주고
		row++;
		
		fw.close();	// 공간을 닫아준다
		return row;
	}

	// 전체 목록
	public void selectAll() {
		for(PhoneBookInfo s : list) {
			System.out.println(s.toString());
		}
	}

	// 불러오기
	public void load() throws Exception {
		File f = new File(fileName);
		
		if(f.exists() == false) {
			f.createNewFile();
			return;
		}
		
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			// 입력 받은 것을
			String line = sc.nextLine();
			// index로 구분하는데 자료형에 맞게 각 변수에 넣는다
			String name = line.split(", ")[0];
			// int의 경우 integer 형태로 넣고 문자를 잘라야 한다
			// Integer의 역할은 문자를 int형태로 바꿔주기 때문에 사용한다
			int age = Integer.parseInt(line.split(", ")[1]);
			String pnum = line.split("\n")[2];
			
			list.add(new PhoneBookInfo(name, age, pnum));
		}
		sc.close();
		
	}

	// 검색
	public void search(String keyword) throws Exception {
		File f = new File(fileName);
		Scanner sc = new Scanner(f);
		ArrayList<PhoneBookInfo> list2 = new ArrayList<>();
		
		// 다음 줄이 있으면
		while(sc.hasNextLine()) {
			// 정보(name, age, pnum)을 s에 넣고
			String s = sc.nextLine();
			if(s.contains(keyword)) {// s와 내가 검색한 정보가 일치하면
				// 리스트에서 이름,나이,번호를 나눠서 검색결과로 반환할 list2에 넣어준다
				list2.add(new PhoneBookInfo(s.split(", ")[0], 
						Integer.parseInt(s.split(", ")[1]),s.split(", ")[2]));
			}
		}
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		sc.close();
		
	}

	
	
	// 삭제
	public int delete(String pnum) throws Exception {
		int row = 0;
		File f = new File(fileName);
		Scanner sc = new Scanner(f);
		
		// 다음 줄이 있으면 반복문 실행
		while(sc.hasNextLine()) { // 즉, 파일에 문자열이 있으면 실행
			String s = sc.nextLine(); // s에 먼저 있는 문자를 담아주면서 차례대로 비교, 반복
			// s에 담겨있는 문자열 중 index[2]에 값을 phonnum애 담고
			String phonnum = s.split(", ")[2]; 
			
			// 자른 pnum랑 File의 index[2]가 포함되있으면
			if(phonnum.equals(pnum)) {
				// list에 File의 index[2]를 추가하고
				for(int i = 0; i < list.size(); i++) {
					// 추가 할때는 파일의 contains를 사용해서 해당 문자열에 지정한 문자가 포함되어있으면
					// toString을 통해서 list의 형식대로 get(i)로 담아준다
					if(list.get(i).toString().contains(pnum)) {
						// 그리고 list에 들어간 문자는 remove를 통해서 삭제한다
						list.remove(i);
						break;
					}
				}
				
				// 그리고 파일 통로를 이용하여
				FileWriter fw = new FileWriter(f);
				// 리스트의 배열에서
				for(int i = 0; i < list.size(); i++) {
					// 리스트 i의 정보 하나씩 파일에 새로 넣어주고 "\n"한칸씩 내린다
					// 공간 정리
					fw.append(list.get(i).toString() + "\n");
				}
				// 작업이 끝났다면 파일 통로를 비워주고
				fw.flush();
				// 로우 증가
				row++;
				// 통로 닫아주고
				fw.close();
				// 함수 종료
				break;
			}
		}
		// 스캐너 종료
		sc.close();
		// 리컨 로우 해주면서 메인에 성공,실패 값 전달
		return row;
	}
	
	

}
