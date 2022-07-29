package week3.day_0726.com.ssafy.exception;

import java.io.IOException;

public class ExceptionTest {

	public static void main(String[] args) throws InvalidValueException {
		
		System.out.println(MyUtil.readLog());
		
		try {
			MyUtil.logging("오늘 하루도 고생 많았습니다!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(MyUtil.division(10, 0));
		} catch (InvalidValueException e) {
			e.printStackTrace();
		}
		System.out.println(MyUtil.division(10, 3));
		System.out.println("main end ----------------");
		MyUtil.readLog();
		
	}

}
