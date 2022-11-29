package week1.day_0714;

public class DataTypeTest {

	public static void main(String[] args) {
//		int price = 100000000;
//		int amount = 30;
//		long totalPrice = price * amount;
//		System.out.println(totalPrice);
		
//		long price = 1000000000; // long = int ==> long = long
//		int amount = 30;
//		long totalPrice = price * amount; // long * int ==> long * long
//		System.out.println(totalPrice);
		
		int price = 100000000;
		int amount = 30;
		long totalPrice = (long)price * amount;
		System.out.println(totalPrice);		
		
		int sum = 100;
		int cnt = 3;
		//double avg = sum/cnt; // int/int ==> int		double = int, double = double
		double avg = (double)sum/cnt; // double/int ==> double		double/double ==> double
		System.out.println(avg);
		System.out.printf("%.2f\n",avg);
		
		double rate = 10.456;
		int rate2 = (int)rate;
		System.out.printf("%.2f%% %d\n", rate,rate2);
	}

}
