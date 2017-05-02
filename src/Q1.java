/*
 * 	Q1	소설 10권, 만화책 8권, 잡지 3권
*/


import java.util.Calendar;
import book.Book;
import manager.ShelfManager;

public class Q1 {

	public static void main(String[] args) {		
		
		ShelfManager shelfMgr = new ShelfManager();

		//오늘의 날짜 초기화.
		ShelfManager.today = Calendar.getInstance();	
		ShelfManager.today.set(Calendar.HOUR_OF_DAY, 0);
		ShelfManager.today.set(Calendar.MINUTE, 0);
		ShelfManager.today.set(Calendar.SECOND, 0);
		ShelfManager.today.set(Calendar.MILLISECOND, 0);

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

		shelfMgr.print();
		
		shelfMgr.save();
	}

}
