package week3.day_0727.lambda.com.ssafy.lambda;

import java.util.Arrays;
import java.util.List;

public class AdvancedTest {

	public static void main(String[] args) {
		Integer[] arr = {3,5,1,2,7};
//		Arrays.sort(arr, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1; // 내림차순
//			}
//		});
		Arrays.sort(arr, (o1, o2) -> o1 - o2);
		System.out.println(Arrays.toString(arr));
		
		List<Integer> list = Arrays.asList(10,20,30);
		
//		list.forEach(e -> {System.out.println(e);});
//		list.forEach(e -> System.out.println(e));
		list.forEach(System.out::println);
	}

}
