import java.util.Calendar;

import book.Book;
import manager.ShelfManager;
import manager.UserManager;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����������
		ShelfManager shelfMgr = new ShelfManager();
		
		//����������
		UserManager userMgr = new UserManager();

		//������ ��¥ �ʱ�ȭ.
		ShelfManager.today = Calendar.getInstance();	
		ShelfManager.today.set(Calendar.HOUR_OF_DAY, 0);
		ShelfManager.today.set(Calendar.MINUTE, 0);
		ShelfManager.today.set(Calendar.SECOND, 0);
		ShelfManager.today.set(Calendar.MILLISECOND, 0);

		
		//Q1 ���� �߰�
		System.out.println();
		System.out.println("###################################################");
		System.out.println("#                     Q1                          #");
		System.out.println("###################################################");
		System.out.println();

		shelfMgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 1", "������F������");
		shelfMgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 2", "������F������");
		shelfMgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 3", "������F������");
		shelfMgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 4", "������F������");
		shelfMgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 5", "������F������");
		shelfMgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 6", "������F������");
		shelfMgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 7", "������F������");
		shelfMgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 8", "������F������");

		shelfMgr.addBook(Book.BookType.Magazine, "PC��� 2007�� 8��ȣ", "��ǻ�ͻ�Ȱ");
		shelfMgr.addBook(Book.BookType.Magazine, "PC��� 2007�� 9��ȣ", "��ǻ�ͻ�Ȱ");
		shelfMgr.addBook(Book.BookType.Magazine, "PC��� 2007�� 10��ȣ", "��ǻ�ͻ�Ȱ");
		
		shelfMgr.addBook(Book.BookType.Novel, "1984", "����.����");
		shelfMgr.addBook(Book.BookType.Novel, "����� �������� ��°�", "���� �罺����");
		shelfMgr.addBook(Book.BookType.Novel, "�߰� ����", "�������丮");
		shelfMgr.addBook(Book.BookType.Novel, "�ƺ���", "������ ���ͽ��Ǿ�");
		shelfMgr.addBook(Book.BookType.Novel, "�̹���", "�˺��� ī��");
		shelfMgr.addBook(Book.BookType.Novel, "�ູ�� ����", "�˺��� ī��");
		shelfMgr.addBook(Book.BookType.Novel, "������ �ձ�", "�˺��� ī��");
		shelfMgr.addBook(Book.BookType.Novel, "�� ���� ����", "���� �罺����");
		shelfMgr.addBook(Book.BookType.Novel, "���ڹ� ��ư�� �ð��� �Ųٷ� ����", "���� ����������");
		shelfMgr.addBook(Book.BookType.Novel, "����̾� �Ϸ����� ���(��)", "Nagaru TANIGAWA");

		//�������� �� ���
		shelfMgr.print();

		//�������� ���� ��Ŀ� �°� ���
		shelfMgr.simplePrint();

		
		//shelf.bin���� ����
		shelfMgr.save();
		//�ҷ������
		//		shelfMgr = ShelfManager.load();
		//�����ϸ� null �� ��ȯ

		
		//Q2
		System.out.println();
		System.out.println("###################################################");
		System.out.println("#                   Q2,3                          #");
		System.out.println("###################################################");
		System.out.println();

		//2017�� 4�� 19��
		ShelfManager.today.set(Calendar.YEAR, 2017);		
		ShelfManager.today.set(Calendar.MONTH, Calendar.APRIL);		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 19);		

		//user A, B �߰�
		userMgr.addUser("A");
		userMgr.addUser("B");
		
		userMgr.rents("A", shelfMgr.getBook(0));	//��ȭå ���󿡸�
		userMgr.rents("A", shelfMgr.getBook(1));	//��ȭå ���󿡸�
		userMgr.rents("A", shelfMgr.getBook(2));	//��ȭå ���󿡸�
		userMgr.rents("A", shelfMgr.getBook(12));	//�Ҽ�å �߰�����
		userMgr.rents("A", shelfMgr.getBook(13));	//�Ҽ�å �ƺ���

		System.out.println("���� A�� ��ȭå 3�ǰ� �Ҽ�å 2���� �뿩�߽��ϴ�.");
		//�������� ���� ��Ŀ� �°� ���
		shelfMgr.simplePrint();
		//������Ȳ ���
		userMgr.print();
		System.out.println();

		//2017�� 4�� 21��
		ShelfManager.today.set(Calendar.YEAR, 2017);		
		ShelfManager.today.set(Calendar.MONTH, Calendar.APRIL);		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 21);
		
		userMgr.rents("B", shelfMgr.getBook(3));	//��ȭå ���󿡸�
		userMgr.rents("B", shelfMgr.getBook(4));	//��ȭå ���󿡸�
		userMgr.rents("B", shelfMgr.getBook(5));	//��ȭå ���󿡸�
		userMgr.rents("B", shelfMgr.getBook(6));	//��ȭå ���󿡸�
		userMgr.rents("B", shelfMgr.getBook(8));	//����
		userMgr.rents("B", shelfMgr.getBook(9));	//����
		
		System.out.println("���� B�� ��ȭå 4�ǰ� ���� 2���� �뿩�߽��ϴ�.");
		//�������� ���� ��Ŀ� �°� ���
		shelfMgr.simplePrint();
		//���� B�� ������Ȳ ���
		userMgr.print();
		System.out.println();


		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 22);	//�����
				
		//�Ҽ�å �ݳ�
		userMgr.returns("A", shelfMgr.getBook(12));
		userMgr.returns("A", shelfMgr.getBook(13));

		System.out.println("���� A�� �Ҽ�å 2���� �ݳ��߽��ϴ�.");
		//�������� ���� ��Ŀ� �°� ���
		shelfMgr.simplePrint();
		//������Ȳ ���
		userMgr.print();

		System.out.println("�Ҽ� �ݳ��ϰ� �� �ݾ�: "+userMgr.getPayedMoney("A"));	//���ݱ��� A�� �� �� �ݾ� 

		System.out.println();


		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 23);	//�Ͽ���
		
		userMgr.returns("B", shelfMgr.getBook(3));	//��ȭå ���󿡸�
		userMgr.returns("B", shelfMgr.getBook(4));	//��ȭå ���󿡸�
		userMgr.returns("B", shelfMgr.getBook(5));	//��ȭå ���󿡸�
		userMgr.returns("B", shelfMgr.getBook(6));	//��ȭå ���󿡸�
		
		System.out.println("���� B�� ��ȭå 4���� �ݳ��߽��ϴ�.");
		//�������� ���� ��Ŀ� �°� ���
		shelfMgr.simplePrint();
		//������Ȳ ���
		userMgr.print();
		System.out.println("��ȭ �ݳ��ϰ� �� �ݾ�: "+userMgr.getPayedMoney("B"));	//���ݱ��� B�� �� �� �ݾ� 

		
		System.out.println();


		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 24);	//������

		//��ȭå �ݳ�
		userMgr.returns("A", shelfMgr.getBook(0));
		userMgr.returns("A", shelfMgr.getBook(1));
		userMgr.returns("A", shelfMgr.getBook(2));

		System.out.println("����A�� ��ȭå3���� �ݳ��߽��ϴ�.");
		//�������� ���� ��Ŀ� �°� ���
		shelfMgr.simplePrint();
		//������Ȳ ���
		userMgr.print();

		System.out.println("A�� ��� �ݳ��ϰ� �� �Ѿ�: "+userMgr.getPayedMoney("A"));	//���ݱ��� A�� �� �� �ݾ� 

		System.out.println();
		
		//user.bin ���� ����
		userMgr.save();
	
		
		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 28);	//�� ������ �ݿ���
		
		userMgr.returns("B", shelfMgr.getBook(8));	//����
		userMgr.returns("B", shelfMgr.getBook(9));	//����

		System.out.println("���� B�� ���� 2���� �ݳ��߽��ϴ�.");
		//�������� ���� ��Ŀ� �°� ���
		shelfMgr.simplePrint();
		//������Ȳ ���
		userMgr.print();
		System.out.println("B�� ��� �ݳ��ϰ� �� �Ѿ�: "+userMgr.getPayedMoney("B"));	//���ݱ��� B�� �� �� �ݾ� 
		System.out.println();
		
		userMgr.save();
	}

}
