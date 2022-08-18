package week6.day_0817.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_1541_잃어버린괄호_이석현 {

	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] exp = br.readLine().split("-");
		List<Integer> arr = new ArrayList<>();

		for(int i=0; i<exp.length; i++) {
			sum = 0;
			if(exp[i].contains("+")) {
				String[] temp = exp[i].split("\\+");
				for(String s: temp) {
					sum += Integer.parseInt(s);
				}
				arr.add(sum);
			}else {
				arr.add(Integer.parseInt(exp[i]));
			}
		}
		int val = arr.get(0);
		for(int i=1; i<arr.size(); i++) {
			val -= arr.get(i);
		}
		bw.write(String.valueOf(val));
		bw.flush();
		bw.close();
	}

}
