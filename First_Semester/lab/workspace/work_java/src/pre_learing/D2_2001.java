package pre_learing;

import java.util.Scanner;

public class D2_2001 {

	public static int getMax(int[][] graph, int M, int N) {
		int sum = 0, tmp = 0;
		for(int i = 0; i <= N-M; i++) {
			for(int j = 0; j <= N-M; j++) {
				tmp = 0;
				for(int k = i; k < i+M; k++) {
					for(int z = j; z < j+M; z++) {
						tmp += graph[k][z];
					}
				}
				sum = (sum < tmp) ? tmp : sum;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int graph[][] = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			
			System.out.printf("#%d %d\n", test_case, getMax(graph, M, N));
		}

	}

}
