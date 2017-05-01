package user;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import book.Book;
import book.Rentable;

public class User implements Serializable{
	String username;
	ArrayList<Rentable> rentedBook = new ArrayList<Rentable>();
	int payedMoney=0;
	
	public User(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return username;
	}
	
	public int getNumOfRentedBooks(){
		return rentedBook.size();
	}
	
	public void printRentedBook(){
		for(Rentable book : rentedBook)
			System.out.println(book.toString());		
	}
	
	public boolean returns(Rentable book){
		int charge = book.getRentalFee();
		if(rentedBook.contains(book))
			if(book.returnBy(username)){
				rentedBook.remove(book);
				payedMoney+=charge;
				return true;
			}
		return false;
	}
	
	public boolean rents(Rentable book){		
		if(getNumOfRentedBooks()>=5)return false;
		
		if(book.rentedBy(username))
			rentedBook.add(book);		
		else return false;
	
		return true;
	}
	
	public void print(){		
	}
	
	@Override
	public String toString(){
		return username;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj.toString().equals(this.toString())) return true;
		return false;		
	}
	
	public void writeObject(ObjectOutputStream out) throws IOException{
		out.writeUTF(username);
		out.writeObject(rentedBook);
		out.writeInt(payedMoney);
	}
	
	public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		username = in.readUTF();
		rentedBook = (ArrayList<Rentable>)in.readObject();
		payedMoney = in.readInt();
	}
}
