package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BookManagerImplMap implements IBookManager {
	private static final int MAX_SIZE = 100;
	private HashMap<String, Book> books = new HashMap<>();
	
	private static BookManagerImplMap bookManagerImpl;
	
	private BookManagerImplMap() {}
	
	public static synchronized BookManagerImplMap getBookManagerImpl() {
		if(bookManagerImpl == null) {
			bookManagerImpl = new BookManagerImplMap(); 
		}
		return bookManagerImpl;
	}

	@Override
	public void add(Book book) {
		if(books.size() < MAX_SIZE) {
			books.put(book.getIsbn(), book);
//			books[size++] = book;
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
		
		if(books.get(isbn) != null) {
			books.remove(isbn);
		}else {
			System.out.println("그런 책은 없습니다.");
		}
	}
	
	@Override
	public Book[] getList() {
//		return books;
		return books.values().toArray(new Book[0]);
//		return Arrays.copyOfRange(books, 0, size);
	}
	
	@Override
	public Book searchByIsbn(String isbn) {
		if(books.get(isbn) != null) return books.get(isbn);
		return null;
	}
	
	@Override
	public Book[] searchByTitle(String title) {
//		int idx = 0;
//		List<String> isbnList = new ArrayList<>(); 
//		Iterator<Book> it = books.values().iterator();
//		while(it.hasNext()) {
//			if(it.next().getTitle().equals(title)) {
//				it.
//			}
//			isbnList.add(it.next().getIsbn()); 
//		}
//		Book[] searchBooks = new Book[isbnList.size()];
//		for (String s : isbnList) {
//			searchBooks[idx++] = books.get(s);
//		}
//		return searchBooks;
		int idx = 0, count = 0;
		for(Book book: books.values()) {
			if(book.getTitle().contains(title)) {
				count++;
			}
		}
		Book[] searchBooks = new Book[count];
		for(Book book: books.values()) {
			if(book.getTitle().contains(title)) {
				searchBooks[idx++] = book;
			}
		}
		
		return searchBooks;
	}
	
	@Override
	public Magazine[] getMagazines() {
		
		List<Magazine> magazines = new ArrayList<>();
//		Magazine[] magazines = new Magazine[size];
		for(Book book: books.values()) {
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
		for(Book book: books.values()) {
			if(book != null && !(book instanceof Magazine)) {
				onlyBooks.add(book);
			}
		}
		return onlyBooks.toArray(new Book[0]);
	}
	
	@Override
	public int getTotalPrice() {
		int sum = 0;
		for(Book book: books.values()) {
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
	
}
