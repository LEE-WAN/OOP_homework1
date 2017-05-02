import java.util.Calendar;

import manager.ShelfManager;
import manager.UserManager;

public class Q2 {

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
		/*  ���������� �ҷ����� �ʽ��ϴ�.
		System.out.println("���������� �ҷ��ɴϴ�.");
		userMgr = UserManager.load();			
		if(userMgr == null){
			System.out.println("�������� �ҷ����⿡ �����߽��ϴ�. �ʱ�ȭ �մϴ�.");
			userMgr = new UserManager();
		}*/
	

	
		ShelfManager.today.set(Calendar.YEAR, 2017);		
		ShelfManager.today.set(Calendar.MONTH, 4);		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 19);		

		userMgr.addUser("A");

		userMgr.rents("A", shelfMgr.getBook(0));	//��ȭå ���󿡸�
		userMgr.rents("A", shelfMgr.getBook(1));	//��ȭå ���󿡸�
		userMgr.rents("A", shelfMgr.getBook(2));	//��ȭå ���󿡸�
		userMgr.rents("A", shelfMgr.getBook(12));	//�Ҽ�å �߰�����
		userMgr.rents("A", shelfMgr.getBook(13));	//�Ҽ�å �ƺ���

		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 22);	//�����
				
		//�Ҽ�å �ݳ�
		userMgr.returns("A", shelfMgr.getBook(12));
		userMgr.returns("A", shelfMgr.getBook(13));
		
		System.out.println("�Ҽ� �ݳ��ϰ� �� �ݾ�: "+userMgr.getPayedMoney("A"));	//���ݱ��� A�� �� �� �ݾ� 
		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 24);	//������

		//��ȭå �ݳ�
		userMgr.returns("A", shelfMgr.getBook(0));
		userMgr.returns("A", shelfMgr.getBook(1));
		userMgr.returns("A", shelfMgr.getBook(2));
		
		System.out.println("��� �ݳ��ϰ� �� �Ѿ�: "+userMgr.getPayedMoney("A"));	//���ݱ��� A�� �� �� �ݾ� 
		
		userMgr.save();

	}

}
