package week5.day_0808.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution_암호문1_이석현 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<Integer> originPass;
	static int[] finalPass;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			originPass = new LinkedList<Integer>();
			
			String[] temp = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				originPass.add(Integer.parseInt(temp[i]));
			}
			int M = Integer.parseInt(br.readLine());
			temp = br.readLine().split(" ");

			for(int i=0; i<temp.length; i++) {
	//			if(temp[i].equals("I")) {
				
				int x = Integer.parseInt(temp[i+1]);
				int y = Integer.parseInt(temp[i+2]);
				for(int j=0; j<y; j++) {
					originPass.add(x++, Integer.parseInt(temp[i+3+j]));
				}
				i += (y + 2);
			}
			bw.write(String.format("#%d ", tc));
			
			int idx = 0;
			Iterator it = originPass.iterator();
			while(it.hasNext() && idx < 10) {
				bw.write(it.next() + " ");
				idx++;
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
