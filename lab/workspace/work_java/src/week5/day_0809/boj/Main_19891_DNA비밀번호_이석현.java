package week5.day_0809.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main_19891_DNA비밀번호_이석현 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Map<Character, Integer> map = new HashMap<Character,Integer>();
	static Map<Character, Integer> tempMap = new HashMap<Character,Integer>();
	static char[] pass = {'A', 'C', 'G', 'T'};
	static boolean flag;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int length = Integer.parseInt(temp[0]);
		int sub_length = Integer.parseInt(temp[1]);
		char[] str = br.readLine().toCharArray();
		temp = br.readLine().split(" ");
		ans = 0;

		for(int idx=0; idx<4; idx++) {
			map.put(pass[idx], Integer.parseInt(temp[idx]));
			tempMap.put(pass[idx], 0);
		}

		for(int i=0; i<sub_length; i++) {
			tempMap.put(str[i], tempMap.get(str[i]) + 1);
		}
		if(isCorrect()) ans++;
		
		for(int i=0; i<length-sub_length; i++) {
			tempMap.put(str[i], tempMap.get(str[i]) - 1);
			tempMap.put(str[i+sub_length], tempMap.get(str[i+sub_length]) + 1);
			if(isCorrect()) ans++;
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	private static boolean isCorrect() {
		for(char c: pass) {
			if(map.get(c) > tempMap.get(c)) return false;
		}
		return true;
	}

}
