package ������A1;
//ȸ��
public abstract class Member {
	
	// ȸ���� �������� �⺻ ����
	String id;
	String password;
	String name;
	
	// �⺻ ������ �ʱ�ȭ
	public Member(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
		
	}
	
	// �߻�޼���
	@Override
	public abstract String toString();
	
	
	
}
