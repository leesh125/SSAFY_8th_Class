package week2.day_0720;

public class StringBuilderTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("hello");
		sb.append(" ssafy");
		sb.reverse();
		System.out.println(sb.toString());
		
		System.out.println(new StringBuilder().append("hello")
							.append(" ssafy").reverse().toString());

	}

}
