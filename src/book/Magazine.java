package book;

public class Magazine extends Book {

	public Magazine(String title, String author) {
		super(title, author);
		this.info.put("fee", 600);
		this.info.put("type", BookType.Magazine);
	}

}
