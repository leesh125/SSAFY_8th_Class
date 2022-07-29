 package monthevaluation.round1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5 {

	static int[] dx = {-1,0,1,1};
	static int[] dy = {1,1,1,0};
	static int[][] graph = new int[21][21];
	static int[][][] check = new int[21][21][4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<19; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0; j<temp.length; j++) {
				graph[i][j] = Integer.parseInt(temp[j]);
			}
		}
		System.out.println(find());
		
	}
	
	public static String find() {
		for(int j=0; j<19; j++) {
			for(int i=0; i<19; i++) {
				if(graph[i][j] != 0) {
					for(int k=0; k<4; k++) {
						if(check[i][j][k] == 0 && toFive(i,j,k,graph[i][j]) == 5) {
							return graph[i][j] + "\n" + (i+1) + " " + (j+1) + "\n";
						}
					}
				}
			}
		}
		return "0";
	}
	
	public static int toFive(int x, int y, int dir, int color) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && graph[nx][ny] == color) {
			return check[nx][ny][dir] = toFive(nx, ny, dir, color) + 1;
		}
		return 1;
	}

}
