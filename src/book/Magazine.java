package book;

public class Magazine extends Book {

	public Magazine(String title, String author, int id) {
		super(title, author, id);
		this.info.put("fee", 600);
		this.info.put("type", BookType.Magazine);
	}

}
