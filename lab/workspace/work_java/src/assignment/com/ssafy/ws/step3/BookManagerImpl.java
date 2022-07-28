package assignment.com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManagerImpl implements IBookManager {
	private static final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0; // 현재 책의 갯수
	
	private static BookManagerImpl bookManagerImpl;
	
	private BookManagerImpl() {}
	
	public static synchronized BookManagerImpl getBookManagerImpl() {
		if(bookManagerImpl == null) {
			bookManagerImpl = new BookManagerImpl(); 
		}
		return bookManagerImpl;
	}

	@Override
	public void add(Book book) {
		if(size < MAX_SIZE) {
			books[size++] = book;
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
		
		for(int i=0; i<size; i++) {
			// 삭제할 도서를 찾았다면 해당 도서 위치에 배열의 제일 마지막 도서를 복사
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[size-1];
				books[size-1] = null;		//  삭제된 도서 위치 null 처리
				size--;						// 등록된 고서 갯수 -= 1
				break;
			}
		}
	}
	
	@Override
	public Book[] getList() {
//		return books;
		return Arrays.copyOfRange(books, 0, size);
	}
	
	@Override
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
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
		int idx = 0, count = 0;
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) {
				count++;
			}
		}
		Book[] searchBooks = new Book[count];
		for(int i = 0; i<size; i++) {
			if(books[i].getTitle().contains(title)) {
				searchBooks[idx++] = books[i];
			}
		}
		return searchBooks;
	}
	
	@Override
	public Magazine[] getMagazines() {
		Magazine[] magazines = new Magazine[size];
		int tmpIdx = 0;
		for(Book book: books) {
			if(book == null) break;
			if(book instanceof Magazine) {
				magazines[tmpIdx++] = (Magazine) book;
			}
		}
		return magazines;
	}
	
	@Override
	public Book[] getBooks() {
		Book[] tmpBooks= new Book[size];
		int tmpIdx = 0;
		for(Book book: books) {
			if(book == null) break;
			if(!(book instanceof Magazine)) {
				tmpBooks[tmpIdx++] = book;
			}
		}
		return tmpBooks;
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
		return (sum * 1.0)/ size;
	}
	
	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		if(isExist(isbn)) {
			for(Book book : books) {
				if(book != null && book.getIsbn().equals(isbn)) {
					int afterSell = book.getQuantity() - quantity;
					if(afterSell < 0) {
						throw new QuantityException();
					}else {
						book.setQuantity(afterSell);						
					}
				}
			}
		}else {
			throw new ISBNNotFoundException(isbn);
		}
	}
	
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		if(isExist(isbn)) {
			for(Book book : books) {
				if(book != null && book.getIsbn().equals(isbn)) {
					book.setQuantity(book.getQuantity() + quantity);
				}
			}
		}else {
			throw new ISBNNotFoundException(isbn);
		}
	}
	
	public boolean isExist(String isbn) {
		for(Book book: books) {
			if(book != null && book.getIsbn().equals(isbn)) return true;
		}
		return false;
	}
	
}
