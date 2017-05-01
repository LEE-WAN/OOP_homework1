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
 * @author 2016920036 이완해
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
			System.out.println("오늘의 날짜는 " + ShelfManager.today.getTime().toString());
			shelfMgr.print();
			userMgr.print();
			System.out.println("사용자 이름(아이디)를 입력해 주세요.");
			String userName = sc.nextLine();
			if(!userMgr.addUser(userName)) System.out.println("돌아오신것을 환영합니다.");
			else System.out.println("새로 가입하신것을 환영합니다.");
			for(;;){
				System.out.println("무엇을 하시겠습니까?");
				System.out.println("\t 1.빌린 책 보기");
				System.out.println("\t 2.책 빌리기");
				System.out.println("\t 3.책 반납하기");
				System.out.println("\t 4.로그아웃");
				System.out.println("\t 0.내일로 가기");
				System.out.println("오늘 모든책 반납시 내야할 금액: " + userMgr.clacRentalFee(userName));
				int num = sc.nextInt();
			}
		}
		/*
		userMgr.addUser("A");
		userMgr.addUser("B");
		userMgr.save();

		
		
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
		
		shelfMgr.save();
		*/
	}

}
