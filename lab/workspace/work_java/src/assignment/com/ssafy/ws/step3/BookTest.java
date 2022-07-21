package assignment.com.ssafy.ws.step3;

import java.util.Scanner;

public class BookTest {
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("*********************************도서메뉴*********************************");
		
		BookManager bm = new BookManager();
		bm.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bm.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bm.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		
		System.out.println("*********************************도서목록*********************************");
		getBookList(bm.getList());
		
		System.out.println("*********************************도서조회:21424*********************************");
		String isbn = "21424";
		System.out.println(bm.searchByIsbn(isbn));
		
		System.out.println("*********************************도서삭제:21424*********************************");
		bm.remove(isbn);
		
		System.out.println("*********************************도서목록*********************************");
		getBookList(bm.getList());
		
	}

	static void getBookList(Book[] books) {
		for(Book book:books) {
			if(book != null) {
				System.out.println(book);
			}
		}
	}
}
