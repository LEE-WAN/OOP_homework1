import java.util.Calendar;
import java.util.Scanner;

import book.Book;
import manager.ShelfManager;
import manager.UserManager;

/**
 * @author 2016920036 이완해
 *
 */

public class main {
	public static void clearScreen() {  
		//구현 못함.
	}  
	public static void main(String[] args) {
		
		//오늘의 날짜 초기화.
		ShelfManager.today = Calendar.getInstance();	
		ShelfManager.today.set(Calendar.HOUR_OF_DAY, 0);
		ShelfManager.today.set(Calendar.MINUTE, 0);
		ShelfManager.today.set(Calendar.SECOND, 0);
		ShelfManager.today.set(Calendar.MILLISECOND, 0);
		
		ShelfManager shelfMgr = null;
		UserManager userMgr = null;
		
		try{
			//저장된 shelf.bin 과 user.bin 을 불러옴
			System.out.println("도서정보를 불러옵니다.");
			shelfMgr = ShelfManager.load();
			System.out.println("유저정보를 불러옵니다.");
			userMgr = UserManager.load();			
		}
		catch(Exception e){
			//못불러오면 그냥 초기화
			System.out.println("불러오기에 실패했습니다. 초기화 합니다.");
			shelfMgr = new ShelfManager();
			userMgr = new UserManager();
		}
				
		for(;;){
			Scanner sc = new Scanner(System.in);
			System.out.println("오늘의 날짜는 " + ShelfManager.today.getTime().toString());
			shelfMgr.print();
			userMgr.print();
			System.out.println("사용자 이름(아이디)를 입력해 주세요.");

			String userName = sc.nextLine();
			clearScreen();
			
			if(userName.equals("admin"))adminMenu(shelfMgr, userMgr, userName, sc);
			else if(userName.equals("save")){
				userMgr.save();
				shelfMgr.save();
			}
			else{
				if(!userMgr.addUser(userName)) System.out.println("돌아오신것을 환영합니다.");
				else System.out.println("새로 가입하신것을 환영합니다.");
				userMenu(shelfMgr, userMgr, userName, sc);
			}			
		}
	}

	static void adminMenu(ShelfManager shelfMgr, UserManager userMgr, String userName, Scanner sc){
		boolean getOutOfLoop = false;
		while(!getOutOfLoop){
			//구현 안됨
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("\t 1.책 추가하기");
			System.out.println("\t 2.책 삭제하기");
			System.out.println("\t 3.대출 현황 보기");
			System.out.println("\t 4.로그아웃");
			System.out.println("\t 0.내일로 가기");
			sc.next();
		}		
	}

	static void userMenu(ShelfManager shelfMgr, UserManager userMgr, String userName, Scanner sc){
		boolean getOutOfLoop = false;
		while(!getOutOfLoop){
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("\t 1.빌린 책 보기");
			System.out.println("\t 2.책 빌리기");
			System.out.println("\t 3.책 반납하기");
			System.out.println("\t 4.로그아웃");
			System.out.println("\t 0.내일로 가기");
			System.out.println("오늘 모든책 반납시 내야할 금액: " + userMgr.clacRentalFee(userName));
			System.out.println("여태까지 대여점에 내가 낸 금액: " + userMgr.getPayedMoney(userName));

			int num = sc.nextInt();
			clearScreen();

			int id =0;
			Book book = null;
			switch(num){
			case 0:
				ShelfManager.today.add(Calendar.DAY_OF_YEAR, 1);
				System.out.println("오늘의 날짜는 " + ShelfManager.today.getTime().toString());
				break;
			case 1:
				userMgr.print(userName);
				break;
			case 2:
				shelfMgr.print();
				System.out.print("빌리실 책의 id를 입력해주세요:");
				id = sc.nextInt();
				book = shelfMgr.getBook(id);
				if(userMgr.rents(userName, book)){
					System.out.println("책 대출에 성공하였습니다. \n");
					book.print();
				}
				else
					System.out.println("책 대출에 실패하였습니다.");
				break;
			case 3:
				userMgr.print(userName);
				System.out.print("반납하실 책의 id를 입력해주세요:");
				id = sc.nextInt();
				book = shelfMgr.getBook(id);
				if(userMgr.returns(userName, book)){
					System.out.println("책 반납에 성공하였습니다. \n");
					book.print();
				}
				else
					System.out.println("책 반납에 실패하였습니다.");
				break;
			case 4:
				getOutOfLoop = true;
				break;
			}
		}
	}

}
