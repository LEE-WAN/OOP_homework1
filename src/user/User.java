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
	/**
	 * 
	 */
	private static final long serialVersionUID = 2573068999692993453L;
	String username;
	
	/**
	 * Rentable 인터페이스만 만족하면 어떤 오브젝트던 빌릴수 있음.
	 * 책을 빌리면 (Rentable).rentedBy(userName)을 호출하고 rentedBook 에 저장해 놓는 방식.
	 */
	ArrayList<Rentable> rentedBook = new ArrayList<Rentable>();
	int payedMoney=0;
	
	public User(String username){
		this.username = username;
	}
	
	public int getPayedMoney(){
		return payedMoney;
	}
	
	public String getUsername(){
		return username;
	}
	
	public int getNumOfRentedBooks(){
		return rentedBook.size();
	}
	
	public void printRentedBook(){
		for(Rentable book : rentedBook)
			System.out.println("\t" + book.toString());		
	}
	
	public int clacRentalFee(){
		int charge = 0;
		for(Rentable book : rentedBook)
			charge += book.getRentalFee();		
		return charge;
	}
	
	public boolean returns(Rentable book){
		int charge = book.getRentalFee();
		if(rentedBook.contains(book)){
			if(book.returnBy(username)){
				rentedBook.remove(book);
				payedMoney+=charge;
				return true;
			}
			else
				return false;
		}
		else{			
			System.err.println("자신이 빌린 책이 아닙니다.");
			return false;
		}
		
	}
	
	public boolean rents(Rentable book){		
		if(getNumOfRentedBooks()>=6){
			System.err.println("대출가능한 권수는 최대 6권입니다.");
			return false;
		}
		
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
