package assignment.com.ssafy.ws.step3;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	
	public Book() {	}

	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return String.format("%.10s| %.10s| %.10s| %.10s| %-6d| %.10s", isbn,title,author,publisher,price,desc);
	}
	
}
