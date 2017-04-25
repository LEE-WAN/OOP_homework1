package manager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import book.*;
public class ShelfManager {
	ArrayList<Book> shelf = new ArrayList<Book>();
	Calendar today;
	public ShelfManager(){
		today = Calendar.getInstance();	
	}
	
	public Boolean addBook(Book.BookType type, String title, String author){		
		switch(type){
			case Novel:
				shelf.add(new Novel(title, author));
				break;
			case Comic:
				shelf.add(new Comic(title, author));
				break;
			case Magazine:
				shelf.add(new Magazine(title,author));
				break;
		}
		return true;
	}
	
	
	public Boolean save(){
	    ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream("shelf.bin"));
		    out.writeObject(shelf);
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
}
