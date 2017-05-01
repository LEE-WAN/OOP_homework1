package book;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import manager.ShelfManager;


public abstract class Book implements Serializable, Rentable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3765761612414737642L;

	public static enum BookType{
		Novel,Comic,Magazine
	};
	public static enum Status{
		Available,NotAvailable,Unknown
	};
		
	protected Map<String, Object> info = new HashMap<String, Object>();
	int id;
	

	public void print(){
		for(String str : info.keySet())
			System.out.print(str + "\t" + info.get(str)+"\n");		
		System.out.println();
	}
	
	protected Book(String title, String author, int id){
		this.id = id;
		info.put("title", title);
		info.put("author", author);
		info.put("status", Status.Available);
	}
	
	@Override
	public Boolean rentedBy(String username){
		if(getStatus()!=Status.Available)return false;		
		info.put("status", Status.NotAvailable);
		info.put("rentUser", username);
		info.put("rentDay", ShelfManager.today);		
		return true;
	}
	

	@Override
	public Boolean returnBy(String username){
		if(username!=info.get("rentUser")) return false;
		info.put("status", Status.Available);
		info.remove("rentUser");
		info.remove("rentDay");
		return true;
	}
	
	@Override
	public int getRentalFee(){
		if((Status)info.get("status")==Status.Available)
			return 0;
		Calendar pastday = (Calendar)info.get("rentDay");
		Calendar today = ShelfManager.today;
		
		int days = (int)((today.getTimeInMillis() - pastday.getTimeInMillis())/(1000*60*60*24));
		int ChargeRate = getChargeRate();
		
		if(days<=3) return ChargeRate;
		else{
			days-=3;
			return ChargeRate + days*ChargeRate/2;
		}
	}
	
	public int getId(){
		return id;
	}
	
	public Status getStatus(){
		return (Status)info.get("status");
	}
	
	@Override
	public boolean isRented(){
		if(getStatus()==Status.Available) return false;
		return true;
	}
	
	public BookType getType(){
		return (BookType)info.get("type");
	}

	public String getTitle(){
		return (String)info.get("title");
	}
	
	public String getAuthor(){
		return (String)info.get("author");
	}

	public int getChargeRate(){
		return (int)info.get("fee");
	}
	
	@Override
	public String toString(){
		String str = "";
		str += getTitle();
		str += ",\t";
		str += getAuthor();
		if(isRented())
			str += ",\tRented by: "+ info.get("rentUser") +"\t at: " + ((Calendar)info.get("rentDay")).getTime();		
		return str;
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Book){
			if( ((Book)obj).id == this.id) return true;
		}
		return false;
	}
	
	public void writeObject(ObjectOutputStream out) throws IOException{
		out.writeObject(info);
		out.writeInt(id);
	}
	
	public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		info = (Map<String, Object>)in.readObject();
		id = in.readInt();
	}
}
