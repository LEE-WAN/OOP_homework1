import java.util.Calendar;

import manager.ShelfManager;
import manager.UserManager;

public class Q2 {

	public static void main(String[] args) {
		
		//오늘의 날짜 초기화.
		ShelfManager.today = Calendar.getInstance();	
		ShelfManager.today.set(Calendar.HOUR_OF_DAY, 0);
		ShelfManager.today.set(Calendar.MINUTE, 0);
		ShelfManager.today.set(Calendar.SECOND, 0);
		ShelfManager.today.set(Calendar.MILLISECOND, 0);

		ShelfManager shelfMgr = new ShelfManager();
		UserManager userMgr = new UserManager();

		//저장된 shelf.bin 과 user.bin 을 불러옴
		System.out.println("도서정보를 불러옵니다.");
		shelfMgr = ShelfManager.load();
		if(shelfMgr == null){
			System.out.println("도서정보 불러오기에 실패했습니다. 초기화 합니다.");
			shelfMgr = new ShelfManager();			
		}		
		/*  유저정보를 불러오지 않습니다.
		System.out.println("유저정보를 불러옵니다.");
		userMgr = UserManager.load();			
		if(userMgr == null){
			System.out.println("유저정보 불러오기에 실패했습니다. 초기화 합니다.");
			userMgr = new UserManager();
		}*/
	

	
		ShelfManager.today.set(Calendar.YEAR, 2017);		
		ShelfManager.today.set(Calendar.MONTH, 4);		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 19);		

		userMgr.addUser("A");

		userMgr.rents("A", shelfMgr.getBook(0));	//만화책 도라에몽
		userMgr.rents("A", shelfMgr.getBook(1));	//만화책 도라에몽
		userMgr.rents("A", shelfMgr.getBook(2));	//만화책 도라에몽
		userMgr.rents("A", shelfMgr.getBook(12));	//소설책 야간비행
		userMgr.rents("A", shelfMgr.getBook(13));	//소설책 맥베스

		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 22);	//토요일
				
		//소설책 반납
		userMgr.returns("A", shelfMgr.getBook(12));
		userMgr.returns("A", shelfMgr.getBook(13));
		
		System.out.println("소설 반납하고 낸 금액: "+userMgr.getPayedMoney("A"));	//지금까지 A가 낸 총 금액 
		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 24);	//월요일

		//만화책 반납
		userMgr.returns("A", shelfMgr.getBook(0));
		userMgr.returns("A", shelfMgr.getBook(1));
		userMgr.returns("A", shelfMgr.getBook(2));
		
		System.out.println("모두 반납하고 낸 총액: "+userMgr.getPayedMoney("A"));	//지금까지 A가 낸 총 금액 
		
		userMgr.save();

	}

}
