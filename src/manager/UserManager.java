package manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import book.Book;
import book.Rentable;
import user.User;

public class UserManager implements Serializable{
	ArrayList<User> userList = new ArrayList<User>();
	
	public void print(){
		
	}
	
	public boolean returns(String userName, Rentable book){
		User tmp;
		if((tmp=this.getUser(userName))==null)return false;			
		return tmp.returns(book);
	}
	
	public boolean rents(String userName, Rentable book){
		User tmp;
		if((tmp=this.getUser(userName))==null)return false;		
		return tmp.rents(book);
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
