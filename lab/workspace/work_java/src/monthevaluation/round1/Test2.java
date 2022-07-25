package monthevaluation.round1;

public class Test2 {

	public static void main(String[] args) {
		int[] su= { 45, 80, 68, 19, 34, 55, 27, 60, 27, 18 };
		int sum = 0, max_diff = Integer.MIN_VALUE, max=0;
		double avg = 0;
		
		for(int n: su) {
			sum += n;
		}
		avg = 1.0 * sum / su.length;
		
		for(int i=0; i<su.length; i++) {
			if(Math.abs((int)(su[i]*10 - avg*10)) > max_diff) {
				max_diff = Math.abs((int)(su[i]*10 - avg*10));
				max = su[i];
			}
		}
		System.out.println(avg + " " + max);
		
	}

}
