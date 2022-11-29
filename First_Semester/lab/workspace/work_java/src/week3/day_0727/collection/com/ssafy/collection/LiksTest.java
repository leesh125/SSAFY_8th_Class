package week3.day_0727.collection.com.ssafy.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiksTest {

	public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add("Hello"); // Hello
		list.add("SSAFY"); // Hello, SSAFY
//		list.add(10); // Hello, SSAFY, 10
		list.add(new Integer(10)); // Hello, SSAFY, 10
		list.add("Hello"); // Hello, SSAFY, 10, Hello
		list.add(1, "서울 9반"); // Hello, 서울9반, SSAFY , 10, Hello
		for (int i = 0, size = list.size(); i < size; i++) {
			Object o = list.get(i);
//			String o = (String) list.get(i);
			System.out.println(o);
		}
	}

}
