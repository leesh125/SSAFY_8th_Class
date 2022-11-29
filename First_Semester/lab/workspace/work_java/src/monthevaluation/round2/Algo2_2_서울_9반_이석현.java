package monthevaluation.round2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Algo2_2_서울_9반_이석현 {
	
	static int V,P;
	static long L,answer;
	static long[] home,ansArr;
	static int[] ansIdx;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        home = new long[V];
        ansIdx = new int[P];
        ansArr = new long[P];
        answer = Long.MAX_VALUE;
        long[][] map = new long[V+1][V];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<V; i++) {
            home[i] = Long.parseLong(st.nextToken());
        }
        for(int j=0; j<V; j++) {
            for(int i=0; i<V; i++) {
                map[i][j] = Math.min(Math.abs(home[i] - home[j]), L - Math.abs(home[i] - home[j]));
            }
        }

        dfs(0, map);
        Arrays.sort(ansArr);
        sb.append(answer).append('\n');
		for(int i=0; i<P-1; i++) {
			sb.append(ansArr[i]).append(' ');
		}
		sb.append(ansArr[P-1]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static void dfs(int cnt, long[][] map) {
		if(cnt==P) {
			long num = ans(map);
			if(answer > num) {
				answer = num;
				for(int i=0; i<P; i++) {
					ansArr[i] = home[ansIdx[i]];
				}
			}
			return;
		}
		
		sum(map); 
		List<Integer> list = min(map);
		int size = list.size();
		for(int i=0; i<size; i++) {
			
			long[][] temp = new long[V+1][V];
			for(int j=0; j<V+1; j++) {
				temp[j] = map[j].clone();
			}
			
			change(list.get(i), temp);
			ansIdx[cnt] = list.get(i);
			dfs(cnt+1, temp);
		}
	}
	
	public static long ans(long[][] map) {
		long ans = 0;
		for(int i=0; i<V; i++) {
			long min = Long.MAX_VALUE;
			for(int j=0; j<P; j++) {
				if(min>map[i][ansIdx[j]]) {
					min = map[i][ansIdx[j]];
				}
			}
			ans += min;
		}
		return ans;
	}
	
	public static void change(int idx, long[][] map) {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (map[i][j] > map[i][idx])
					map[i][j] = map[i][idx];
			}
		}
	}
	
	public static List<Integer> min(long[][] map){
		long min = Long.MAX_VALUE;
		for (int i = 0; i < V; i++) {
			if (min > map[V][i]) {
				min = map[V][i];
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<V; i++) {
			if(min==map[V][i]) list.add(i);
		}
		return list;
	}
	
	public static void sum(long[][] map) {
		for (int j = 0; j < V; j++) {
			long sum = 0;
			for (int i = 0; i < V; i++) {
				sum += map[i][j];
			}
			map[V][j] = sum;
		}
	}
}