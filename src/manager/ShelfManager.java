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
	 * ��ü�ĺ��ڷμ� ���Ƿ� �ο��� ��ȣ
	 */
	private static final long serialVersionUID = -9157577130052596168L;
	
	/**
	 * ����
	 */
	ArrayList<Book> shelf = new ArrayList<Book>();
	int lastid=0;
	
	/**
	 * ������ ��¥. 
	 */
	public static Calendar today;
	
	public ShelfManager(){
	}
	
	/**
	 * ���������� ���� ��� �޼ҵ�
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
		System.out.println("�뿩 ���� ���--------------------");
		System.out.println("�� " + (novel.size()+comic.size()+megaz.size()) +"�� �� "+ rented + "�� �뿩 ���Դϴ�. "+ format.format(ShelfManager.today.getTime()));
		System.out.println("------------------------------");
		System.out.print("�Ҽ� ==> |");
		for(Book book : novel){
			if(book.isRented())System.out.print(" �뿩 |");
			else System.out.print(" ���� |");
		}
		System.out.println();
		System.out.print("���� ==> |");
		for(Book book : megaz){
			if(book.isRented())System.out.print(" �뿩 |");
			else System.out.print(" ���� |");
		}
		System.out.println();
		System.out.print("��ȭ ==> |");
		for(Book book : comic){
			if(book.isRented())System.out.print(" �뿩 |");
			else System.out.print(" ���� |");
		}
		System.out.println();
		System.out.println("------------------------------");
	}
	
	/**
	 * ���翡�ִ� ���� �ϳ��ϳ��� ������ ������.
	 */
	public void print(){
		System.out.println("===========================���� ��Ȳ");
		System.out.println("id\t����\t����\t\t����\t\t\t�۰�");
		for(Book book : shelf){
			System.out.println( book.getId() +"\t" + book.getType().toString().substring(0,5) + "\t" + book.getStatus() +"\t" + book.getTitle() +"\t\t" + book.getAuthor());
		}
		System.out.println("===========================���� ��Ȳ");
	}
	
	/**
	 * �������� å�� ������ return����
	 * @param bookTitle å �̸�
	 * @return �ش��ϴ� ��ü
	 */
	public Book getBook(String bookTitle){
		for(Book book : shelf)
			if(book.getTitle() == bookTitle) return book;
		return null;
	}
	
	/**
	 * �������� å�� ������ return����
	 * @param bookid å id
	 * @return �ش��ϴ� ��ü
	 */
	public Book getBook(int bookid){
		for(Book book : shelf)
			if(book.getId() == bookid) return book;
		
		System.err.println("�������� �ʴ� id �Դϴ�.");
		return null;
	}
	
	/**
	 * ���翡 å�� �߰����ִ� �޼ҵ�
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
	 * ��üü�� �ҷ���
	 * @return ShelfManager ��ü
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
	 * ��üü�� ������
	 * @return ��������
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
