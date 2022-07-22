package assignment.com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManager {
	private static final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0; // 현재 책의 갯수
	
	public void add(Book book) {
		if(size < MAX_SIZE) {
			books[size++] = book;
		}else {
			System.out.println("책장이 초과상태 입니다.");
		}
	}
	
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
	
	public Book[] getList() {
//		return books;
		return Arrays.copyOfRange(books, 0, size);
	}
	
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
	
}
