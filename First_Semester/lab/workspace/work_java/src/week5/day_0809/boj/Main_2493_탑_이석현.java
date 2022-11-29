package week5.day_0809.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_2493_탑_이석현 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] nums;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		nums = new int[n];
		ans = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(temp[i]);
		}
		
		for(int i=1; i<n; i++) {
			while(!stack.isEmpty()) {
				int top = stack.peek();
				if(nums[top] > nums[i]) {
					ans[i] = top + 1;
					break;
				}else {
					stack.pop();
				}
			}
			stack.push(i);
		}
		for(int num: ans) {
			bw.write(String.valueOf(num + " "));
		}
		bw.flush();
		bw.close();
	}

}
