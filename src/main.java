import java.util.Calendar;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import book.Book;
import manager.ShelfManager;
import manager.UserManager;
import user.User;

/**
 * @author 2016920036 �̿���
 *
 */
public class main {
	public static void main(String[] args) {
		ShelfManager shelfMgr = new ShelfManager();
		UserManager userMgr = new UserManager();
		
		shelfMgr = ShelfManager.load();
		userMgr = UserManager.load();
		
		//userMgr.addUser("A");
		//userMgr.addUser("B");
		//userMgr.save();
		
		for(;;){
			Scanner sc = new Scanner(System.in);
			System.out.println("������ ��¥�� " + ShelfManager.today.getTime().toString());
			
			sc.next();
		}

		
		/*
		mgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 1", "������F������");
		mgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 2", "������F������");
		mgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 3", "������F������");
		mgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 4", "������F������");
		mgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 5", "������F������");
		mgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 6", "������F������");
		mgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 7", "������F������");
		mgr.addBook(Book.BookType.Comic, "���󿡸� ����ø��� 8", "������F������");

		mgr.addBook(Book.BookType.Magazine, "PC��� 2007�� 8��ȣ", "��ǻ�ͻ�Ȱ");
		mgr.addBook(Book.BookType.Magazine, "PC��� 2007�� 9��ȣ", "��ǻ�ͻ�Ȱ");
		mgr.addBook(Book.BookType.Magazine, "PC��� 2007�� 10��ȣ", "��ǻ�ͻ�Ȱ");
		
		mgr.addBook(Book.BookType.Novel, "1984", "����.����");
		mgr.addBook(Book.BookType.Novel, "����� �������� ��°�", "���� �罺����");
		mgr.addBook(Book.BookType.Novel, "�߰� ����", "�������丮");
		mgr.addBook(Book.BookType.Novel, "�ƺ���", "������ ���ͽ��Ǿ�");
		mgr.addBook(Book.BookType.Novel, "�̹���", "�˺��� ī��");
		mgr.addBook(Book.BookType.Novel, "�ູ�� ����", "�˺��� ī��");
		mgr.addBook(Book.BookType.Novel, "������ �ձ�", "�˺��� ī��");
		mgr.addBook(Book.BookType.Novel, "�� ���� ����", "���� �罺����");
		mgr.addBook(Book.BookType.Novel, "���ڹ� ��ư�� �ð��� �Ųٷ� ����", "���� ����������");
		
		mgr.save();
		*/
	}

}
