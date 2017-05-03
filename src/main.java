import java.util.Calendar;
import java.util.Scanner;

import book.Book;
import manager.ShelfManager;
import manager.UserManager;

/**
 * @author 2016920036 �̿���
 *
 */

public class main {
	public static void clearScreen() {  
		//���� ����.
	}  
	public static void main(String[] args) {
		
		//������ ��¥ �ʱ�ȭ.
		ShelfManager.today = Calendar.getInstance();	
		ShelfManager.today.set(Calendar.HOUR_OF_DAY, 0);
		ShelfManager.today.set(Calendar.MINUTE, 0);
		ShelfManager.today.set(Calendar.SECOND, 0);
		ShelfManager.today.set(Calendar.MILLISECOND, 0);
		
		ShelfManager shelfMgr = null;
		UserManager userMgr = null;
		
		try{
			//����� shelf.bin �� user.bin �� �ҷ���
			System.out.println("���������� �ҷ��ɴϴ�.");
			shelfMgr = ShelfManager.load();
			System.out.println("���������� �ҷ��ɴϴ�.");
			userMgr = UserManager.load();			
		}
		catch(Exception e){
			//���ҷ����� �׳� �ʱ�ȭ
			System.out.println("�ҷ����⿡ �����߽��ϴ�. �ʱ�ȭ �մϴ�.");
			shelfMgr = new ShelfManager();
			userMgr = new UserManager();
		}
				
		for(;;){
			Scanner sc = new Scanner(System.in);
			System.out.println("������ ��¥�� " + ShelfManager.today.getTime().toString());
			shelfMgr.print();
			userMgr.print();
			System.out.println("����� �̸�(���̵�)�� �Է��� �ּ���.");

			String userName = sc.nextLine();
			clearScreen();
			
			if(userName.equals("admin"))adminMenu(shelfMgr, userMgr, userName, sc);
			else if(userName.equals("save")){
				userMgr.save();
				shelfMgr.save();
			}
			else{
				if(!userMgr.addUser(userName)) System.out.println("���ƿ��Ű��� ȯ���մϴ�.");
				else System.out.println("���� �����ϽŰ��� ȯ���մϴ�.");
				userMenu(shelfMgr, userMgr, userName, sc);
			}			
		}
	}

	static void adminMenu(ShelfManager shelfMgr, UserManager userMgr, String userName, Scanner sc){
		boolean getOutOfLoop = false;
		while(!getOutOfLoop){
			//���� �ȵ�
			System.out.println("������ �Ͻðڽ��ϱ�?");
			System.out.println("\t 1.å �߰��ϱ�");
			System.out.println("\t 2.å �����ϱ�");
			System.out.println("\t 3.���� ��Ȳ ����");
			System.out.println("\t 4.�α׾ƿ�");
			System.out.println("\t 0.���Ϸ� ����");
			sc.next();
		}		
	}

	static void userMenu(ShelfManager shelfMgr, UserManager userMgr, String userName, Scanner sc){
		boolean getOutOfLoop = false;
		while(!getOutOfLoop){
			System.out.println("������ �Ͻðڽ��ϱ�?");
			System.out.println("\t 1.���� å ����");
			System.out.println("\t 2.å ������");
			System.out.println("\t 3.å �ݳ��ϱ�");
			System.out.println("\t 4.�α׾ƿ�");
			System.out.println("\t 0.���Ϸ� ����");
			System.out.println("���� ���å �ݳ��� ������ �ݾ�: " + userMgr.clacRentalFee(userName));
			System.out.println("���±��� �뿩���� ���� �� �ݾ�: " + userMgr.getPayedMoney(userName));

			int num = sc.nextInt();
			clearScreen();

			int id =0;
			Book book = null;
			switch(num){
			case 0:
				ShelfManager.today.add(Calendar.DAY_OF_YEAR, 1);
				System.out.println("������ ��¥�� " + ShelfManager.today.getTime().toString());
				break;
			case 1:
				userMgr.print(userName);
				break;
			case 2:
				shelfMgr.print();
				System.out.print("������ å�� id�� �Է����ּ���:");
				id = sc.nextInt();
				book = shelfMgr.getBook(id);
				if(userMgr.rents(userName, book)){
					System.out.println("å ���⿡ �����Ͽ����ϴ�. \n");
					book.print();
				}
				else
					System.out.println("å ���⿡ �����Ͽ����ϴ�.");
				break;
			case 3:
				userMgr.print(userName);
				System.out.print("�ݳ��Ͻ� å�� id�� �Է����ּ���:");
				id = sc.nextInt();
				book = shelfMgr.getBook(id);
				if(userMgr.returns(userName, book)){
					System.out.println("å �ݳ��� �����Ͽ����ϴ�. \n");
					book.print();
				}
				else
					System.out.println("å �ݳ��� �����Ͽ����ϴ�.");
				break;
			case 4:
				getOutOfLoop = true;
				break;
			}
		}
	}

}
