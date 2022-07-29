package monthevaluation.round1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = 1;
		char a_num = 65;
		
		if(input.equals("1")) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<=i; j++) {
					System.out.print(num++ + " ");
				}
				System.out.println();
			}
		}else if(input.equals("A")) {
			for(int i=1; i<10; i+=2) {
				for(int j=9; j>i; j-=2) {
					System.out.print("  ");
				}
				for(int j=0; j<i; j++) {
					System.out.print(a_num++ + " ");
				}
				System.out.println();
			}
			
		}
	}

}
