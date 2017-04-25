package book;

public class Novel extends Book {
	public Novel(String title, String author){
		super(title, author);
		this.info.put("fee", 400);
		this.info.put("type", BookType.Novel);
	}
}
