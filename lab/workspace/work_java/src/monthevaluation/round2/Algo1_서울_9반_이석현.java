package monthevaluation.round2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Algo1_서울_9반_이석현 {
	
	static int N,S,M,n1,n2,n3,total;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			n3 = Integer.parseInt(st.nextToken());
			total = n1+n2+n3;
			if(M<=n1 && M<=n2 && M<=n3 && S<=total) {
				cnt++;
				sb.append(n1 + " " + n2 + " " + n3 + " ");
			}
		}
		bw.write(String.valueOf(cnt));
		bw.newLine();
		bw.write(new String(sb));
		bw.newLine();
		bw.flush();
		bw.close();
	}

}
