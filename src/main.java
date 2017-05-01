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
		
		userMgr.rents("A", shelfMgr.getBook(0));
		userMgr.rents("A", shelfMgr.getBook(1));
		userMgr.rents("A", shelfMgr.getBook(2));
		userMgr.rents("A", shelfMgr.getBook(3));
		userMgr.rents("A", shelfMgr.getBook(4));
		userMgr.rents("A", shelfMgr.getBook(5));
		
		for(;;){
			Scanner sc = new Scanner(System.in);
			System.out.println("������ ��¥�� " + ShelfManager.today.getTime().toString());
			shelfMgr.print();
			userMgr.print();
			System.out.println("����� �̸�(���̵�)�� �Է��� �ּ���.");
			String userName = sc.nextLine();
			if(!userMgr.addUser(userName)) System.out.println("���ƿ��Ű��� ȯ���մϴ�.");
			else System.out.println("���� �����ϽŰ��� ȯ���մϴ�.");
			for(;;){
				System.out.println("������ �Ͻðڽ��ϱ�?");
				System.out.println("\t 1.���� å ����");
				System.out.println("\t 2.å ������");
				System.out.println("\t 3.å �ݳ��ϱ�");
				System.out.println("\t 4.�α׾ƿ�");
				System.out.println("\t 0.���Ϸ� ����");
				System.out.println("���� ���å �ݳ��� ������ �ݾ�: " + userMgr.clacRentalFee(userName));
				int num = sc.nextInt();
			}
		}
		/*
		userMgr.addUser("A");
		userMgr.addUser("B");
		userMgr.save();

		
		
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
		
		shelfMgr.save();
		*/
	}

}
