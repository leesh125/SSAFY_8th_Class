package week4.day_0805;

import java.util.Arrays;

public class TwoDimenArrayTest {

    public static void main(String[] args) {

        int[][] arr = {{1,10}, {2,5}, {3,20}, {4,10}};
        
        System.out.println(Arrays.deepToString(arr));
        
        // 첫번째 원소 내림차순
        Arrays.sort(arr, (a,b) -> b[0]-a[0]);
        System.out.println(Arrays.deepToString(arr));
        
        // 두번째 원소 오름차순
        Arrays.sort(arr, (a,b) -> a[1]-b[1]);
        System.out.println(Arrays.deepToString(arr));
        
        // 배열 두번째원소 기준 오름차순, 같다면 첫번째 원소 기준 오름차순
        arr = new int[][] {{1,10}, {1,5}, {3,20}, {4,10}};
//        Arrays.sort(arr, (a,b) -> {
//            if (a[0]==b[0])
//                return a[1]-b[1];
//            return a[0]-b[0];
//        });
        Arrays.sort(arr, (a,b) -> a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]);
        System.out.println(Arrays.deepToString(arr));
    }

}
