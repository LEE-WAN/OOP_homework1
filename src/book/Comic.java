package book;

public class Comic extends Book {
	public Comic(String title, String author, int id){
		super(title, author, id);
		this.info.put("fee", 200);
		this.info.put("type", BookType.Comic);
	}
}
