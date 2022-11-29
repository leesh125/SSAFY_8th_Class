package assignment.com.ssafy.ws01.step3;

public class DigitTest1 {

	public static void main(String[] args) {
		int idx = 1;
		for(int i=0; i<5; i++) {
			for(int j=5-i; j>0; j--) {
				System.out.print(idx++ + " ");
			}
			System.out.println();
		}
	}
}
