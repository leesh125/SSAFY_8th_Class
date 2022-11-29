package week2.day_0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CharMultiDimensionArrayTest {

	// 1반 학생들의 학점점수가 문자열로 입력 (ABCAA)
	// 총 3반이 입력
	// 모든반의 학생 학점정보를 char[][]
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = 3;
		char[][] grades = new char[3][5];
		for(int i=0; i<n; i++) {
			grades[i] = sc.nextLine().toCharArray();
		}
//		for(int i=0; i<3; i++) {
//			String[] temp = br.readLine().split("");
//			for(int j=0; j<temp.length; j++) {
//				grades[i][j] = temp[j].charAt(0);
//			}
//		}
		System.out.println(Arrays.deepToString(grades));
		
	}

}
