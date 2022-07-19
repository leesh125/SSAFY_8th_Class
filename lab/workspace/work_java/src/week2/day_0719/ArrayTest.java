package week2.day_0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

// 배열 : 고정크기의 동형집합(homogeneous collection)
//		  객체, 참조형 타입

// 데이터타입[] 참조변수 = new 데이터타입[크기];  ==> 배열의 원소값들은 데이터타입의 기본값으로 자동 초기화
// 참조변수[인덱스] ==> 인덱스(offset) : 0 ~ 크기-1
//						ArrayIndexOutofBoundsException
// 배열 사용이유
// 1. 일괄처리
// 2. 원소들을 모아 하나의 단위로 처리(매개변수로 전달하거나 리턴)

public class ArrayTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr2 = {100,90,80};
		
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];
		
		for(int i=0; i<N; i++) {
			scores[i] = Integer.parseInt(br.readLine()); // white 문자 기준으로 token
		}
		
		print(scores);
		System.out.println(Arrays.toString(getGrade(scores)));
//		System.out.println(Arrays.toString(scores));
//		char[] grade = new char[3];
//		System.out.println(Arrays.toString(grade));
		
	}
	
	static void print(int[] arr) {
		for(int i=0, size = arr.length; i<size; i++) {
			System.out.println(arr[i]);
		}
			//		for(int a: arr) {
//			System.out.println(a);
//		}
	}
	
	// 점수배열 받아서 학점배열 리턴
	// 90이상 : A
	// 80이상 : B
	// 70이상 : C
	// 나머지 : F
	public static char[] getGrade(int[] scores) {
		int size = scores.length;
		char[] grades = new char[size];
		
		for(int i=0; i<size; i++) {
			char grade = 'F';
			if(scores[i] >= 90) grade = 'A';
			else if(scores[i] >= 80) grade = 'B';
			else if(scores[i] >= 70) grade = 'C';
			
			grades[i] = grade;
		}
		return grades;
	}
}
