package assignment.com.ssafy.ws.step3;

//import java.util.Scanner;

public class BookTest {
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("*********************************도서메뉴*********************************");
		
		IBookManager bm = BookManagerImpl.getBookManagerImpl();
		bm.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bm.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bm.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		bm.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1));
		
		System.out.println("*********************************도서 전체 목록*********************************");
		getBookList(bm.getList());
		
		System.out.println("*********************************일반 도서 목록*********************************");
		getBookList(bm.getBooks());
		
		System.out.println("*********************************잡지 목록*********************************");
		getBookList(bm.getMagazines());
		
		System.out.println("*********************************도서 제목 포함검색*********************************");
		getBookList(bm.searchByTitle("Java"));
		
		System.out.println("도서 가격 총합 : " + bm.getTotalPrice());
		System.out.println("도서 가격 평균 : " + bm.getPriceAvg());
	}
	
	static void getBookList(Book[] books) {
		for(Book book:books) {
			if(book != null) {
				System.out.println(book);
			}else {
				break;
			}
		}
	}
}
