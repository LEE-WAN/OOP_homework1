package book;
import java.util.HashMap;
import java.util.Map;


public abstract class Book {
	public static enum BookType{
		Novel,Comic,Magazine
	};
	
	protected Map<String, Object> info = new HashMap<String, Object>();
	
	
	protected Book(String title, String author){
		info.put("title", title);
		info.put("author", author);		
	}
	
	public int getRentalFee(){
		return 0;
	}

	public String getTitle(){
		return (String)info.get("title");
	}
	
	public String getAuthor(){
		return (String)info.get("author");
	}
	
	@Override
	public String toString(){
		return info.toString();
	}
}
