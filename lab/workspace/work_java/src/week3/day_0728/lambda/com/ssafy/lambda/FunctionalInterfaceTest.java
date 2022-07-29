package week3.day_0728.lambda.com.ssafy.lambda;

public class FunctionalInterfaceTest {
	
	@FunctionalInterface
	static interface CalcAble{
		int process(int a, int b);
	}
	
	static int run(CalcAble c) {
		// 처리 결과 10, 20
		
		// 작업
		return c.process(10, 20);
	}
	
	public static void main(String[] args) {
		System.out.println(run(new CalcAble() {
			@Override
			public int process(int a, int b) {
				return a + b;
			}
		}));
		
		System.out.println(run((a,b) -> a - b));
		System.out.println(run((a,b) -> a * b));
	}
}
