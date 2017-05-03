package manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import book.*;

public class ShelfManager implements Serializable{
	/**
	 * 객체식별자로서 임의로 부여한 번호
	 */
	private static final long serialVersionUID = -9157577130052596168L;
	
	/**
	 * 서재
	 */
	ArrayList<Book> shelf = new ArrayList<Book>();
	int lastid=0;
	
	/**
	 * 오늘의 날짜. 
	 */
	public static Calendar today;
	
	public ShelfManager(){
	}
	
	/**
	 * 과제용으로 만든 출력 메소드
	 */
	public void simplePrint(){
		ArrayList<Book> novel = new ArrayList<Book>();
		ArrayList<Book> comic = new ArrayList<Book>();
		ArrayList<Book> megaz = new ArrayList<Book>();

		int rented;
		rented=0;
		
		for(Book book : shelf){
			switch(book.getType()){
				case Novel:
					novel.add(book);
					break;
				case Comic:
					comic.add(book);
					break;
				case Magazine:
					megaz.add(book);
					break;
			}
			if(book.isRented())rented++;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("대여 상태 출력--------------------");
		System.out.println("총 " + (novel.size()+comic.size()+megaz.size()) +"권 중 "+ rented + "권 대여 중입니다. "+ format.format(ShelfManager.today.getTime()));
		System.out.println("------------------------------");
		System.out.print("소설 ==> |");
		for(Book book : novel){
			if(book.isRented())System.out.print(" 대여 |");
			else System.out.print(" 보관 |");
		}
		System.out.println();
		System.out.print("잡지 ==> |");
		for(Book book : megaz){
			if(book.isRented())System.out.print(" 대여 |");
			else System.out.print(" 보관 |");
		}
		System.out.println();
		System.out.print("만화 ==> |");
		for(Book book : comic){
			if(book.isRented())System.out.print(" 대여 |");
			else System.out.print(" 보관 |");
		}
		System.out.println();
		System.out.println("------------------------------");
	}
	
	/**
	 * 서재에있는 도서 하나하나의 정보를 보여줌.
	 */
	public void print(){
		System.out.println("===========================서재 현황");
		System.out.println("id\t종류\t상태\t\t제목\t\t\t작가");
		for(Book book : shelf){
			System.out.println( book.getId() +"\t" + book.getType().toString().substring(0,5) + "\t" + book.getStatus() +"\t" + book.getTitle() +"\t\t" + book.getAuthor());
		}
		System.out.println("===========================서재 현황");
	}
	
	/**
	 * 서제에서 책을 가져와 return해줌
	 * @param bookTitle 책 이름
	 * @return 해당하는 객체
	 */
	public Book getBook(String bookTitle){
		for(Book book : shelf)
			if(book.getTitle() == bookTitle) return book;
		return null;
	}
	
	/**
	 * 서제에서 책을 가져와 return해줌
	 * @param bookid 책 id
	 * @return 해당하는 객체
	 */
	public Book getBook(int bookid){
		for(Book book : shelf)
			if(book.getId() == bookid) return book;
		
		System.err.println("존재하지 않는 id 입니다.");
		return null;
	}
	
	/**
	 * 서재에 책을 추가해주는 메소드
	 * @param type
	 * @param title
	 * @param author
	 * @return
	 */
	public Boolean addBook(Book.BookType type, String title, String author){		
		switch(type){
			case Novel:
				shelf.add(new Novel(title, author, lastid++));
				break;
			case Comic:
				shelf.add(new Comic(title, author, lastid++));
				break;
			case Magazine:
				shelf.add(new Magazine(title,author, lastid++));
				break;
		}
		return true;
	}
	
	/**
	 * 객체체로 불러옴
	 * @return ShelfManager 객체
	 */
	public static ShelfManager load(){
	    ObjectInputStream in;
	    ShelfManager tmp  = null;
		try {
			in = new ObjectInputStream(new FileInputStream("shelf.bin"));
		    tmp = (ShelfManager)in.readObject();
		    in.close();
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
		return tmp;
	}
	
	/**
	 * 객체체로 저장함
	 * @return 성공여부
	 */
	public Boolean save(){
	    ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream("shelf.bin",false));
		    out.writeObject(this);
		    out.flush();
		    out.close();
		    return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void writeObject(ObjectOutputStream out) throws IOException{
		out.writeObject(shelf);
		out.writeInt(lastid);
	}
	public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		shelf = (ArrayList<Book>)in.readObject();
		lastid = in.readInt();
	}
}
