package week4.day_0805;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_Ex_Mychew {

	public static void main(String[] args) {
		
		int N = 20;
		int person = 1;
		Queue<int []> queue = new LinkedList<>();
		queue.offer(new int[] {person,1});
		int[] p;
		int availableCnt = 0;
		
		while(N>0) {
			if(!queue.isEmpty()) {
				p = queue.poll();
				availableCnt = (N>=p[1]) ? p[1]:N;
				N -= availableCnt;
				if(N == 0) {
					System.out.println("마지막 마이쮸를 가져간 사람: " + p[0] + "번, " + "가져간 갯수:" + p[1] );
				}else {
					System.out.println("가장 최근 마이쮸를 가져간 사람: " + p[0] + "번, " + "가져간 갯수:" + p[1] );
					p[1]++;
					queue.add(p);
					queue.add(new int[] {++person,1});
				}
			}
		}
	}

}
