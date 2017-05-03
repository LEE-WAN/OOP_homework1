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

import book.Book;
import book.Rentable;
import user.User;

public class UserManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2873445505372213629L;
	ArrayList<User> userList = new ArrayList<User>();
	
	public void print(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		System.out.println("===========================대출 현황" + format.format(ShelfManager.today.getTime()));
		System.out.println("유저이름\t\t대출 권수");
		for(User user : userList){
			int num = user.getNumOfRentedBooks();
			System.out.println(user.getUsername() + "\t\t" + num);
			if(num!=0){
				user.printRentedBook();
			}			
		}
		System.out.println("===========================대출 현황");
	}
	public void print(String userName){
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("===========================대출 현황" + format.format(ShelfManager.today.getTime()));
		for(User user : userList)
			if(user.getUsername().equals(userName)){
				int num = user.getNumOfRentedBooks();
				System.out.println(user.getUsername() + "\t\t" + num);
				user.printRentedBook();			
			}
		System.out.println("===========================대출 현황");		
	}
	
	public int clacRentalFee(String userName){
		return getUser(userName).clacRentalFee();		
	}
	
	public boolean returns(String userName, Rentable book){
		if(book == null) return false;
		User tmp;
		if((tmp=this.getUser(userName))==null){
			System.err.println("존재하지 않는 유저입니다. \t" + userName);
			return false;			
		}
		return tmp.returns(book);
	}
	
	public boolean rents(String userName, Rentable book){
		if(book == null) return false;
		User tmp;
		if((tmp=this.getUser(userName))==null){
			System.err.println("존재하지 않는 유저입니다.\t" + userName);
			return false;		
		}
		return tmp.rents(book);
	}
	
	public int getPayedMoney(String userName){
		User tmp;
		if((tmp=getUser(userName))!=null) return tmp.getPayedMoney();
		else return 0;
	}
	
	private User getUser(String userName){
		for(User user : userList)
			if(user.equals(userName))
				return user;
		return null;
	}
	
	public boolean addUser(String userName){
		User tmp = new User(userName);
		for(User user : userList)
			if(user.equals(tmp))return false;
		userList.add(tmp);
		return true;
	}
	
	public static UserManager load(){
	    ObjectInputStream in;
	    UserManager tmp  = null;
		try {
			in = new ObjectInputStream(new FileInputStream("user.bin"));
		    tmp = (UserManager)in.readObject();
		    in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return tmp;
	}
	
	public Boolean save(){
	    ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream("user.bin",false));
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
		out.writeObject(userList);
	}
	public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		userList = (ArrayList<User>)in.readObject();
	}
}
