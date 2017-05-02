import java.util.Calendar;

import manager.ShelfManager;
import manager.UserManager;

public class Q3 {

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
		
		/*	유저정보를 불러오지 않습니다.
		System.out.println("유저정보를 불러옵니다.");
		userMgr = UserManager.load();			
		if(userMgr == null){
			System.out.println("유저정보 불러오기에 실패했습니다. 초기화 합니다.");
			userMgr = new UserManager();
		}*/

		
		ShelfManager.today.set(Calendar.YEAR, 2017);		
		ShelfManager.today.set(Calendar.MONTH, 4);		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 21);
				
		userMgr.addUser("B");

		userMgr.rents("B", shelfMgr.getBook(3));	//만화책 도라에몽
		userMgr.rents("B", shelfMgr.getBook(4));	//만화책 도라에몽
		userMgr.rents("B", shelfMgr.getBook(5));	//만화책 도라에몽
		userMgr.rents("B", shelfMgr.getBook(6));	//만화책 도라에몽
		userMgr.rents("B", shelfMgr.getBook(8));	//잡지
		userMgr.rents("B", shelfMgr.getBook(9));	//잡지

		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 23);	//일요일
		
		userMgr.returns("B", shelfMgr.getBook(3));	//만화책 도라에몽
		userMgr.returns("B", shelfMgr.getBook(4));	//만화책 도라에몽
		userMgr.returns("B", shelfMgr.getBook(5));	//만화책 도라에몽
		userMgr.returns("B", shelfMgr.getBook(6));	//만화책 도라에몽

		System.out.println("만화 반납하고 낸 금액: "+userMgr.getPayedMoney("B"));	//지금까지 B가 낸 총 금액 

		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 28);	//그 다음주 금요일

		userMgr.returns("B", shelfMgr.getBook(8));	//잡지
		userMgr.returns("B", shelfMgr.getBook(9));	//잡지

		System.out.println("모두 반납하고 낸 총액: "+userMgr.getPayedMoney("B"));	//지금까지 B가 낸 총 금액 

		userMgr.save();

	}

}
