import java.util.Calendar;

import book.Book;
import manager.ShelfManager;
import manager.UserManager;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 도서관리자
		ShelfManager shelfMgr = new ShelfManager();
		
		//유저관리자
		UserManager userMgr = new UserManager();

		//오늘의 날짜 초기화.
		ShelfManager.today = Calendar.getInstance();	
		ShelfManager.today.set(Calendar.HOUR_OF_DAY, 0);
		ShelfManager.today.set(Calendar.MINUTE, 0);
		ShelfManager.today.set(Calendar.SECOND, 0);
		ShelfManager.today.set(Calendar.MILLISECOND, 0);

		
		//Q1 도서 추가
		System.out.println();
		System.out.println("###################################################");
		System.out.println("#                     Q1                          #");
		System.out.println("###################################################");
		System.out.println();

		shelfMgr.addBook(Book.BookType.Comic, "도라에몽 장편시리즈 1", "후지코F후지오");
		shelfMgr.addBook(Book.BookType.Comic, "도라에몽 장편시리즈 2", "후지코F후지오");
		shelfMgr.addBook(Book.BookType.Comic, "도라에몽 장편시리즈 3", "후지코F후지오");
		shelfMgr.addBook(Book.BookType.Comic, "도라에몽 장편시리즈 4", "후지코F후지오");
		shelfMgr.addBook(Book.BookType.Comic, "도라에몽 장편시리즈 5", "후지코F후지오");
		shelfMgr.addBook(Book.BookType.Comic, "도라에몽 장편시리즈 6", "후지코F후지오");
		shelfMgr.addBook(Book.BookType.Comic, "도라에몽 장편시리즈 7", "후지코F후지오");
		shelfMgr.addBook(Book.BookType.Comic, "도라에몽 장편시리즈 8", "후지코F후지오");

		shelfMgr.addBook(Book.BookType.Magazine, "PC사랑 2007년 8월호", "컴퓨터생활");
		shelfMgr.addBook(Book.BookType.Magazine, "PC사랑 2007년 9월호", "컴퓨터생활");
		shelfMgr.addBook(Book.BookType.Magazine, "PC사랑 2007년 10월호", "컴퓨터생활");
		
		shelfMgr.addBook(Book.BookType.Novel, "1984", "조지.오웰");
		shelfMgr.addBook(Book.BookType.Novel, "사람은 무엇으로 사는가", "레프 톨스토이");
		shelfMgr.addBook(Book.BookType.Novel, "야간 비행", "생택쥐페리");
		shelfMgr.addBook(Book.BookType.Novel, "맥베스", "윌리엄 셰익스피어");
		shelfMgr.addBook(Book.BookType.Novel, "이방인", "알베르 카뮈");
		shelfMgr.addBook(Book.BookType.Novel, "행복한 죽음", "알베르 카뮈");
		shelfMgr.addBook(Book.BookType.Novel, "유형과 왕국", "알베르 카뮈");
		shelfMgr.addBook(Book.BookType.Novel, "세 가지 질문", "레프 톨스토이");
		shelfMgr.addBook(Book.BookType.Novel, "벤자민 버튼의 시간은 거꾸로 간다", "스콧 피츠제럴드");
		shelfMgr.addBook(Book.BookType.Novel, "스즈미야 하루히의 경악(전)", "Nagaru TANIGAWA");

		//도서상태 상세 출력
		shelfMgr.print();

		//도서상태 과제 양식에 맞게 출력
		shelfMgr.simplePrint();

		
		//shelf.bin으로 저장
		shelfMgr.save();
		//불러오기는
		//		shelfMgr = ShelfManager.load();
		//실패하면 null 값 반환

		
		//Q2
		System.out.println();
		System.out.println("###################################################");
		System.out.println("#                   Q2,3                          #");
		System.out.println("###################################################");
		System.out.println();

		//2017년 4월 19일
		ShelfManager.today.set(Calendar.YEAR, 2017);		
		ShelfManager.today.set(Calendar.MONTH, Calendar.APRIL);		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 19);		

		//user A, B 추가
		userMgr.addUser("A");
		userMgr.addUser("B");
		
		userMgr.rents("A", shelfMgr.getBook(0));	//만화책 도라에몽
		userMgr.rents("A", shelfMgr.getBook(1));	//만화책 도라에몽
		userMgr.rents("A", shelfMgr.getBook(2));	//만화책 도라에몽
		userMgr.rents("A", shelfMgr.getBook(12));	//소설책 야간비행
		userMgr.rents("A", shelfMgr.getBook(13));	//소설책 맥베스

		System.out.println("유저 A가 만화책 3권과 소설책 2권을 대여했습니다.");
		//도서상태 과제 양식에 맞게 출력
		shelfMgr.simplePrint();
		//대출현황 출력
		userMgr.print();
		System.out.println();

		//2017년 4월 21일
		ShelfManager.today.set(Calendar.YEAR, 2017);		
		ShelfManager.today.set(Calendar.MONTH, Calendar.APRIL);		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 21);
		
		userMgr.rents("B", shelfMgr.getBook(3));	//만화책 도라에몽
		userMgr.rents("B", shelfMgr.getBook(4));	//만화책 도라에몽
		userMgr.rents("B", shelfMgr.getBook(5));	//만화책 도라에몽
		userMgr.rents("B", shelfMgr.getBook(6));	//만화책 도라에몽
		userMgr.rents("B", shelfMgr.getBook(8));	//잡지
		userMgr.rents("B", shelfMgr.getBook(9));	//잡지
		
		System.out.println("유저 B가 만화책 4권과 잡지 2권을 대여했습니다.");
		//도서상태 과제 양식에 맞게 출력
		shelfMgr.simplePrint();
		//유저 B의 대출현황 출력
		userMgr.print();
		System.out.println();


		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 22);	//토요일
				
		//소설책 반납
		userMgr.returns("A", shelfMgr.getBook(12));
		userMgr.returns("A", shelfMgr.getBook(13));

		System.out.println("유저 A가 소설책 2권을 반납했습니다.");
		//도서상태 과제 양식에 맞게 출력
		shelfMgr.simplePrint();
		//대출현황 출력
		userMgr.print();

		System.out.println("소설 반납하고 낸 금액: "+userMgr.getPayedMoney("A"));	//지금까지 A가 낸 총 금액 

		System.out.println();


		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 23);	//일요일
		
		userMgr.returns("B", shelfMgr.getBook(3));	//만화책 도라에몽
		userMgr.returns("B", shelfMgr.getBook(4));	//만화책 도라에몽
		userMgr.returns("B", shelfMgr.getBook(5));	//만화책 도라에몽
		userMgr.returns("B", shelfMgr.getBook(6));	//만화책 도라에몽
		
		System.out.println("유저 B가 만화책 4권을 반납했습니다.");
		//도서상태 과제 양식에 맞게 출력
		shelfMgr.simplePrint();
		//대출현황 출력
		userMgr.print();
		System.out.println("만화 반납하고 낸 금액: "+userMgr.getPayedMoney("B"));	//지금까지 B가 낸 총 금액 

		
		System.out.println();


		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 24);	//월요일

		//만화책 반납
		userMgr.returns("A", shelfMgr.getBook(0));
		userMgr.returns("A", shelfMgr.getBook(1));
		userMgr.returns("A", shelfMgr.getBook(2));

		System.out.println("유저A가 만화책3권을 반납했습니다.");
		//도서상태 과제 양식에 맞게 출력
		shelfMgr.simplePrint();
		//대출현황 출력
		userMgr.print();

		System.out.println("A가 모두 반납하고 낸 총액: "+userMgr.getPayedMoney("A"));	//지금까지 A가 낸 총 금액 

		System.out.println();
		
		//user.bin 으로 저장
		userMgr.save();
	
		
		
		ShelfManager.today.set(Calendar.DAY_OF_MONTH, 28);	//그 다음주 금요일
		
		userMgr.returns("B", shelfMgr.getBook(8));	//잡지
		userMgr.returns("B", shelfMgr.getBook(9));	//잡지

		System.out.println("유저 B가 잡지 2권을 반납했습니다.");
		//도서상태 과제 양식에 맞게 출력
		shelfMgr.simplePrint();
		//대출현황 출력
		userMgr.print();
		System.out.println("B가 모두 반납하고 낸 총액: "+userMgr.getPayedMoney("B"));	//지금까지 B가 낸 총 금액 
		System.out.println();
		
		userMgr.save();
	}

}
