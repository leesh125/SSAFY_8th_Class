package week3.day_0726.com.ssafy.exception;

public class InvalidValueException extends Exception {
	private int value;
	
	public InvalidValueException(int value) {
		super("값이 잘못 되었습니다. : " + value);
		this.value = value;
	}
}
