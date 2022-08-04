package assignment.com.ssafy.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Ex_Browser_이석현 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String[] input;
	static boolean flag = false;
	static Stack<String> backStack = new Stack<>();
	static Stack<String> forwardStack = new Stack<>();
	static String now = "https://www.ssafy.com/";
	static String temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("현재 브라우저: " + now);
			System.out.print("브라우저 명령어 입력: ");
			input = br.readLine().split(" ");
			switch(input[0]) {
			case "V":				
				backStack.push(now);
				forwardStack.clear();
				now = input[1];
				break;
			case "B":
				if(!backStack.isEmpty()) {
					forwardStack.push(now);
					now = backStack.pop();
				}else {
					System.out.println("처음 페이지 입니다.\n");
				}
				break;
			case "F":
				if(!forwardStack.isEmpty()) {
					backStack.push(now);
					now = forwardStack.pop();
				}else {
					System.out.println("마지막 페이지 입니다.\n");
				}
				break;
			case "Q":
				flag = true;
				break;
			}
			if(flag) {
				break;
			}
		}

	}
	
}
