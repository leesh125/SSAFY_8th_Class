package week4.day_0805;

import java.util.Arrays;
import java.util.Collections;

public class SortTest {

	public static void main(String[] args) {

		int[] arr = {4,3,7,9,5};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		String[] locs = {"서울","대전","구미","광주","부울경"};
		System.out.println(Arrays.toString(locs));
		Arrays.sort(locs);
		System.out.println(Arrays.toString(locs));
		Arrays.sort(locs, Collections.reverseOrder());
		System.out.println(Arrays.toString(locs));
		Arrays.sort(locs, (a,b)->b.compareTo(a));
		System.out.println(Arrays.toString(locs));
	}

}
