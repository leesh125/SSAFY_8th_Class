package assignment.com.ssafy.ws.step3;

public class ISBNNotFoundException extends Exception {
	
	private String isbn;
	
	public ISBNNotFoundException(String isbn) {
		super(isbn + " : 해당 도서의 ISBN이 존재하지 않습니다.");
	}

	public String getIsbn() {
		return isbn;
	}	
	
}
