package assignment.com.ssafy.ws.step3;

import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		books.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		
		System.out.println("*********************************도서목록*********************************");
		for(Book book:books) {
			System.out.println(book);
		}
	}

}
