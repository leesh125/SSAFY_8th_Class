package com.ssafy.live1.array;

public class ArrayTest_15 {
    public static void main(String[] args) {
        // TODO: 문제에서 제시하는 2차원 배열을 생성하고 내용을 출력하시오.
    	char[][] grid = {{'C','A','A'},
    					 {'C','C','B'},
    					 {'B','A','C'},
    					 {'C','C','C'}};
    	for(char[] charArr: grid) {
    		for(char c: charArr) {
    			System.out.print(c);
    		}
    		System.out.println();
    	}
        // END:
    }
}
