package week5.day_0808.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1225_암호생성기_이석현 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] cycle = {1,2,3,4,5};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			String[] temp = br.readLine().split(" ");
			Queue<Integer> queue = new LinkedList<Integer>();
			
			for(String s: temp) {
				queue.add(Integer.parseInt(s)); 
			}
			
			int cnt = 5;
			while(true) {
				int head = queue.poll();
				if(head - cycle[cnt%5] <= 0) {
					queue.add(0);
					break;
				}
				queue.add(head - cycle[cnt%5]);
				cnt++;
			}
			
			bw.write(String.format("#%d ", tc));
			
			Iterator iter = queue.iterator();
			while(iter.hasNext()) bw.write(iter.next() + " ");
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
