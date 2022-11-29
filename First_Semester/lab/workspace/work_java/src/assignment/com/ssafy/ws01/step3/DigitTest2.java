package assignment.com.ssafy.ws01.step3;

public class DigitTest2 {

	public static void main(String[] args) {
		int idx = 1;
		for(int i=0; i<3; i++) {
			for(int j=5-i*2; j>0; j--) {
				System.out.print(idx++ + " ");
			}
			System.out.println();
		}
		for(int i=1; i<=2; i++) {
			for(int j=0; j<2*i+1; j++) {
				System.out.print(idx++ + " ");
			}
			System.out.println();
		}

	}

}
