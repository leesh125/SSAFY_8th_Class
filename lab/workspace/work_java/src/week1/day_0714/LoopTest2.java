package week1.day_0714;

public class LoopTest2 {

	public static void main(String[] args) {
		
		// 1 ~ 10 까지의 홀수의 누적합 구하기 continue 활용
		// for 문
		int sum = 0;
		for(int i=1; i<=10; i++) {
			if(i % 2 == 0) continue;
			sum += i;
		}
		System.out.println(sum);
		sum = 0;
		
		// while 문
		int j = 0;
		while(++j < 10) {
			if(j % 2 == 0) continue;
			sum += j;
		}
		System.out.println(sum);

	}

}
