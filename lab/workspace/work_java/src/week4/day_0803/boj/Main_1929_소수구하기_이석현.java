package week4.day_0803.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1929_소수구하기_이석현 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int start;
	static int end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		start = Integer.parseInt(temp[0]);
		end = Integer.parseInt(temp[1]);
		
		for(int i=start; i<=end; i++) {
			if(isPrime(i)) {
				bw.write(String.valueOf(i));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}

	static boolean isPrime(int num) {
		if(num == 1) return false;
		if(num == 2 || num == 3) return true;
		for(int i=2; i<=(int)Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
