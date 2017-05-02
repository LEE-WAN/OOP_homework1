/*
 * 	Q1	�Ҽ� 10��, ��ȭå 8��, ���� 3��
*/


import java.util.Calendar;
import book.Book;
import manager.ShelfManager;

public class Q1 {

	public static void main(String[] args) {		
		
		ShelfManager shelfMgr = new ShelfManager();

		//������ ��¥ �ʱ�ȭ.
		ShelfManager.today = Calendar.getInstance();	
		ShelfManager.today.set(Calendar.HOUR_OF_DAY, 0);
		ShelfManager.today.set(Calendar.MINUTE, 0);
		ShelfManager.today.set(Calendar.SECOND, 0);
		ShelfManager.today.set(Calendar.MILLISECOND, 0);

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

		shelfMgr.print();
		
		shelfMgr.save();
	}

}
