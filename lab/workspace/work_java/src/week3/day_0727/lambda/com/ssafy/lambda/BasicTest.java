package week3.day_0727.lambda.com.ssafy.lambda;

public class BasicTest {

	static class MyRunnable implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}};
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread1....");
			}
		}).start();
		new Thread(() -> {
			System.out.println("Thread2....");
		}).start();
		
		new Thread(() -> System.out.println("Thread5...."));
		
		new Thread(new MyRunnable()).start();
	}


}
