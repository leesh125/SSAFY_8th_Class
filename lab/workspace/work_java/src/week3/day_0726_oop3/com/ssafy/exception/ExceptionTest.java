package week3.day_0726_oop3.com.ssafy.exception;

import java.io.IOException;

public class ExceptionTest {

	public static void main(String[] args) {
		
		System.out.println(MyUtil.readLog());
		
		try {
			MyUtil.logging("오늘 하루도 고생 많았습니다!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(MyUtil.division(10, 2));
		System.out.println(MyUtil.division(10, 3));
		System.out.println("main end ----------------");
		MyUtil.readLog();
	}

}
