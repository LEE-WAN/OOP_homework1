import java.util.Calendar;

import manager.ShelfManager;
import manager.UserManager;

public class Q3 {

	public static void main(String[] args) {
		
		//������ ��¥ �ʱ�ȭ.
		ShelfManager.today = Calendar.getInstance();	
		ShelfManager.today.set(Calendar.HOUR_OF_DAY, 0);
		ShelfManager.today.set(Calendar.MINUTE, 0);
		ShelfManager.today.set(Calendar.SECOND, 0);
		ShelfManager.today.set(Calendar.MILLISECOND, 0);

		
		ShelfManager shelfMgr = new ShelfManager();
		UserManager userMgr = new UserManager();

		//����� shelf.bin �� user.bin �� �ҷ���
		System.out.println("���������� �ҷ��ɴϴ�.");
		shelfMgr = ShelfManager.load();
		if(shelfMgr == null){
			System.out.println("�������� �ҷ����⿡ �����߽��ϴ�. �ʱ�ȭ �մϴ�.");
			shelfMgr = new ShelfManager();			
		}		
		
		/*	���������� �ҷ����� �ʽ��ϴ�.
		System.out.println("���������� �ҷ��ɴϴ�.");
		userMgr = UserManager.load();			
		if(userMgr == null){
			System.out.println("�������� �ҷ����⿡ �����߽��ϴ�. �ʱ�ȭ �մϴ�.");
			userMgr = new UserManager();
		}*/

		
		ShelfManager.today.set(Calendar.YEAR, 2017);		
		ShelfManager.today.set(Calendar.MONTH, 4);		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 21);
				
		userMgr.addUser("B");

		userMgr.rents("B", shelfMgr.getBook(3));	//��ȭå ���󿡸�
		userMgr.rents("B", shelfMgr.getBook(4));	//��ȭå ���󿡸�
		userMgr.rents("B", shelfMgr.getBook(5));	//��ȭå ���󿡸�
		userMgr.rents("B", shelfMgr.getBook(6));	//��ȭå ���󿡸�
		userMgr.rents("B", shelfMgr.getBook(8));	//����
		userMgr.rents("B", shelfMgr.getBook(9));	//����

		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 23);	//�Ͽ���
		
		userMgr.returns("B", shelfMgr.getBook(3));	//��ȭå ���󿡸�
		userMgr.returns("B", shelfMgr.getBook(4));	//��ȭå ���󿡸�
		userMgr.returns("B", shelfMgr.getBook(5));	//��ȭå ���󿡸�
		userMgr.returns("B", shelfMgr.getBook(6));	//��ȭå ���󿡸�

		System.out.println("��ȭ �ݳ��ϰ� �� �ݾ�: "+userMgr.getPayedMoney("B"));	//���ݱ��� B�� �� �� �ݾ� 

		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 28);	//�� ������ �ݿ���

		userMgr.returns("B", shelfMgr.getBook(8));	//����
		userMgr.returns("B", shelfMgr.getBook(9));	//����

		System.out.println("��� �ݳ��ϰ� �� �Ѿ�: "+userMgr.getPayedMoney("B"));	//���ݱ��� B�� �� �� �ݾ� 

		userMgr.save();

	}

}
