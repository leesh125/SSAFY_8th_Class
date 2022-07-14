package week1.day_0714;

public class LoopTest {

	public static void main(String[] args) {
		
		// 1 ~ 10 까지의 누적 합 구하기
		int sum = 0;
		// for 문
		for(int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println(sum);
		sum = 0;
		
		// while 문
		int j = 1;
		while(j <= 10) {
			sum += j;
			j++;
		}
		System.out.println(sum);

	}

}
