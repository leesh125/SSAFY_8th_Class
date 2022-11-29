package week3.day_0728.com.ssafy.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S1_BasicTest {

	public static void main(String[] args) {
		
		String[] arr = {"쿠기", "유지민", "카모"};
		List<String> list = Arrays.asList(arr);
		
		// 오름차순 정렬 후 모든 원소 출력
//		Arrays.sort(arr);
//		for(String s : arr) {
//			System.out.println(s);
//		}
//		
//		Collections.sort(list);
//		for(String s : list) {
//			System.out.println(s);
//		}
		
		System.out.println("==================");
		
		Arrays.stream(arr).sorted().forEach(System.out::println);
		list.stream().sorted().forEach(System.out::println);
		System.out.println(Arrays.toString(arr));
	}

}
