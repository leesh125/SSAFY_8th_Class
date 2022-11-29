package week3.day_0728.lambda.com.ssafy.lambda;

import java.util.ArrayList;

public class CollectionTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) list.add(i);
		
		list.removeIf(e -> e%2 ==0);
		list.replaceAll(e->e+10);
		list.forEach(System.out::println);
	}

}
