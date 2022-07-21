package assignment.com.ssafy.ws.step3;

public class BookManager {
	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];;
	private int size = 0; // 현재 책의 갯수
	
	public void add(Book book) {
		if(size < MAX_SIZE) {
			books[size++] = book;
		}else {
			System.out.println("책장이 초과상태 입니다.");
		}
	}
	
	public void remove(String isbn) {
		if(books.length <= 0) {
			System.out.println("책장이 비어있습니다.");
		}else {
			int tmp_idx = 0;
			boolean bookExist = true;
			
			for(int i=0; i<books.length; i++) {
				if(books[i].getIsbn() == isbn) {
					tmp_idx = i;
					break;
				}
				if(i == books.length-1) bookExist = false;
			}
			if(!bookExist) {
				System.out.println("그런 책은 없습니다.");
			}else {
				for(int i=tmp_idx; i<books.length-1; i++) {
					books[i] = books[i+1];
				}
				books[books.length-1] = null;
			}
		}
	}
	
	public Book[] getList() {
		return books;
	}
	
	public Book searchByIsbn(String isbn) {
		for(Book book:books) {
			if(book.getIsbn() == isbn) {
				return book;
			}
		}
		return null;
	}
	
}
