package client;

import java.util.ArrayList;
import book.Book;

public class User {
	String username;
	ArrayList<Book> rentedBook = new ArrayList<Book>();
	int payedMoney=0;
	
	public String getUsername(){
		return username;
	}
	
	public int getNumOfRentedBooks(){
		return rentedBook.size();
	}
	
	public void printRentedBook(){
		for(Book book : rentedBook)
			System.out.println(book.toString());		
	}
	
	public boolean returnBook(Book book){
		int charge = book.getRentalFee();
		if(rentedBook.contains(book))
			if(book.returnBy(username)){
				rentedBook.remove(book);
				payedMoney+=charge;
				return true;
			}
		return false;
	}
	
	public boolean rentBook(Book book){		
		if(getNumOfRentedBooks()>=5)return false;
		
		if(book.rentedBy(username))
			rentedBook.add(book);		
		else return false;
	
		return true;
	}
}
