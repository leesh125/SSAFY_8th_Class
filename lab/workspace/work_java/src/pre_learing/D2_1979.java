package pre_learing;

import java.util.Scanner;

public class D2_1979 {
	
	public static int sum_arr(int N, int K, int[][] graph, int res) {
		for(int i = 0; i < N; i++) { // 가로 가능한지 확인
			for(int j = 0; j <= N-K; j++) {
				boolean flag = false;
				if(j == 0) { // 배열 첫번째 원소일 때
					for(int k=0; k<K; k++) {
						if(graph[i][j+k] == 0) break;
						if(k == K-1) flag = true;
					}
					if(K+1 <= N && graph[i][j+K] == 1) flag = false;
				}else if(j == N-K) { // 배열 마지막 선택할 수 있는 원소일 때
					for(int k=0; k<K; k++) {
						if(graph[i][j+k] == 0) break;
						if(k == K-1) flag = true;
					}
					if(N-K > 0 && graph[i][N-K-1] == 1) flag = false;
				}else { // 배열 중간일 때
					for(int k=0; k<K; k++) {
						if(graph[i][j+k] == 0) break;
						if(k == K-1) flag = true;
					}
					if(graph[i][j-1] == 1 || graph[i][j+K] == 1) flag = false;
				}
				
				if(flag) res++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 0;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] graph = new int[N][N];
			int[][] reverse_graph = new int[N][N];
			int res = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<graph.length; i++) {
				for(int j=0; j<graph[i].length; j++) {
					reverse_graph[j][i] = graph[i][j];
				}
			}
			
			res = sum_arr(N,K,graph,res) + sum_arr(N,K,reverse_graph,res);
			System.out.printf("#%d %d\n", test_case, res);
			
		}
	}

}
