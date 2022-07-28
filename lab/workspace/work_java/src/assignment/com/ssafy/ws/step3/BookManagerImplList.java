package assignment.com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImplList implements IBookManager {
	private static final int MAX_SIZE = 100;
	private ArrayList<Book> books = new ArrayList<>();
	private int size = 0; // 현재 책의 갯수
	
	private static BookManagerImplList bookManagerImpl;
	
	private BookManagerImplList() {}
	
	public static synchronized BookManagerImplList getBookManagerImpl() {
		if(bookManagerImpl == null) {
			bookManagerImpl = new BookManagerImplList(); 
		}
		return bookManagerImpl;
	}

	@Override
	public void add(Book book) {
		if(books.size() < MAX_SIZE) {
			books.add(book);
		}else {
			System.out.println("책장이 초과상태 입니다.");
		}
	}
	
	@Override
	public void remove(String isbn) {
//		if(size <= 0) {
//			System.out.println("책장이 비어있습니다.");
//		}else {
//			int tmp_idx = 0;
//			boolean bookExist = true;
//			
//			for(int i=0; i<size; i++) {
//				if(books[i].getIsbn() == isbn) {
//					tmp_idx = i;
//					break;
//				}
//				if(i == books.length-1) bookExist = false;
//			}
//			if(!bookExist) {
//				System.out.println("그런 책은 없습니다.");
//			}else {
//				for(int i=tmp_idx; i<books.length-1; i++) {
//					books[i] = books[i+1];
//				}
//				books[books.length-1] = null;
//			}
//		}
		
		for (Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				books.remove(book);
				return;
			}
		}
		System.out.println("그런 책은 없습니다");
		/* for - else 문  */
	}
	
	@Override
	public Book[] getList() {
		Book[] result = new Book[books.size()];
		return books.toArray(result);
//		return books.toArray(new Book[0]);
	}
	
	@Override
	public Book searchByIsbn(String isbn) {
		for (Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
//		for(int i=0; i<size; i++) {
//			if(books[i].getIsbn().equals(isbn)) {
//				return books[i];
//			}
//		}
		return null;
	}
	
	@Override
	public Book[] searchByTitle(String title) {
//		Book[] searchBooks = new Book[size];
//		int tmpIdx = 0;
//		for(int i=0; i<size; i++) {
//			if(books[i].getTitle().contains(title)) {
//				Book copiedBook = new Book(books[i]);
//				searchBooks[tmpIdx++] = copiedBook; // 깊은 복사 해보기
//			}
//		}
//		return searchBooks;
		List<Book> list = new ArrayList<>();
		for(Book book: books) {
			if(book.getTitle().equals(title)) {
				list.add(book);
			}
		}
		Book[] result = new Book[list.size()];
		return books.toArray(result);
	}
	
	@Override
	public Magazine[] getMagazines() {
		List<Magazine> magazines = new ArrayList<>();
//		Magazine[] magazines = new Magazine[size];
		for(Book book: books) {
			if(book != null && book instanceof Magazine) {
				magazines.add((Magazine) book);
			}
		}
		return magazines.toArray(new Magazine[0]);
	}
	
	@Override
	public Book[] getBooks() {
		List<Book> onlyBooks = new ArrayList<>();
//		Magazine[] magazines = new Magazine[size];
		for(Book book: books) {
			if(book != null && !(book instanceof Magazine)) {
				onlyBooks.add(book);
			}
		}
		return onlyBooks.toArray(new Book[0]);
	}
	
	@Override
	public int getTotalPrice() {
		int sum = 0;
		for(Book book: books) {
			if(book == null) break;
			sum += book.getPrice();
		}
		return sum;
	}
	
	@Override
	public double getPriceAvg() {
		int sum = getTotalPrice();
		return (sum * 1.0)/ books.size();
	}

	@Override
	public void sell(String isbn, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buy(String isbn, int quantity) {
		// TODO Auto-generated method stub
		
	}
	
}
