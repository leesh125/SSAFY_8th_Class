package monthevaluation.round2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Algo2_1_서울_9반_이석현 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N,M;
	static int total;
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			total = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			combination(0,0);			
			sb.append("#").append(tc+" ").append(total).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	
	}
	
	public static void combination(int cnt, int idx) {
		if(cnt == M) {
			total++;
			return;
		}
		for(int i = idx; i<N; i++) {
			combination(cnt+1,i+1);
		}
	}
}
