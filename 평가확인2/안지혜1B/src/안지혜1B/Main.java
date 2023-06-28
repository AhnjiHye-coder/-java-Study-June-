package ������1B;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Handler handler = new Handler();
		Student[] arr = null;	// �޼��忡�� �Ѿ�� �迭 ��� ����
		Student tmp = null;		// �޼��忡�� �Ѿ�� ���� ��� ����
		
		// main���� ����� ����
		int menu;
		int row;
		String name = null;
		
		// ���� ������
		handler.Addstudent(new Common("����",60,85,97));
		handler.Addstudent(new Common("�Ѹ�",79,80,65));
//		handler.Addstudent(new Common("��ġ",67,98,94));
//		handler.Addstudent(new Common("������",96,84,87));
//		handler.Addstudent(new Second("�����",92,78,97,84));
		handler.Addstudent(new Second("¯��",93,87,77,71));
		handler.Addstudent(new Second("ö��",88,79,98,62));
		handler.Addstudent(new Second("�ͱ�",65,84,87,74));
//		handler.Addstudent(new Second("����",90,89,95,97));
//		handler.Addstudent(new Second("����",49,87,90,98));
		
		
		while(true) {
			System.out.println("\t�л��������α׷� (������ : �� �� ��)");
			System.out.println("1. �л��߰�");
			System.out.println("2. ��ü���");
			System.out.println("3. �л��˻�");
			System.out.println("4. �л�����");
			System.out.println("5. ��ճ������� ���");
			System.out.println("0. ����");
			System.out.print("�޴� ���� >>> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:	// �л� �߰�
				System.out.println("\t�л� �߰�");
				System.out.print("(1. �Ϲ� | 2. ��2�ܱ���) : ");
				menu = Integer.parseInt(sc.nextLine());
				
				if(menu == 1 ) 		tmp = Commonstudent(sc); // �Ϲ��϶�
				else if(menu == 2) 	tmp = Secondstudent(sc); // ��2�ܱ����϶�
				else				tmp = null;					
			
				row = handler.Addstudent(tmp);
				System.out.println(row != 0 ? "\n\t�л� �����͸� ���������� �߰��߽��ϴ�" : "\n\t�л� ������ �ٽ� �Է��ϼ���");
				break;
				
			case 2: // ��ü ���
				System.out.println("\t��ü ȸ�� ����");
				arr = handler.Arrstudent();
				
				for(int i = 0; i < arr.length; i++) {
				      if(arr[i] != null) {
				    	  System.out.println("��ȣ : "+i);
				         System.out.println(arr[i].toString2());
				      }
				   }
				break;
				
			case 3: // �˻�
				System.out.println("\t�̸����� �л��� �˻��մϴ�");
				System.out.print("�˻��� �̸� �Է� : ");
				name = sc.nextLine();
				
				arr = handler.Search(name);
				
				for(int i = 0; i < arr.length; i++) {
					Student s = arr[i];
					if( s != null) {
						System.out.println(s);
					}
				}
				break;
				
			case 4: // ����
				System.out.print("������ �л��� �̸� �Է� : ");
				name = sc.nextLine();
				
				arr = handler.Search(name);
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] != null) {
						System.out.println(arr[i]);
						System.out.print("���� �����Ͻðڽ��ϱ�? (y/n) :");
						String n = sc.nextLine();
						
						if(n.equals("n") || n.equals("N")) {		
							System.out.println("������ �л� ���� ������ �ߴ��մϴ�");	
						}
						else if(n.equals("y") || n.equals("Y")){ 
							row = handler.delete(name);			
							System.out.println("������ �л��� ������ �����մϴ�"); 
						}
						else {			
							System.out.println("�߸� �Է��ϼ̽��ϴ�");	
						}
					}
					else {		
						System.out.println("��ġ�ϴ� �л������� �����ϴ�");	
					}
				}
					
				break;
				
			case 5: // ����
				System.out.println("\t����������� �����Ͽ����ϴ�");
				arr = handler.sort();
				
				for(int i = 0; i < arr.length; i++) {
				      if(arr[i] != null) {
				         System.out.print((i+1) + ". " + arr[i].toString2());
				      }
				   }
				break;
				
			case 0:
				sc.close();
				System.err.println("���α׷��� �����մϴ�");
				return;
				
			default:	
				System.out.println("��ȣ�� �ٽ� �Է��ϼ���");
			}
			System.out.println();
		}
	}

	// ��2�ܱ���
	private static Student Secondstudent(Scanner sc) {
		
		String name;
		int c, java,spring,english;
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		name = sc.nextLine();
		
		System.out.print("C��� ���� : ");
		c = Integer.parseInt(sc.nextLine());
		
		System.out.print("java ���� �Է� : ");
		java = Integer.parseInt(sc.nextLine());
		
		System.out.print("spring ���� �Է� : ");
		spring = Integer.parseInt(sc.nextLine());
		
		System.out.print("�� 2�ܱ��� ���� �Է� : ");
		english = Integer.parseInt(sc.nextLine());
	
		Second seco = new Second(name, c, java, spring,english);
		
		return seco;
	}

	// �Ϲ�
	private static Student Commonstudent(Scanner sc) {
		
		String name;
		int c, java,spring;
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		name = sc.nextLine();
		
		System.out.print("C��� ���� : ");
		c = Integer.parseInt(sc.nextLine());
		
		System.out.print("java ���� : ");
		java = Integer.parseInt(sc.nextLine());
		
		System.out.print("spring ���� : ");
		spring = Integer.parseInt(sc.nextLine());
	
		Common comm = new Common(name, c, java, spring);
		
		return comm;
	}
}
