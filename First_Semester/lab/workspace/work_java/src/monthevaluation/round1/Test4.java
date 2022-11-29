package monthevaluation.round1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	static int sum = 0;
	static double avg;
	static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_num = 1; test_num <= T; test_num++) {
			sum = 0; cnt = 0;
			String[] temp = br.readLine().split(" ");
			int team_num = Integer.parseInt(temp[0]);
			int[] scores = new int[team_num];
			
			for(int i=0; i<team_num; i++) {
				scores[i] = Integer.parseInt(temp[i+1]);
				sum += scores[i];
			}
			avg = 1.0 * sum / scores.length;
			
			for(int score: scores) {
				if(score * 1.0 > avg) {
					cnt++;
				}
			}
			
			System.out.printf("#%d %.3f",test_num,1.0*cnt/scores.length*100);
			System.out.println("%");
		}
	}

}
