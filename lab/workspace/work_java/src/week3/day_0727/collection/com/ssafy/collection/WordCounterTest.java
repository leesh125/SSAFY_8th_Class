package week3.day_0727.collection.com.ssafy.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class WordCounterTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 키보드로 문장을 입력받고 단어의 빈도수를 구하라.
		String[] temp = br.readLine().split(" ");
//		HashMap<String, Integer> map = new HashMap<>();
		TreeMap<String, Integer> map = new TreeMap<>();
		
		for(String s : temp) {
			if(map.containsKey(s)) {
				int tmp = map.get(s);
				map.put(s, ++tmp);
			}else {
				map.put(s, 1);
			}
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " : " + val);
		}
	}

}
