package ������A1;
//�Ǹ���
public class Seller extends Member{
	
	// �����̸��� �Է� ���� �ʵ�
	String storeName;  
	
	public Seller(String id, String password, String name, String storeName) {
		super(id,password, name);
		this.storeName = storeName;
		
	}

	@Override
	public String toString() {
		System.out.println("[�Ǹ��� ����]");
		String format = "ID : %s\n"
				+ "PW : ********\n"
				+ "�̸� : %s ��\n"
				+ "���� �̸� : %s\n";
		Object[] args = {id, password, name, storeName};
		return String.format(format, args);
	}
}
