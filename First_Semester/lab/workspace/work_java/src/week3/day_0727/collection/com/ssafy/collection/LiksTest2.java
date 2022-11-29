package week3.day_0727.collection.com.ssafy.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiksTest2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Hello"); // Hello
		list.add("SSAFY"); // Hello, SSAFY
		if(!list.contains("Hello")) list.add("Hello"); // Hello, SSAFY, 10, Hello
		list.add(1, "서울 9반"); // Hello, 서울9반, SSAFY , 10, Hello
//		for (int i = 0, size = list.size(); i < size; i++) {
////			Object o = list.get(i);
//			String o = list.get(i);
//			System.out.println(o);
//		}
		printList(list);
		
		list.remove(0);
		System.out.println("=========");
		
		printList(list);
		
		list.clear();
		System.out.println("=========");
		printList(list);
		
	}
	
	static <T> void printList(List<T> list) {
		if(list.size() != 0) {
			for(T data: list) {
				System.out.println(data);
			}
		}else {
			System.out.println("리스트가 비어있음");
		}
	}

}
