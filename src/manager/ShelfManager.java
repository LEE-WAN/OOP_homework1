package manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import book.*;

public class ShelfManager implements Serializable{
	ArrayList<Book> shelf = new ArrayList<Book>();
	int lastid=0;
	public static Calendar today;
	
	public ShelfManager(){
		today = Calendar.getInstance();	
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
	}
	
	public void print(){
		
	}
	
	public Book getBook(String bookTitle){
		for(Book book : shelf)
			if(book.getTitle() == bookTitle) return book;
		return null;
	}
	
	public Book getBook(int bookid){
		for(Book book : shelf)
			if(book.getId() == bookid) return book;
		return null;
	}
	
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
	
	public static ShelfManager load(){
	    ObjectInputStream in;
	    ShelfManager tmp  = null;
		try {
			in = new ObjectInputStream(new FileInputStream("shelf.bin"));
		    tmp = (ShelfManager)in.readObject();
		    in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	
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
