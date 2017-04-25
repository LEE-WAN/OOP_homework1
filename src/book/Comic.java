package book;

public class Comic extends Book {
	public Comic(String title, String author){
		super(title, author);
		this.info.put("fee", 200);
		this.info.put("type", BookType.Comic);
	}
}
